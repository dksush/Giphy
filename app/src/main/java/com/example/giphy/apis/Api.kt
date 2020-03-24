package com.example.giphy.apis

import com.example.giphy.data.model.GiphyQueryResponse
import com.example.giphy.data.model.SearchResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    companion object {
        const val BASE_URL: String = "https://api.giphy.com/v1/"

    }

    @GET("gifs/search")
    suspend fun getRequestSearch(
        @Query("api_key") api_key: String,
        @Query("q") q: String,
        @Query("offset") page: Int
    ): Response<GiphyQueryResponse<SearchResponse>>
    // Response 업어도 됨. 다만 없으면, Response.code 등을 얻을 수 없다.

    @GET("gifs")
    fun getFavoriteItem(
        @Query("api_key") api_key: String,
        @Query("ids") ids: String
    ): Call<GiphyQueryResponse<SearchResponse>>
}