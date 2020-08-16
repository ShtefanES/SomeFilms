package com.neoanon.somefilms.shared.films.data.datasource

import com.neoanon.somefilms.shared.films.data.preferences.Preferences
import java.util.Calendar

interface CacheDateDataSource {

	fun updateDirtyCacheDate()

	fun isCacheDirty(): Boolean
}

class CacheDateDataSourceImpl(private val preferences: Preferences) : CacheDateDataSource {

	private companion object {
		const val CACHE_LIFETIME = 120000L// 2 minutes
	}

	override fun updateDirtyCacheDate() {
		val dirtyCacheDate = getCurrentDate() + CACHE_LIFETIME
		preferences.setDirtyCacheDate(dirtyCacheDate)
	}

	override fun isCacheDirty(): Boolean {
		val currentDate = getCurrentDate()
		val dirtyCacheDate = preferences.getDirtyCacheDate()
		return currentDate > dirtyCacheDate
	}

	private fun getCurrentDate(): Long =
		Calendar.getInstance().timeInMillis
}