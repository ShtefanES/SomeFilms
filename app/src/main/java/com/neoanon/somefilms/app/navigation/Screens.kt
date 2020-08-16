package com.neoanon.somefilms.app.navigation

import androidx.fragment.app.Fragment
import com.neoanon.somefilms.features.cinemahall.ui.CinemaHallFragment
import com.neoanon.somefilms.features.detail.ui.FilmDetailFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

data class FilmDetailScreen(val filmId: Long) : SupportAppScreen() {

	override fun getFragment(): Fragment? {
		return FilmDetailFragment.newInstance(filmId)
	}
}

object CinemaHallScreen : SupportAppScreen() {

	override fun getFragment(): Fragment? {
		return CinemaHallFragment.newInstance()
	}
}