package com.neoanon.somefilms.stubapiserver.extensios

import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import java.net.HttpURLConnection

private val JSON_TYPE = "application/json".toMediaTypeOrNull()

fun Interceptor.Chain.buildResponse(
	json: String,
	code: Int = HttpURLConnection.HTTP_OK
): Response =
	Response.Builder()
		.body(json.toResponseBody(JSON_TYPE))
		.request(request())
		.protocol(Protocol.HTTP_1_1)
		.message(code.toString())
		.code(code)
		.build()