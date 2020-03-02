package com.example.giphy.di

import com.example.giphy.data.datasource.local.GiphyLocalImpl
import com.example.giphy.data.datasource.local.GiphyLocalInterface
import com.example.giphy.data.datasource.remote.GiphyRemoteImpl
import com.example.giphy.data.datasource.remote.GiphyRemoteInterface
import org.koin.dsl.module

val dataSourceModule = module {

    single<GiphyRemoteInterface> { GiphyRemoteImpl() }
    single<GiphyLocalInterface> { GiphyLocalImpl(get(), get()) }

}