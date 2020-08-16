package com.neoanon.somefilms.shared.films.extension

const val UNKNOWN_RATING = -1.0

fun Double.isUnknown(): Boolean =
	this == UNKNOWN_RATING