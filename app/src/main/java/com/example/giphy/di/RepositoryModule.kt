package com.example.giphy.di

import com.example.giphy.data.repository.GiphyRepositoryImpl
import com.example.giphy.data.repository.GiphyRepositoryInterface
import org.koin.dsl.module

val repositoryModule = module {
    single<GiphyRepositoryInterface> { GiphyRepositoryImpl(get(), get()) }
}