package com.neoanon.somefilms.shared.films.data.network

import com.neoanon.somefilms.shared.films.data.model.RootFilmsModel
import retrofit2.http.GET
import retrofit2.http.Query

interface FilmApi {

    @GET("sequeniatesttask/films.json")
    suspend fun getFilms(): RootFilmsModel
}