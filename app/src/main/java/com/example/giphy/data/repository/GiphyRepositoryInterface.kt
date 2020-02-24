package com.example.giphy.data.repository

import com.example.giphy.data.model.SearchData

interface GiphyRepositoryInterface {

    fun getGifSearch(
        api_key: String,
        q : String,
        offset: Int,
        success: (result: List<SearchData>) -> Unit,
        fail: (Throwable) -> Unit
    )
}