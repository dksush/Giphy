package com.example.giphy.data.datasource.remote

import android.util.Log
import com.example.giphy.apis.NetworkUtil
import com.example.giphy.data.model.GiphyQueryResponse
import com.example.giphy.data.model.SearchData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GiphyRemotImpl : GiphyRemotInterface {
    override fun getGifSearch(
        api_key: String,
        q : String,
        offset: Int,
        success: (result: List<SearchData>) -> Unit,
        fail: (Throwable) -> Unit
    ) {
        NetworkUtil.apiService.getGifSearch(api_key,q, offset)
            .enqueue(object : Callback<GiphyQueryResponse<SearchData>>{
                override fun onFailure(call: Call<GiphyQueryResponse<SearchData>>, t: Throwable) {
                    Log.v("dksush_t", t.toString())
                }

                override fun onResponse(
                    call: Call<GiphyQueryResponse<SearchData>>,
                    response: Response<GiphyQueryResponse<SearchData>>
                ) {
                    Log.v("dksush_re_code", response.code().toString())

                    if (response.code() == 200){
                        response.body()?.data?.let(success)
                    }

                }

            })


//            .enqueue(object : Callback<GiphyQueryResponse<SearchData>>{
//                override fun onFailure(call: Call<List<SearchData>>, t: Throwable) {
//                }
//
//                override fun onResponse(
//                    call: Call<List<SearchData>>,
//                    response: Response<List<SearchData>>
//                ) {
//
//                    if (response.code() ==200){
//                        response.body()?.let(success)
//                    }
//                }
//
//            })



    }
}