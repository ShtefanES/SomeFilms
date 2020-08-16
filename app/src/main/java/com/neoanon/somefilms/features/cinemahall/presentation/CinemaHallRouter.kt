package com.neoanon.somefilms.features.cinemahall.presentation

interface CinemaHallRouter {

	fun navigateToDetailFilm(filmId: Long)

	fun exit()
}