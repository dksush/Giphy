package com.example.giphy.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ImgOriginResponse(

    val url: String,
    val webp: String,
    val height: Int,
    val width: Int,
    val mp4 :String
) : Parcelable