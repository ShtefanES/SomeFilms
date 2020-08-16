package com.neoanon.somefilms.features.cinemahall.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.neoanon.somefilms.R
import com.neoanon.somefilms.features.cinemahall.presentation.FilmInfoItem
import kotlinx.android.synthetic.main.poster_item.view.*

class PosterItemViewHolder(parent: ViewGroup,
						   oPosterItemClickListener: (selectedPosterId: Long) -> Unit) : RecyclerView.ViewHolder(
	LayoutInflater.from(parent.context).inflate(R.layout.poster_item, parent, false)
) {

	private lateinit var posterItem: FilmInfoItem.PosterItem

	init {
		itemView.setOnClickListener { oPosterItemClickListener.invoke(posterItem.id) }
	}

	fun bind(item: FilmInfoItem.PosterItem) {
		this.posterItem = item
		itemView.title.text = item.title

		Glide.with(itemView)
			.load(item.imageUrl)
			.centerCrop()
			.error(R.drawable.ic_blank)
			.into(itemView.image)
	}
}