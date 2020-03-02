package com.example.giphy.data.datasource.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.giphy.data.datasource.database.dao.LikeGifDao
import com.example.giphy.data.model.SearchResponse

@Database(entities = [SearchResponse::class], version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class LikeGifDatabase : RoomDatabase() {

    abstract fun likeGifDao(): LikeGifDao
}