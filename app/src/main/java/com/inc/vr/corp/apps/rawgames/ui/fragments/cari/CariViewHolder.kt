package com.inc.vr.corp.apps.rawgames.ui.fragments.cari

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.inc.vr.corp.apps.rawgames.network.dto.Models
import com.inc.vr.corp.apps.rawgames.R
import kotlinx.android.synthetic.main.item_game.view.*

class CariViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    /**
     * Items might be null if they are not paged in yet. PagedListAdapter will re-bind the
     * ViewHolder when Item is loaded.
     */
    fun bind(game: Models.CariResult?) {
            game?.apply {
                val imgUri = backgroundImage.toUri().buildUpon().scheme("https").build()
                itemView.apply {
                    Glide.with(imgPreview.context)
                        .load(imgUri)
                        .apply(
                            RequestOptions()
                                .placeholder(R.drawable.loading_animation)
                                .error(R.drawable.ic_broken_image)
                        )
                        .into(imgPreview)
                    txtLikes.text = rating
                    txtUserName.text = name
                    txtView.text = released
                }
            }
    }
    companion object {
        fun from(parent: ViewGroup): CariViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val view = layoutInflater
                .inflate(R.layout.item_cari, parent, false)

            return CariViewHolder(view)
        }
    }

}