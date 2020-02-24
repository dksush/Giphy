package com.example.giphy.di

import com.example.giphy.data.source.local.GiphyLocaltImpl
import com.example.giphy.data.source.local.GiphyLocaltInterface
import com.example.giphy.data.source.remote.GiphyRemotImpl
import com.example.giphy.data.source.remote.GiphyRemotInterface
import org.koin.dsl.module

val dataSourceModule = module {

    single<GiphyRemotInterface> { GiphyRemotImpl() }
    single<GiphyLocaltInterface> { GiphyLocaltImpl(get()) }
//    single<GiphyLocaltInterface> { GiphyLocaltImpl(get(), get()) }


}