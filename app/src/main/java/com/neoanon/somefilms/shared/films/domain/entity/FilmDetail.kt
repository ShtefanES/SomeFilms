package com.neoanon.somefilms.shared.films.domain.entity

data class FilmDetail(
	val title: String,
	val originalTitle: String,
	val imageUrl: String,
	val year: String,
	val rating: Double,
	val description: String
)