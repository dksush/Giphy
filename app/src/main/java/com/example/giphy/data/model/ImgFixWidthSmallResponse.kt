package com.example.giphy.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
data class ImgFixWidthSmallResponse(
    val url: String,
    val webp: String,
    val height: Int,
    val width: Int


) : Parcelable