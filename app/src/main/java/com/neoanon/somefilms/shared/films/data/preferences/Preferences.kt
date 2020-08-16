package com.neoanon.somefilms.shared.films.data.preferences

import android.content.SharedPreferences

interface Preferences {

	fun setDirtyCacheDate(timestamp: Long)

	fun getDirtyCacheDate(): Long
}

class PreferencesImpl(private val sharedPreferences: SharedPreferences) : Preferences {

	companion object {
		private const val DIRTY_CACHE_DATE: String = "DirtyCacheDateKey"
	}

	override fun setDirtyCacheDate(timestamp: Long) {
		sharedPreferences.edit().apply {
			putLong(DIRTY_CACHE_DATE, timestamp)
			apply()
		}
	}

	override fun getDirtyCacheDate(): Long =
		sharedPreferences.getLong(DIRTY_CACHE_DATE, -1L)
}