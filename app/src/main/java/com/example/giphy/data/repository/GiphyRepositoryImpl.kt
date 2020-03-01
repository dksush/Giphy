package com.example.giphy.data.repository

import com.example.giphy.data.datasource.local.GiphyLocalInterface
import com.example.giphy.data.datasource.remote.GiphyRemotInterface
import com.example.giphy.data.model.SearchResponse

class GiphyRepositoryImpl(
    private val RemoteInterface: GiphyRemotInterface,
    private val LocalInterface: GiphyLocalInterface
) : GiphyRepositoryInterface {


    override fun getGifSearch(
        api_key: String,
        q: String,
        offset: Int,

        success: (result: List<SearchResponse>) -> Unit,
        fail: (Throwable) -> Unit
    ) {

        RemoteInterface.getGifSearch(
            api_key, q, offset,
            success,
            fail
        )

    }

    override fun getFavoriteItme(
        api_key: String,
        ids: String,
        success: (result: List<SearchResponse>) -> Unit,
        fail: (Throwable) -> Unit
    ) {

        RemoteInterface.getFavoriteItme(
            api_key,ids,
            success,
            fail
        )
    }

    override fun saveLikedItem(likedItem_id: SearchResponse) {
        LocalInterface.saveLikedItem(likedItem_id)
    }

    override fun deleteLikedItem(id: String) {
        LocalInterface.deleteLikedItem(id)
    }


    override suspend fun getLikedItem(): MutableList<String> {
        return LocalInterface.getLikedItem()
    }


}