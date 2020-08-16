package com.neoanon.somefilms.features.detail.di

import com.neoanon.somefilms.features.detail.presentation.FilmDetailPresenter
import org.koin.dsl.module

val filmDetailModule = module{
	factory { FilmDetailPresenter(get(), get()) }
}