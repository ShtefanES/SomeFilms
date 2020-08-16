package com.neoanon.somefilms.di

import com.neoanon.somefilms.app.navigation.CinemaHallRouterImpl
import com.neoanon.somefilms.app.navigation.FilmDetailRouterImpl
import com.neoanon.somefilms.features.cinemahall.presentation.CinemaHallRouter
import com.neoanon.somefilms.features.detail.presentation.FilmDetailRouter
import org.koin.dsl.module
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

val navigationModule = module {
	single { Cicerone.create() }
	single { provideCiceroneRouter(get()) }
	single { provideCiceroneNavigatorHolder(get()) }

	factory<CinemaHallRouter> { CinemaHallRouterImpl(get()) }
	factory<FilmDetailRouter> { FilmDetailRouterImpl(get()) }
}

private fun provideCiceroneRouter(cicerone: Cicerone<Router>): Router =
	cicerone.router

private fun provideCiceroneNavigatorHolder(cicerone: Cicerone<Router>): NavigatorHolder =
	cicerone.navigatorHolder