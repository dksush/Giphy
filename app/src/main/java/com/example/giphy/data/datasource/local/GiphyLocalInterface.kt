package com.example.giphy.data.datasource.local

import androidx.lifecycle.LiveData
import com.example.giphy.data.model.SearchResponse

interface GiphyLocalInterface {

    fun getLikedItem(): LiveData<MutableList<String>>
    fun saveLikedItem(likedItem_id: SearchResponse)
    fun deleteLikedItem(id: String)

}