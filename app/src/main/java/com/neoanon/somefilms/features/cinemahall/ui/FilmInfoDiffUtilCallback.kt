package com.neoanon.somefilms.features.cinemahall.ui

import androidx.recyclerview.widget.DiffUtil
import com.neoanon.somefilms.features.cinemahall.presentation.FilmInfoItem

class FilmInfoDiffUtilCallback(
	private val oldList: List<FilmInfoItem>,
	private val newList: List<FilmInfoItem>
) : DiffUtil.Callback() {

	override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
		val oldItem = oldList[oldItemPosition]
		val newItem = newList[newItemPosition]

		return when {
			oldItem is FilmInfoItem.PosterItem && newItem is FilmInfoItem.PosterItem -> oldItem.id == newItem.id
			oldItem is FilmInfoItem.GenreItem && newItem is FilmInfoItem.GenreItem   -> oldItem.id == newItem.id
			oldItem is FilmInfoItem.TitleItem && newItem is FilmInfoItem.TitleItem   -> oldItem.id == newItem.id
			else                                                                     -> false
		}
	}

	override fun getOldListSize(): Int =
		oldList.size

	override fun getNewListSize(): Int =
		newList.size

	override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
		val oldItem = oldList[oldItemPosition]
		val newItem = newList[newItemPosition]

		return oldItem == newItem
	}
}