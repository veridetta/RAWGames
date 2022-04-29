package com.inc.vr.corp.apps.rawgames.ui.fragments.games

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

import kotlinx.android.synthetic.main.fragment_game_list.*
import timber.log.Timber

class GamesFragment : BaseFragment<PagedList<Models.GameResults>, GamesViewModel>(){

    override fun handleState(state: PagedList<Models.GameResults>) {
        render(state)
    }

    private val clickListener: ClickListener = this::onGameClicked

    private fun onGameClicked(game: Models.GameResults) {
        view?.let {
            findNavController(it).navigate(
                GamesFragmentDirections.actionGamesFragmentToRatingFragment(

                )
            )
        }
    }

    private val gameListAdapter = GameAdapter(clickListener)


    override fun getLayout(): Int {
        return R.layout.fragment_game_list
    }

    override fun onCreateCompleted() {
        initRecyclerView()
        createViewModel(GamesViewModel::class.java)
        //set default value for searchView
        viewModel.setFilter(getString(R.string.search_filter_default_value))

    }


    private fun render(pagedGameList: PagedList<Models.GameResults>) {
        gameListAdapter.submitList(pagedGameList)
        Timber.d("pagedGameList : %s", pagedGameList)
    }

    private fun initRecyclerView() {
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = gameListAdapter
        }

    }

}