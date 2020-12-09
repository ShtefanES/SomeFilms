package com.neoanon.somefilms.shared.ui

import android.content.res.Resources.Theme
import android.util.TypedValue
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt

@ColorInt
fun Theme.getColor(@AttrRes attribute: Int): Int {
	val typedValue = TypedValue()
	val valid = this.resolveAttribute(attribute, typedValue, true)
	if (!valid) {
		throw Exception("fail when try resolve attribute - attribute not found or not valid")
	}
	return typedValue.data
}