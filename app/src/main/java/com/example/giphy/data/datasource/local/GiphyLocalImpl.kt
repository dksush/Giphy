package com.example.giphy.data.datasource.local

import android.content.SharedPreferences
import com.example.giphy.common.LikedItemInfo
import com.example.giphy.data.datasource.database.LikeGifDatabase
import com.example.giphy.data.model.SearchResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GiphyLocalImpl(
    private val spm: SharedPreferences,
    private val likeGifDatabase: LikeGifDatabase
) : GiphyLocalInterface {


    override suspend fun getLikedItem(): MutableList<String> {
        return likeGifDatabase.likeGifDao().getLikedItem()
    }

    override fun saveLikedItem(likedItem_id: SearchResponse) {
        CoroutineScope(Dispatchers.IO).launch {
            // 로컬 디비 저장
            likeGifDatabase.likeGifDao().insertAll(likedItem_id)
            // 싱글톤 갱신
            LikedItemInfo.SearchResponse.add(likedItem_id.id)
        }


    }


    override fun deleteLikedItem(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            likeGifDatabase.likeGifDao().delete(id)
            LikedItemInfo.SearchResponse.remove(id)
        }
    }

}