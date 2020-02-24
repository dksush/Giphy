package com.example.giphy.data.model

data class GiphyQueryResponse<T>(
    val data: List<T>
)