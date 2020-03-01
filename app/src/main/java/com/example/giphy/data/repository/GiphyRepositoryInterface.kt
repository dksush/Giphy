package com.example.giphy.data.repository

import com.example.giphy.data.model.SearchResponse

interface GiphyRepositoryInterface {

    fun getGifSearch(
        api_key: String,
        q : String,
        offset: Int,
        success: (result: List<SearchResponse>) -> Unit,
        fail: (Throwable) -> Unit
    )

    fun getFavoriteItme(
        api_key: String,
        ids : String,
        success: (result: List<SearchResponse>) -> Unit,
        fail: (Throwable) -> Unit

    )


    suspend fun getLikedItem(): MutableList<String>


    fun saveLikedItem(likedItem_id : SearchResponse)
    fun deleteLikedItem(id : String)




}