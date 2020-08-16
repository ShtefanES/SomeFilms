package com.neoanon.somefilms.shared.films.data.converter

import com.neoanon.somefilms.shared.films.data.db.GenreInfo
import com.neoanon.somefilms.shared.films.domain.entity.Genre

class GenreListConverter(private val genreConverter: GenreConverter) {

	fun convert(from: List<GenreInfo>): List<Genre> =
		from.map(genreConverter::convert)
}