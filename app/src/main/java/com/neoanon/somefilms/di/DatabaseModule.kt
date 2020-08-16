package com.neoanon.somefilms.di

import android.content.Context
import androidx.room.Room
import com.neoanon.somefilms.shared.films.data.db.AppDatabase
import org.koin.dsl.module

val databaseModule = module {
	single { provideDatabase(get()) }
}

private const val DATABASE_NAME = "cinema-database"

private fun provideDatabase(context: Context): AppDatabase =
	Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
		.fallbackToDestructiveMigration().build()