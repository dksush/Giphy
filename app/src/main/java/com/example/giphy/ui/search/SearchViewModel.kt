package com.example.giphy.ui.search

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.giphy.common.LikedItemInfo
import com.example.giphy.common.StringConst.Companion.API_KEY
import com.example.giphy.data.model.SearchResponse
import com.example.giphy.data.repository.GiphyRepositoryInterface


class SearchViewModel(private val RepoInterface: GiphyRepositoryInterface) : ViewModel() {

    private val _searchItem = MutableLiveData<List<SearchResponse>>()
    val searchItem :LiveData<List<SearchResponse>> get() = _searchItem
    var inputKeyword = "hi"


    fun getSearchList(offset: Int) {
        if (inputKeyword.isNotBlank() && inputKeyword.isNotEmpty()) {
            RepoInterface.getGifSearch(API_KEY, inputKeyword, offset,
                success = {
                    _searchItem.value = it
                },
                fail = {

                })

        } else {

        }

    }

    // 좋아요 누른 아이템 아이디목룍.
    suspend fun requestLikedItem() {
        RepoInterface.getLikedItem().let {
            if (it.isNotEmpty()) {
                LikedItemInfo.SearchResponse = it.toHashSet()
            }

        }

    }


}