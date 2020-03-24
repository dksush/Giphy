package com.example.giphy.data.repository

import androidx.lifecycle.LiveData
import com.example.giphy.data.datasource.local.GiphyLocalInterface
import com.example.giphy.data.datasource.remote.GiphyRemoteInterface
import com.example.giphy.data.model.SearchResponse

class GiphyRepositoryImpl(
    private val remoteInterface: GiphyRemoteInterface,
    private val localInterface: GiphyLocalInterface
) : GiphyRepositoryInterface {

    override suspend fun getGifSearch(
        api_key: String,
        q: String,
        offset: Int
    ): List<SearchResponse> {
        return remoteInterface.getGifSearch(api_key, q, offset)
    }

    override fun getFavoriteItem(
        api_key: String,
        ids: String,
        success: (result: List<SearchResponse>) -> Unit,
        fail: (Throwable) -> Unit
    ) {
        remoteInterface.getFavoriteItem(
            api_key, ids,
            success,
            fail
        )
    }


    override fun saveLikedItem(likedItem_id: SearchResponse) {
        localInterface.saveLikedItem(likedItem_id)
    }

    override fun deleteLikedItem(id: String) {
        localInterface.deleteLikedItem(id)
    }

    override fun getLikedItem(): LiveData<MutableList<String>> {
        return localInterface.getLikedItem()
    }


}