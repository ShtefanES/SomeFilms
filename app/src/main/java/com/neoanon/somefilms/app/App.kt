package com.neoanon.somefilms.app

import android.app.Application
import com.facebook.stetho.Stetho
import com.neoanon.somefilms.BuildConfig
import com.neoanon.somefilms.di.databaseModule
import com.neoanon.somefilms.di.navigationModule
import com.neoanon.somefilms.di.networkModule
import com.neoanon.somefilms.di.preferenceModule
import com.neoanon.somefilms.features.cinemahall.di.cinemaHallModule
import com.neoanon.somefilms.features.detail.di.filmDetailModule
import com.neoanon.somefilms.shared.films.di.filmsModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

	override fun onCreate() {
		super.onCreate()

		if (BuildConfig.DEBUG) {
			Stetho.initializeWithDefaults(this)
		}

		startKoin {
			androidContext(this@App)
			androidLogger(Level.DEBUG)
			modules(
				listOf(
					networkModule,
					databaseModule,
					preferenceModule,
					navigationModule,
					filmsModule,
					cinemaHallModule,
					filmDetailModule
				)
			)
		}
	}
}