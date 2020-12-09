package com.neoanon.somefilms.features.cinemahall.presentation

import com.neoanon.somefilms.R

sealed class FilmInfoItem {

	data class TitleItem(val id: Int,
						 val titleType: TitleType) : FilmInfoItem()

	data class GenreItem(val id: Long,
						 val name: String,
						 var selected: Boolean) : FilmInfoItem()

	data class PosterItem(val id: Long,
						  val title: String,
						  val imageUrl: String) : FilmInfoItem()
}

val FilmInfoItem.GenreItem.textColorAttr: Int
	get() = if (selected) {
		R.attr.textColorSelected
	} else {
		R.attr.textColorUnselected
	}

val FilmInfoItem.GenreItem.backgroundColorAttr: Int
	get() = if (selected) {
		R.attr.backgroundColorSelected
	} else {
		R.attr.backgroundColorUnselected
	}