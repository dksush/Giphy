package com.example.giphy.ui.detail

import androidx.lifecycle.ViewModel
import com.example.giphy.data.model.SearchData
import com.example.giphy.data.repository.GiphyRepositoryInterface

class GifDetailViewModel(
    private val RepoInterface: GiphyRepositoryInterface,
    private var searchData: SearchData
) : ViewModel() {

    val title = searchData.title
    var url = searchData.images.original.url

}