package com.example.giphy

import android.app.Application
import com.example.giphy.di.dataSourceModule
import com.example.giphy.di.repositoryModule
import com.example.giphy.di.storageModule
import com.example.giphy.di.viewModelModule
import com.facebook.drawee.backends.pipeline.Fresco
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class GiphyApplication : Application(){

    override fun onCreate() {
        super.onCreate()

        Fresco.initialize(this)

        startKoin {
            androidContext(this@GiphyApplication)
            modules(
                listOf(
                    viewModelModule,
                    repositoryModule,
                    dataSourceModule,
                    storageModule


                )
            )
        }
    }
}