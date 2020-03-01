package com.example.giphy.data.model

import java.io.Serializable

data class ImgFixWidthSmallResponse(
    val url: String,
    val webp: String,
    val height: Int,
    val width: Int


) : Serializable