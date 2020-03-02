package com.example.giphy.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.giphy.common.LikedItemInfo
import com.example.giphy.common.StringConst.Companion.API_KEY
import com.example.giphy.data.model.SearchResponse
import com.example.giphy.data.repository.GiphyRepositoryInterface


class SearchViewModel(private val RepoInterface: GiphyRepositoryInterface) : ViewModel() {

    // 검색 리스트
    private val _searchList = MutableLiveData<List<SearchResponse>>()
    val searchList: LiveData<List<SearchResponse>> get() = _searchList

    // 페이징 리스트
    private val _addList = MutableLiveData<List<SearchResponse>>()
    val addList: LiveData<List<SearchResponse>> get() = _addList

    var inputKeyword = ""
    val blankInputText = MutableLiveData<Unit>()


    fun requestSearch() {
        if (inputKeyword.isNotBlank() && inputKeyword.isNotEmpty()) {
            RepoInterface.getGifSearch(API_KEY, inputKeyword, 0,
                success = {
                    _searchList.value = it
                },
                fail = {
                })

        } else {
            blankInputText.value = Unit
        }

    }

    fun requestAddItem(offset: Int) {
        RepoInterface.getGifSearch(API_KEY, inputKeyword, offset,
            success = {
                _addList.value = it
            },
            fail = {
            })


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