package com.example.giphy.data.datasource.remote

import com.example.giphy.apis.NetworkUtil
import com.example.giphy.data.model.GiphyQueryResponse
import com.example.giphy.data.model.SearchResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GiphyRemoteImpl : GiphyRemoteInterface {
    override suspend fun getGifSearch(
        api_key: String,
        q: String,
        offset: Int
    ): List<SearchResponse> {
        val result = withContext(Dispatchers.IO) { // 굳이 withContext(Dispatchers.IO) 로 안해도 되긴 한다.
            NetworkUtil.apiService.getRequestSearch(api_key, q, offset)
        }
        return result.body()?.data!!
    }

    override fun getFavoriteItem(
        api_key: String,
        ids: String,
        success: (result: List<SearchResponse>) -> Unit,
        fail: (Throwable) -> Unit
    ) {
        NetworkUtil.apiService.getFavoriteItem(api_key, ids)
            .enqueue(object : Callback<GiphyQueryResponse<SearchResponse>> {
                override fun onFailure(
                    call: Call<GiphyQueryResponse<SearchResponse>>,
                    t: Throwable
                ) {

                }

                override fun onResponse(
                    call: Call<GiphyQueryResponse<SearchResponse>>,
                    response: Response<GiphyQueryResponse<SearchResponse>>
                ) {

                    if (response.code() == 200) {
                        response.body()?.data?.let(success)
                    }
                }

            })
    }
}