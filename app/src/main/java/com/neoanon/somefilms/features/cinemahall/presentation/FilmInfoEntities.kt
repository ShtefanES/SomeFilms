package com.neoanon.somefilms.features.cinemahall.presentation

import com.neoanon.somefilms.shared.films.domain.entity.Genre
import com.neoanon.somefilms.shared.films.domain.entity.Poster

data class FilmInfoEntities(
	val genres: List<Genre>,
	val posters: List<Poster>,
	val selectedGenreId: Long?
)