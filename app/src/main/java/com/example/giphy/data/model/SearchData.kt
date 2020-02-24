package com.example.giphy.data.model

data class SearchData(
    val id: String,
    val url: String
    //, var images: List<SearchImage>
    , val images: SearchImage

)

data class SearchImage(
    val fixed_width_small: ImgFixedWidthSmall
//    var original: List<ImageOriginal>

)