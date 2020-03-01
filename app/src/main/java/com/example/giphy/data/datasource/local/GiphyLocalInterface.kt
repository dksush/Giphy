package com.example.giphy.data.datasource.local

import com.example.giphy.data.model.SearchResponse

interface GiphyLocalInterface {

    suspend fun getLikedItem(): MutableList<String>

    fun saveLikedItem(likedItem_id: SearchResponse)
    fun deleteLikedItem(id: String)

}