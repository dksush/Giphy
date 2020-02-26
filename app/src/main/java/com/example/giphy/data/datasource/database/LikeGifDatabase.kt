package com.example.giphy.data.datasource.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.giphy.data.datasource.database.dao.LikeGifDao
import com.example.giphy.data.model.SearchData

@Database(entities = [ItemLikeEntity::class],version = 1, exportSchema = false)
abstract class LikeGifDatabase : RoomDatabase(){
    abstract fun likeGifDao() : LikeGifDao
}