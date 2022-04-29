package com.inc.vr.corp.apps.rawgames.ui.fragments.cari

import android.annotation.SuppressLint
import android.app.SearchManager
import android.content.Context
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.SearchView
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.inc.vr.corp.apps.rawgames.network.dto.Models
import com.inc.vr.corp.apps.rawgames.R
import com.inc.vr.corp.apps.rawgames.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_cari.*


import kotlinx.android.synthetic.main.fragment_rating_list.*
import timber.log.Timber

class CariFragment : BaseFragment<PagedList<Models.CariResult>, CariViewModel>(){

    override fun handleState(state: PagedList<Models.CariResult>) {
        render(state)
    }
    private val clickListener: ClickListener = this::onGameClicked

    private fun onGameClicked(game: Models.CariResult) {
        view?.let {
            Navigation.findNavController(it).navigate(
                CariFragmentDirections.actionCariFragmentToGameFragment(

                )
            )
        }
    }
    private val cariAdapter = CariAdapter(clickListener)

    override fun getLayout(): Int {
        return R.layout.fragment_cari
    }

    override fun onCreateCompleted() {
        initRecyclerView()
        createViewModel(CariViewModel::class.java)
        //set default value for searchView
        //get bundle from previous fragment
        val bundle = this.arguments
        if (bundle != null) {
            val search = bundle.getString("query")
            Timber.d("query: $search")
            if (search != null) {
                viewModel.setFilter(search)
            }
        }

    }


    private fun render(pagedGameList: PagedList<Models.CariResult>) {
        cariAdapter.submitList(pagedGameList)
        Timber.d("pagedGameList : %s", pagedGameList)
    }

    private fun initRecyclerView() {
        recyclerView.apply {
            setHasFixedSize(false)
            layoutManager = LinearLayoutManager(context)
            adapter = cariAdapter
        }

    }


}