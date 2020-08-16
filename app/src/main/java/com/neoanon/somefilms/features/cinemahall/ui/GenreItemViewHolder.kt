package com.neoanon.somefilms.features.cinemahall.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.neoanon.somefilms.R
import com.neoanon.somefilms.features.cinemahall.presentation.FilmInfoItem
import kotlinx.android.synthetic.main.genre_item.view.name

class GenreItemViewHolder(parent: ViewGroup,
						  onGenreItemClickListener: (selectedGenreId: Long) -> Unit) : RecyclerView.ViewHolder(
	LayoutInflater.from(parent.context).inflate(R.layout.genre_item, parent, false)
) {

	private lateinit var genreItem: FilmInfoItem.GenreItem

	init {
		itemView.setOnClickListener { onGenreItemClickListener.invoke(genreItem.id) }
	}

	fun bind(item: FilmInfoItem.GenreItem) {
		this.genreItem = item
		itemView.name.text = item.name
		val backgroundColor = if (item.selected) {
			ContextCompat.getColor(itemView.context, R.color.colorAccent)
		} else {
			ContextCompat.getColor(itemView.context, R.color.colorPrimary)
		}
		val cardView = itemView as MaterialCardView
		cardView.setCardBackgroundColor(backgroundColor)
	}
}