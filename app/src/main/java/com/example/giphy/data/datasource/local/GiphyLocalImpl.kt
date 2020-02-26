package com.example.giphy.data.datasource.local

import android.content.SharedPreferences
import com.example.giphy.data.datasource.database.LikeGifDatabase

class GiphyLocalImpl(
    private val spm: SharedPreferences
    , private val likeGifDatabase: LikeGifDatabase
) : GiphyLocalInterface {
}