package com.example.giphy.data.model

import java.io.Serializable

data class SearchData(
    val id: String,
    val url: String,
    val title: String,
    val images: SearchImage
) : Serializable

data class SearchImage(
    val fixed_width_small: ImgFixedWidthSmall,
    val original: ImgOriginal
) : Serializable