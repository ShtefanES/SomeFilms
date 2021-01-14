package com.neoanon.somefilms.stubapiserver.response

import android.content.Context
import java.io.IOException
import java.io.InputStreamReader
import kotlin.jvm.Throws

interface BodyResponseRepository {

	fun get(path: String): String
}

class BodyResponseRepositoryImpl(private val context: Context) : BodyResponseRepository {

	@Throws(IOException::class)
	override fun get(path: String): String =
		context.assets.open(path)
			.reader()
			.use(InputStreamReader::readText)
}