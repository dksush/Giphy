package com.example.giphy.data.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "like_item")
data class SearchResponse(
    @PrimaryKey(autoGenerate = true)
    var index: Long?,
    var id: String,
    var isLike : Boolean,


    @Ignore
    val url: String,
    @Ignore
    val title: String,
    @Ignore
    val images: SearchImage?
) : Serializable {

    constructor() : this(null, "", false,"", "", null)
}


data class SearchImage(
    val fixed_width_small: ImgFixWidthSmallResponse,
    val original: ImgOriginResponse
) : Serializable

