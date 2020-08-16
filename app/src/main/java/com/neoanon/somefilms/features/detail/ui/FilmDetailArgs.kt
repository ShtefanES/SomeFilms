package com.neoanon.somefilms.features.detail.ui

import android.os.Bundle

private const val FILM_ID = "FILM_ID"

var Bundle.filmId: Long
    get() = getLong(FILM_ID)
    set(value) = putLong(FILM_ID, value)