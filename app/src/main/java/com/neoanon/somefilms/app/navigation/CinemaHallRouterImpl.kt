package com.neoanon.somefilms.app.navigation

import com.neoanon.somefilms.features.cinemahall.presentation.CinemaHallRouter
import ru.terrakok.cicerone.Router

class CinemaHallRouterImpl(private val router: Router) : CinemaHallRouter {

	override fun navigateToDetailFilm(filmId: Long) {
		router.replaceScreen(FilmDetailScreen(filmId))
	}

	override fun exit() {
		router.exit()
	}
}