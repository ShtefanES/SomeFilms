package com.neoanon.somefilms.features.cinemahall.presentation

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