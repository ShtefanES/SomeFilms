package com.neoanon.somefilms.di

import com.neoanon.somefilms.BuildConfig
import org.koin.core.qualifier.named
import org.koin.dsl.module

val STUB_ENABLED_QUALIFIER = "STUB_ENABLED_QUALIFIER"

val configModule = module{
single(named(STUB_ENABLED_QUALIFIER)) { BuildConfig.STUB_ENABLED }
}