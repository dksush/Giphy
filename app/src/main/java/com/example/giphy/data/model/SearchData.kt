package com.example.giphy.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

data class SearchData(
    val id: String,
    val url: String,
    val title: String,
    var images: SearchImage
) : Serializable

data class SearchImage(
    val fixed_width_small: ImgFixedWidthSmall,
    val original: ImgOriginal
) : Serializable