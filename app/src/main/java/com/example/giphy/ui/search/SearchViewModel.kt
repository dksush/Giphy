package com.example.giphy.ui.search

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.giphy.common.StringConst.Companion.API_KEY
import com.example.giphy.data.model.SearchData
import com.example.giphy.data.repository.GiphyRepositoryInterface

class SearchViewModel(private val RepoInterface: GiphyRepositoryInterface) : ViewModel() {

    val _searchItem = MutableLiveData<List<SearchData>>()
    val searchItem get() = _searchItem
    var inputKeyword = "hi"


    fun getSearchList(offset: Int) {
        if (inputKeyword.isNotBlank() && inputKeyword.isNotEmpty()) {
            RepoInterface.getGifSearch(API_KEY, inputKeyword, offset,
                success = {
                    Log.v("dksush_성공", it[0].url)
                    Log.v("dksush_origin", it[0].images?.original?.url)
                    Log.v("dksush_size", it.size.toString())
                    _searchItem.value = it
                },
                fail = {

                })

        } else {

        }

    }


}