package com.neoanon.somefilms.shared.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.neoanon.somefilms.R

enum class ToolbarNavigationIcon(@StringRes val description: Int,
								 @DrawableRes val icon: Int) {

	BACK(R.string.back, R.drawable.ic_arrow)
}