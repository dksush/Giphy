package com.example.giphy.apis

import com.example.giphy.data.model.GiphyQueryResponse
import com.example.giphy.data.model.SearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    companion object {
        const val BASE_URL: String = "https://api.giphy.com/v1/"

    }

    @GET("gifs/search")
    fun getGifSearch(
        @Query("api_key") api_key: String,
        @Query("q") q: String,
        @Query("offset") page: Int
    ): Call<GiphyQueryResponse<SearchResponse>>

    @GET("gifs")
    fun getLikedItem(
        @Query("api_key") api_key: String,
        @Query("ids") ids: String
    ): Call<GiphyQueryResponse<SearchResponse>>
}