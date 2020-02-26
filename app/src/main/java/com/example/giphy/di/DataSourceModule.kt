package com.example.giphy.di

import com.example.giphy.data.datasource.local.GiphyLocalImpl
import com.example.giphy.data.datasource.local.GiphyLocalInterface
import com.example.giphy.data.datasource.remote.GiphyRemotImpl
import com.example.giphy.data.datasource.remote.GiphyRemotInterface
import org.koin.dsl.module

val dataSourceModule = module {

    single<GiphyRemotInterface> { GiphyRemotImpl() }
    single<GiphyLocalInterface> { GiphyLocalImpl(get(), get()) }

}