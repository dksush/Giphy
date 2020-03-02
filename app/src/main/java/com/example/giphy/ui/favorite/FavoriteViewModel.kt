package com.example.giphy.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.giphy.common.LikedItemInfo
import com.example.giphy.common.StringConst
import com.example.giphy.data.model.SearchResponse
import com.example.giphy.data.repository.GiphyRepositoryInterface

class FavoriteViewModel(private val RepoInterface: GiphyRepositoryInterface) : ViewModel() {


    private val _favoriteItem = MutableLiveData<List<SearchResponse>>()
    val favoriteItem: LiveData<List<SearchResponse>> get() = _favoriteItem


    fun getFavoriteItem() {
        val text = LikedItemInfo.SearchResponse.toString().run {
            this.substring(1, this.length - 1)
        }

        RepoInterface.getFavoriteItem(
            StringConst.API_KEY, text,
            success = {
                _favoriteItem.value = it
            },
            fail = {
            })

    }
}