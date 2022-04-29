package com.inc.vr.corp.apps.rawgames.ui.fragments.rating

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.inc.vr.corp.apps.rawgames.network.dto.Models

import timber.log.Timber

typealias ClickListener = (Models.RatingResult) -> Unit

class RatingAdapter(private val clickListener: ClickListener) :
    PagedListAdapter<Models.RatingResult, RatingViewHolder>(diffCallback) {

    override fun onBindViewHolder(holder: RatingViewHolder, position: Int) {
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RatingViewHolder =
        RatingViewHolder.from(parent)

    companion object {
        /**
         * This diff callback informs the PagedListAdapter how to compute list differences when new
         * PagedLists arrive.
         */
        private val diffCallback = object : DiffUtil.ItemCallback<Models.RatingResult>() {
            override fun areItemsTheSame(oldItem: Models.RatingResult, newItem: Models.RatingResult): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Models.RatingResult, newItem: Models.RatingResult): Boolean =
                oldItem == newItem
        }
    }
}