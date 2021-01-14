package com.neoanon.somefilms.stubapiserver

import com.neoanon.somefilms.stubapiserver.handler.RequestHandler
import okhttp3.Interceptor
import okhttp3.Response

class StubInterceptor(private val requestHandler: RequestHandler) : Interceptor {

	override fun intercept(chain: Interceptor.Chain): Response =
		requestHandler.handle(chain)
}