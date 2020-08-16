package com.neoanon.somefilms.features.detail.presentation

import com.neoanon.somefilms.shared.films.domain.entity.FilmDetail
import moxy.MvpView
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(SingleStateStrategy ::class)
interface FilmDetailView : MvpView {

	fun showFilmDetail(detail: FilmDetail)

	fun showErrorInfo()
}