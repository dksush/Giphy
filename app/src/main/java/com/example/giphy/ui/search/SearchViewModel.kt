package com.example.giphy.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.giphy.common.StringConst.Companion.API_KEY
import com.example.giphy.data.model.SearchResponse
import com.example.giphy.data.repository.GiphyRepositoryInterface


class SearchViewModel(private val RepoInterface: GiphyRepositoryInterface) : ViewModel() {

    // 검색 리스트
    private val _searchList = MutableLiveData<List<SearchResponse>>()
    val searchList: LiveData<List<SearchResponse>> get() = _searchList

    var inputKeyword = ""
    val blankInputText = MutableLiveData<Unit>()
    val errorToast = MutableLiveData<Throwable>()
    val nonResult = MutableLiveData<Unit>()

    // 좋아요 리스트.
    var likedItemInfo = mutableSetOf<String>()


    fun requestSearch() {
        if (inputKeyword.isNotBlank() && inputKeyword.isNotEmpty()) {
            RepoInterface.getGifSearch(API_KEY, inputKeyword, 0,
                success = {
                    if (it.isEmpty()){ // 검색결과 없을시.
                        nonResult.value = Unit
                    }else{
                        _searchList.value = it
                    }
                },
                fail = {
                    errorToast.value = it
                })

        } else {
            blankInputText.value = Unit
        }

    }

    fun requestAddItem(searchStartIndex: Int) {
        RepoInterface.getGifSearch(API_KEY, inputKeyword, searchStartIndex,
            success = {
                if (it.isEmpty()) {
                    nonResult.value = Unit
                } else {
                    _searchList.value = _searchList.value?.toMutableList()?.apply {
                        addAll(it)
                    }
                }
            },
            fail = {
                errorToast.value = it
            })


    }
}