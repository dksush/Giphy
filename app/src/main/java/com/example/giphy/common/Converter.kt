package com.example.giphy.common

import androidx.room.TypeConverter
import com.example.giphy.data.model.SearchResponse

object Converter {

    @TypeConverter
    fun listToHashset(value: MutableList<SearchResponse>?): HashSet<SearchResponse>? {
        return value?.run {
            HashSet(this)
        }
    }

    @TypeConverter
    fun hashsetToList(date: HashSet<SearchResponse>?): MutableList<SearchResponse>? {
        return date?.toMutableList()
    }


}