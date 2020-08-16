package com.neoanon.somefilms.di

import android.content.Context
import android.content.SharedPreferences
import org.koin.dsl.module

val preferenceModule = module {
	single { providePreferences(get()) }
}
private const val PREFERENCES_NAME = "mainPreferences"

fun providePreferences(context: Context): SharedPreferences =
	context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)