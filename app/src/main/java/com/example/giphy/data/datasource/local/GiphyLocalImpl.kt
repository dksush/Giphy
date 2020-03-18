package com.example.giphy.data.datasource.local

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import com.example.giphy.data.datasource.database.LikeGifDatabase
import com.example.giphy.data.model.SearchResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GiphyLocalImpl(
    private val spm: SharedPreferences,
    private val likeGifDatabase: LikeGifDatabase
) : GiphyLocalInterface {


    override fun getLikedItem(): LiveData<MutableList<String>> {
        return likeGifDatabase.likeGifDao().getLikedItem()
    }

    override fun saveLikedItem(likedItem_id: SearchResponse) {
        CoroutineScope(Dispatchers.IO).launch {
            // 로컬 디비 저장
            likeGifDatabase.likeGifDao().insertAll(likedItem_id)
        }
    }

    override fun deleteLikedItem(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            likeGifDatabase.likeGifDao().delete(id)
        }
    }

}