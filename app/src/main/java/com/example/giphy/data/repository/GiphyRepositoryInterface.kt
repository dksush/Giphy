package com.example.giphy.data.repository

import androidx.lifecycle.LiveData
import com.example.giphy.data.model.SearchResponse

interface GiphyRepositoryInterface {

    suspend fun getGifSearch(
        api_key: String,
        q: String,
        offset: Int
    ): List<SearchResponse>

    fun getFavoriteItem(
        api_key: String,
        ids: String,
        success: (result: List<SearchResponse>) -> Unit,
        fail: (Throwable) -> Unit

    )

    fun getLikedItem(): LiveData<MutableList<String>>
    fun saveLikedItem(likedItem_id: SearchResponse)
    fun deleteLikedItem(id: String)


}