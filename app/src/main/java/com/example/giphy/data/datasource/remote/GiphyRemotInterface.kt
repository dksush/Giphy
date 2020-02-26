package com.example.giphy.data.datasource.remote

import com.example.giphy.data.model.SearchData

interface GiphyRemotInterface {

    fun getGifSearch(
        api_key: String,
        q : String,
        offset: Int,
        success: (result: List<SearchData>) -> Unit,
        fail: (Throwable) -> Unit
    )
}