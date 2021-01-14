package com.neoanon.somefilms.stubapiserver.response

import okhttp3.Request
import java.lang.RuntimeException

interface AssetPathRepository {

	fun get(request: Request): String
}

class AssetPathRepositoryImpl : AssetPathRepository {

	private val pathToAssetPath = hashMapOf(
		"GET_/sequeniatesttask/films.json" to "sequeniatesttask/all_films.json",
	)

	override fun get(request: Request): String =
		pathToAssetPath.getOrElse(request.getAssetKey()) {
			throw RuntimeException("Asset path not found")
		}
}

private fun Request.getAssetKey(): String =
	"${method}_${url.encodedPath}"