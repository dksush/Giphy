package com.example.giphy.data.datasource.remote

import com.example.giphy.data.model.SearchResponse

interface GiphyRemoteInterface {

    suspend fun getGifSearch(
        api_key: String,
        q : String,
        offset: Int
    ): List<SearchResponse>

    fun getFavoriteItem(
        api_key: String,
        ids : String,
        success: (result: List<SearchResponse>) -> Unit,
        fail: (Throwable) -> Unit

    )
}