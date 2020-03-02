package com.example.giphy.ui.detail

import androidx.lifecycle.ViewModel
import com.example.giphy.data.model.SearchResponse
import com.example.giphy.data.repository.GiphyRepositoryInterface

class GifDetailViewModel(
    private val RepoInterface: GiphyRepositoryInterface,
    private val searchResponse: SearchResponse
) : ViewModel() {

    val title = searchResponse.title
    var url = searchResponse.images?.original?.url
    var isLiked: Boolean = false


    fun saveLikeGif() {
        if (isLiked) {
            RepoInterface.saveLikedItem(searchResponse)
        } else {
            RepoInterface.deleteLikedItem(searchResponse.id)
        }


    }

}