package com.inc.vr.corp.apps.rawgames.ui.fragments.gameDetail


import com.inc.vr.corp.apps.rawgames.R
import com.inc.vr.corp.apps.rawgames.ui.base.BaseFragment


class GameDetailFragment : BaseFragment<Boolean, GameDetailViewModel>() {

    override fun handleState(state: Boolean) {}

    override fun getLayout(): Int = R.layout.fragment_game


    override fun onCreateCompleted() {
        setHasOptionsMenu(true)
        createViewModel(GameDetailViewModel::class.java)
    }

    override fun onResume() {
        super.onResume()
        bindBundle()
    }

    private fun bindBundle() {
        arguments?.apply {

        }
    }

}