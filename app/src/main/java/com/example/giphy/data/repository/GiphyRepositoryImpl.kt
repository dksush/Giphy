package com.example.giphy.data.repository

import com.example.giphy.data.model.SearchData
import com.example.giphy.data.datasource.local.GiphyLocalInterface
import com.example.giphy.data.datasource.remote.GiphyRemotInterface

class GiphyRepositoryImpl(
    private val giphyRemotInterface: GiphyRemotInterface,
    private val giphyLocaltInterface: GiphyLocalInterface
) : GiphyRepositoryInterface {


    override fun getGifSearch(
        api_key: String,
        q : String,
        offset: Int,

        success: (result: List<SearchData>) -> Unit,
        fail: (Throwable) -> Unit
    ) {

        giphyRemotInterface.getGifSearch(
            api_key, q, offset,
            success,
            fail
        )

    }
}