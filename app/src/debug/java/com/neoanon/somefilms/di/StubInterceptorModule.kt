package com.neoanon.somefilms.di

import com.neoanon.somefilms.stubapiserver.StubInterceptor
import okhttp3.Interceptor
import org.koin.dsl.module

val stubInterceptorModule = module {
    single<Interceptor?> { StubInterceptor(get()) }
}