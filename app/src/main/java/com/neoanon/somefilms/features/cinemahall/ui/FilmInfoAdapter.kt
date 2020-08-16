package com.neoanon.somefilms.features.cinemahall.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.neoanon.somefilms.features.cinemahall.presentation.FilmInfoItem

class FilmInfoAdapter(
	private val genreItemClickListener: (selectedGenreId: Long) -> Unit,
	private val posterItemClickListener: (selectedPosterId: Long) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

	companion object {
		const val ITEM_TYPE_GENRE = 1
		const val ITEM_TYPE_POSTER = 2
		const val ITEM_TYPE_TITLE = 3
	}

	private var items: List<FilmInfoItem> = emptyList()

	fun setData(items: List<FilmInfoItem>) {
		val oldItems = this.items
		val newItems = items

		val diffUtilCallback = FilmInfoDiffUtilCallback(oldItems, newItems)
		val diffResult = DiffUtil.calculateDiff(diffUtilCallback)

		this.items = newItems
		diffResult.dispatchUpdatesTo(this)
	}

	override fun getItemCount(): Int = items.size

	override fun getItemViewType(position: Int): Int =
		when (items[position]) {
			is FilmInfoItem.TitleItem  -> ITEM_TYPE_TITLE
			is FilmInfoItem.GenreItem  -> ITEM_TYPE_GENRE
			is FilmInfoItem.PosterItem -> ITEM_TYPE_POSTER
		}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
		when (viewType) {
			ITEM_TYPE_TITLE  -> TitleItemViewHolder(parent)
			ITEM_TYPE_GENRE  -> GenreItemViewHolder(parent, genreItemClickListener)
			ITEM_TYPE_POSTER -> PosterItemViewHolder(parent, posterItemClickListener)
			else             -> throw IllegalArgumentException("Illegal viewType: $viewType")
		}

	override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
		when (val item = items[position]) {
			is FilmInfoItem.GenreItem  -> (holder as? GenreItemViewHolder)?.bind(item)
			is FilmInfoItem.PosterItem -> (holder as? PosterItemViewHolder)?.bind(item)
			is FilmInfoItem.TitleItem  -> (holder as? TitleItemViewHolder)?.bind(item.titleType)
		}
	}
}