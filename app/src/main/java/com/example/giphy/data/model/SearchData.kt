package com.example.giphy.data.model

data class SearchData(
    val id: String,
    val url: String
    //, var images: List<SearchImage>
    , var images: SearchImage? = null

)

data class SearchImage(
    var original: ImageOriginal? = null
//    var original: List<ImageOriginal>

)