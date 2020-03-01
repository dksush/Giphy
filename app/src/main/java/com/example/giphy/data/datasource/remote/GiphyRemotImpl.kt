package com.example.giphy.data.datasource.remote

import android.util.Log
import com.example.giphy.apis.NetworkUtil
import com.example.giphy.data.model.GiphyQueryResponse
import com.example.giphy.data.model.SearchResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GiphyRemotImpl : GiphyRemotInterface {
    override fun getGifSearch(
        api_key: String,
        q : String,
        offset: Int,
        success: (result: List<SearchResponse>) -> Unit,
        fail: (Throwable) -> Unit
    ) {
        NetworkUtil.apiService.getGifSearch(api_key,q, offset)
            .enqueue(object : Callback<GiphyQueryResponse<SearchResponse>>{
                override fun onFailure(call: Call<GiphyQueryResponse<SearchResponse>>, t: Throwable) {
                    Log.v("dksush_t", t.toString())
                }

                override fun onResponse(
                    call: Call<GiphyQueryResponse<SearchResponse>>,
                    response: Response<GiphyQueryResponse<SearchResponse>>
                ) {
                    Log.v("dksush_re_code", response.code().toString())

                    if (response.code() == 200){
                        response.body()?.data?.let(success)
                    }

                }

            })
    }

    override fun getFavoriteItme(
        api_key: String,
        ids: String,
        success: (result: List<SearchResponse>) -> Unit,
        fail: (Throwable) -> Unit
    ) {
        NetworkUtil.apiService.getLikedItem(api_key, ids)
            .enqueue(object : Callback<GiphyQueryResponse<SearchResponse>> {
                override fun onFailure(call: Call<GiphyQueryResponse<SearchResponse>>, t: Throwable) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onResponse(
                    call: Call<GiphyQueryResponse<SearchResponse>>,
                    response: Response<GiphyQueryResponse<SearchResponse>>
                ) {
                    Log.v("dksush_cdode_like", response.code().toString())

                    if (response.code() == 200) {
                        response.body()?.data?.let(success)
                    }
                }

            })
    }
}