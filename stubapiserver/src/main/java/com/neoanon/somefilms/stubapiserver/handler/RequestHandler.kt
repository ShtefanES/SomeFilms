package com.neoanon.somefilms.stubapiserver.handler

import com.neoanon.somefilms.stubapiserver.extensios.buildResponse
import com.neoanon.somefilms.stubapiserver.response.AssetPathRepository
import com.neoanon.somefilms.stubapiserver.response.BodyResponseRepository
import okhttp3.Interceptor.Chain
import okhttp3.Response

interface RequestHandler {

	fun handle(chain: Chain): Response
}

class RequestHandlerImpl(private val stubEnabled: Boolean,
						 private val bodyResponseRepository: BodyResponseRepository,
						 private val assetPathRepository: AssetPathRepository) : RequestHandler {

	override fun handle(chain: Chain): Response =
		if (stubEnabled) {
			val assetPath = assetPathRepository.get(chain.request())
			val json = bodyResponseRepository.get(assetPath)
			chain.buildResponse(json)
		} else {
			chain.proceed(chain.request())
		}
}