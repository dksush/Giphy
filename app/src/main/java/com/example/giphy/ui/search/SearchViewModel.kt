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


    suspend fun requestSearch() {
        if (inputKeyword.isNotBlank() && inputKeyword.isNotEmpty()) {
            try {
                val result = RepoInterface.getGifSearch(API_KEY, inputKeyword, 0)
                if (result.isEmpty()) {
                    nonResult.value = Unit
                } else {
                    _searchList.value = result
                }
            } catch (e: Exception) {
                errorToast.value = e
            }

        } else {
            blankInputText.value = Unit
        }

    }

    suspend fun requestAddItem(searchStartIndex: Int) {
        try {
            val result = RepoInterface.getGifSearch(API_KEY, inputKeyword, searchStartIndex)
            if (result.isEmpty()) {
                nonResult.value = Unit
            } else {
                _searchList.value = _searchList.value?.toMutableList()?.apply {
                    addAll(result)
                }
            }

        } catch (e: Exception) {
            errorToast.value = e
        }


    }
}