package com.neoanon.somefilms.features.cinemahall.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.neoanon.somefilms.R
import com.neoanon.somefilms.features.cinemahall.presentation.FilmInfoItem
import com.neoanon.somefilms.features.cinemahall.presentation.backgroundColorAttr
import com.neoanon.somefilms.features.cinemahall.presentation.textColorAttr
import com.neoanon.somefilms.shared.ui.getColor
import kotlinx.android.synthetic.main.genre_item.view.name

class GenreItemViewHolder(
	parent: ViewGroup,
	onGenreItemClickListener: (selectedGenreId: Long) -> Unit
) : RecyclerView.ViewHolder(
	LayoutInflater.from(parent.context).inflate(R.layout.genre_item, parent, false)
) {

	private lateinit var genreItem: FilmInfoItem.GenreItem

	init {
		itemView.setOnClickListener { onGenreItemClickListener.invoke(genreItem.id) }
	}

	fun bind(item: FilmInfoItem.GenreItem) {
		this.genreItem = item
		itemView.name.text = item.name

		val backgroundAttributeColor = item.backgroundColorAttr
		val textAttributeColor = item.textColorAttr
		val theme = itemView.context.theme
		val backgroundColor = theme.getColor(backgroundAttributeColor)
		val textColor = theme.getColor(textAttributeColor)

		itemView.name.setTextColor(textColor)

		val cardView = itemView as MaterialCardView
		cardView.setCardBackgroundColor(backgroundColor)
	}
}