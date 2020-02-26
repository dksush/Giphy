package com.example.giphy.ui.detail

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.giphy.data.model.SearchData
import com.example.giphy.data.repository.GiphyRepositoryInterface

class GifDetailViewModel(
    private val RepoInterface: GiphyRepositoryInterface,
    private var searchData: SearchData
) : ViewModel() {

    val title = searchData.title
    var url = searchData.images.original.url
    var asdf = searchData.images.original.url
    var ckLike :Boolean = false

    fun saveLikeGif(){
        Log.v("dksushn_check22", ckLike.toString())

    }

}