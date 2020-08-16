package com.neoanon.somefilms.app.navigation

import com.neoanon.somefilms.features.detail.presentation.FilmDetailRouter
import ru.terrakok.cicerone.Router

class FilmDetailRouterImpl(private val router: Router) : FilmDetailRouter {

	override fun close() {
		router.replaceScreen(CinemaHallScreen)
	}
}