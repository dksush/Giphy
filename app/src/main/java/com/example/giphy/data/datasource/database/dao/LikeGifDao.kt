package com.example.giphy.data.datasource.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.giphy.data.datasource.database.ItemLikeEntity
import com.example.giphy.data.model.SearchData

@Dao
interface LikeGifDao {



    @Insert
    suspend fun insertAll(blogs: List<ItemLikeEntity>)
//
//    @Query("SELECT * from blog")
//    suspend fun getAll(): List<BlogData>
//
//    @Query("DELETE from blog")
//    suspend fun clearAll()
}