package com.neoanon.somefilms.shared.films.data.converter

import com.neoanon.somefilms.shared.films.data.db.FilmInfo
import com.neoanon.somefilms.shared.films.data.model.FilmModel

class FilmInfoListConverter(private val filmInfoConverter: FilmInfoConverter) {

	fun convert(from: List<FilmModel>): List<FilmInfo> =
		from.map(filmInfoConverter::convert)
}