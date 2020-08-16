package com.neoanon.somefilms.features.cinemahall.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.neoanon.somefilms.R
import com.neoanon.somefilms.features.cinemahall.presentation.TitleType
import kotlinx.android.synthetic.main.title_item.view.title

class TitleItemViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
	LayoutInflater.from(parent.context).inflate(R.layout.title_item, parent, false)
) {

	fun bind(titleType: TitleType) {

		itemView.title.text = getTitle(titleType, itemView.context)
	}

	private fun getTitle(titleType: TitleType, context: Context): String =
		if (titleType == TitleType.GENRE) {
			context.getString(R.string.genres_title)
		} else {
			context.getString(R.string.posters_title)
		}
}