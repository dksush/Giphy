package com.example.giphy.data.datasource.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.giphy.data.model.SearchResponse

@Dao
interface LikeGifDao {

    @Query("SELECT id from like_item")
    fun getLikedItem(): LiveData<MutableList<String>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(likedItem_id: SearchResponse)

    @Query("DELETE FROM like_item WHERE id = :id")
    suspend fun delete(id: String)


}