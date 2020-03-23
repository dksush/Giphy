package com.example.giphy.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "like_item")
@Parcelize //  주 생성자에 선언된 프로퍼티만 직렬화됨. 아닐 시 런타임 에러 발생. 주 생성자 외 프로퍼티 처리법 별도 존재.
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
) : Parcelable {

    constructor() : this(null, "", false,"", "", null)
}

@Parcelize
data class SearchImage(
    val fixed_width_small: ImgFixWidthSmallResponse,
    val original: ImgOriginResponse
) : Parcelable

