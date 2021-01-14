package com.neoanon.somefilms.di

import com.neoanon.somefilms.stubapiserver.handler.RequestHandler
import com.neoanon.somefilms.stubapiserver.handler.RequestHandlerImpl
import com.neoanon.somefilms.stubapiserver.response.AssetPathRepository
import com.neoanon.somefilms.stubapiserver.response.AssetPathRepositoryImpl
import com.neoanon.somefilms.stubapiserver.response.BodyResponseRepository
import com.neoanon.somefilms.stubapiserver.response.BodyResponseRepositoryImpl
import org.koin.core.qualifier.named
import org.koin.dsl.module

val stubModule = module {
    single<RequestHandler> { RequestHandlerImpl(get(named(STUB_ENABLED_QUALIFIER)), get(), get()) }
    single<BodyResponseRepository> { BodyResponseRepositoryImpl(get()) }
    single<AssetPathRepository> { AssetPathRepositoryImpl() }
}