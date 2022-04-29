package com.inc.vr.corp.apps.rawgames.ui.fragments.rating

import android.annotation.SuppressLint
import android.app.SearchManager
import android.content.Context
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.SearchView
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.inc.vr.corp.apps.rawgames.network.dto.Models
import com.inc.vr.corp.apps.rawgames.R
import com.inc.vr.corp.apps.rawgames.ui.base.BaseFragment

import kotlinx.android.synthetic.main.fragment_rating_list.*
import timber.log.Timber

class RatingFragment : BaseFragment<PagedList<Models.RatingResult>, RatingViewModel>(){

    override fun handleState(state: PagedList<Models.RatingResult>) {
        render(state)
    }

    private val clickListener: ClickListener = this::onGameClicked

    private fun onGameClicked(game: Models.RatingResult) {
        view?.let {
            findNavController(it).navigate(
                RatingFragmentDirections.actionRatingFragmentToGameFragment(
                    //
                )
            )
        }
    }

    private val gameListAdapter =
        RatingAdapter(clickListener)


    override fun getLayout(): Int {
        return R.layout.fragment_rating_list
    }

    override fun onCreateCompleted() {
        initRecyclerView()
        createViewModel(RatingViewModel::class.java)
        //set default value for searchView
        viewModel.setFilter(getString(R.string.search_filter_default_value))

    }


    private fun render(pagedGameList: PagedList<Models.RatingResult>) {
        gameListAdapter.submitList(pagedGameList)
        Timber.d("pagedGameList : %s", pagedGameList)
    }

    private fun initRecyclerView() {
        recyclerView2.apply {
            setHasFixedSize(false)
            layoutManager = LinearLayoutManager(context)
            adapter = gameListAdapter
        }

    }



}