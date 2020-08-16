package com.neoanon.somefilms.features.cinemahall.presentation

import moxy.MvpView
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(SingleStateStrategy::class)
interface CinemaHallView : MvpView {

	fun showProgress()

	fun hideProgress()

	fun showFilmInfoList(filmInfoItems: List<FilmInfoItem>)

	fun showErrorInfo()
}