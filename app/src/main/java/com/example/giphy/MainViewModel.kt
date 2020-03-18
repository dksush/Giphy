package com.example.giphy

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.giphy.data.repository.GiphyRepositoryInterface

class MainViewModel(RepoInterface: GiphyRepositoryInterface) : ViewModel() {

    private val _likedItemInfo: LiveData<MutableList<String>> = RepoInterface.getLikedItem()
    val likedItemInfo: LiveData<MutableList<String>> get() = _likedItemInfo


}