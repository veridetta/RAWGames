package com.inc.vr.corp.apps.rawgames.ui.fragments.games

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.inc.vr.corp.apps.rawgames.network.dto.Models

import timber.log.Timber

typealias ClickListener = (Models.GameResults) -> Unit

class GameAdapter(private val clickListener: ClickListener) :
    PagedListAdapter<Models.GameResults, GameViewHolder>(diffCallback) {

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        Timber.d("Binding view holder at position $position")
        val game = getItem(position)

        with(holder) {
            bind(game)
            game?.let {
                itemView.setOnClickListener {
                    clickListener(game)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder =
        GameViewHolder.from(parent)

    companion object {
        /**
         * This diff callback informs the PagedListAdapter how to compute list differences when new
         * PagedLists arrive.
         */
        private val diffCallback = object : DiffUtil.ItemCallback<Models.GameResults>() {
            override fun areItemsTheSame(oldItem: Models.GameResults, newItem: Models.GameResults): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Models.GameResults, newItem: Models.GameResults): Boolean =
                oldItem == newItem
        }
    }
}