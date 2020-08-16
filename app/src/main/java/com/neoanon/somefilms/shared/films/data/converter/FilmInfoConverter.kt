package com.neoanon.somefilms.shared.films.data.converter

import com.neoanon.somefilms.shared.films.data.db.FilmInfo
import com.neoanon.somefilms.shared.films.data.model.FilmModel
import com.neoanon.somefilms.shared.films.extension.UNKNOWN_RATING

class FilmInfoConverter {

	fun convert(from: FilmModel): FilmInfo =
		FilmInfo(id = from.id,
				 localizedName = from.localizedName,
				 name = from.name,
				 year = from.year,
				 rating = from.rating ?: UNKNOWN_RATING,
				 imageUrl = from.imageUrl ?: "",
				 description = from.description ?: "")
}