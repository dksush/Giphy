package com.example.giphy.di

import android.content.Context
import android.content.SharedPreferences
import com.example.giphy.common.StringConst

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val storageModule = module {
    // 룸
//    single {
//        Room.databaseBuilder(
//            androidContext(),
//            SearchHistDatabase::class.java, "search_history.db"
//        ).build()
//    }


    // 쉐어드
    single<SharedPreferences> {
        androidContext().getSharedPreferences(
            StringConst.PREF_KEY,
            Context.MODE_PRIVATE
        )
    }

}