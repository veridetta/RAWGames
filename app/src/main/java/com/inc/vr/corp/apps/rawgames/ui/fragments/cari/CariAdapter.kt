package com.inc.vr.corp.apps.rawgames.ui.fragments.cari

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.inc.vr.corp.apps.rawgames.network.dto.Models

import timber.log.Timber

typealias ClickListener = (Models.CariResult) -> Unit

class CariAdapter(private val clickListener: ClickListener) :
    PagedListAdapter<Models.CariResult, CariViewHolder>(diffCallback) {

    override fun onBindViewHolder(holder: CariViewHolder, position: Int) {
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CariViewHolder =
        CariViewHolder.from(parent)

    companion object {
        /**
         * This diff callback informs the PagedListAdapter how to compute list differences when new
         * PagedLists arrive.
         */
        private val diffCallback = object : DiffUtil.ItemCallback<Models.CariResult>() {
            override fun areItemsTheSame(oldItem: Models.CariResult, newItem: Models.CariResult): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Models.CariResult, newItem: Models.CariResult): Boolean =
                oldItem == newItem
        }
    }
}