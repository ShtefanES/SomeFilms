package com.neoanon.somefilms.shared.ui

import androidx.annotation.MenuRes
import androidx.annotation.StringRes
import androidx.appcompat.widget.Toolbar

inline fun Toolbar.setup(@StringRes titleId: Int = 0,
						 @MenuRes menuResId: Int = 0,
						 navigationIcon: ToolbarNavigationIcon? = null,
						 action: Toolbar.() -> Unit = {}) {
	if (titleId != 0) {
		setTitle(titleId)
	}

	if (menuResId != 0) {
		inflateMenu(menuResId)
	}

	navigationIcon?.let { toolbarNavigationIcon ->
		setNavigationContentDescription(toolbarNavigationIcon.description)
		setNavigationIcon(toolbarNavigationIcon.icon)
	}

	action()
}