package com.neoanon.somefilms.di

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.neoanon.somefilms.BuildConfig
import com.neoanon.somefilms.shared.films.data.network.FilmApi
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
	factory { StethoInterceptor() }
	factory { provideOkHttpClient(get()) }
	factory { provideGson() }
	factory { provideGsonConverterFactory(get()) }
	single { provideFilmApi(get()) }
	single { provideRetrofit(get(), get()) }
}

private fun provideRetrofit(okHttpClient: OkHttpClient,
							convertFactory: Converter.Factory): Retrofit =
	Retrofit.Builder()
		.baseUrl(BuildConfig.TEST_API_URL)
		.client(okHttpClient)
		.addConverterFactory(convertFactory)
		.build()

private fun provideOkHttpClient(stethoInterceptor: StethoInterceptor): OkHttpClient =
	OkHttpClient().newBuilder()
		.addNetworkInterceptor(stethoInterceptor)
		.build()

private fun provideGsonConverterFactory(gson: Gson): Converter.Factory =
	GsonConverterFactory.create(gson)

private fun provideGson(): Gson =
	GsonBuilder().create()

private fun provideFilmApi(retrofit: Retrofit): FilmApi =
	retrofit.create(FilmApi::class.java)