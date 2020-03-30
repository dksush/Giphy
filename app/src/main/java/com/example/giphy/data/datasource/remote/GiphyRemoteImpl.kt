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
        // 굳이 withContext(Dispatchers.IO) 로 안해도 되긴 한다.
        // withContext : 코루틴 스코프는 유지한테 스레드만 전환
        val result = withContext(Dispatchers.IO) {
            NetworkUtil.apiService.getRequestSearch(api_key, q, offset)
        }
        // Response.code 나 에러 메세지 핸들링 가능
        // api 에 Response 가 선언되어 있어야함. 없으면 통신은 되나 Response.code 확인과 에러가 내려오는 부분을 핸들링 할 순 없다.

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