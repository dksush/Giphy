package com.example.giphy.data.model

import java.io.Serializable

data class ImgOriginResponse (

    val url: String,
    val webp: String,
    val height: Int,
    val width: Int,
    val mp4 :String
) :Serializable