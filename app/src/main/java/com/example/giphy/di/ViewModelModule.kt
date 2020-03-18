package com.example.giphy.di

import com.example.giphy.MainViewModel
import com.example.giphy.data.model.SearchResponse
import com.example.giphy.ui.detail.GifDetailViewModel
import com.example.giphy.ui.favorite.FavoriteViewModel
import com.example.giphy.ui.search.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel {
        SearchViewModel(get())
    }

    viewModel { (search_data: SearchResponse) ->
        GifDetailViewModel(get(), search_data)
    }
    viewModel {
        FavoriteViewModel(get())
    }
    viewModel {
        MainViewModel(get())
    }
}
