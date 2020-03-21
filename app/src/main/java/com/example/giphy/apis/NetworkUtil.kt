package com.example.giphy.apis


import com.example.giphy.apis.Api.Companion.BASE_URL
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.io.IOException


object NetworkUtil {
    private val okHttpClient: OkHttpClient by lazy {

        // 통신로그
        val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)
        OkHttpClient.Builder()
            .addInterceptor(logging)
            .addInterceptor(AppInterceptor())
            .build()
    }


    val apiService: Api = getRetrofit(BASE_URL).create()

    private fun getRetrofit(baseUrl: String): Retrofit {
        return try {
            Retrofit.Builder().client(okHttpClient)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                //.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

        } catch (e: Exception) {
            e.printStackTrace()
            Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                //.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        }
    }

    // 인터셉터.
    class AppInterceptor : Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            val mRequest = chain.request()
            val newRequest = mRequest.newBuilder()
                //.addHeader("X-Naver-Client-Id", "Cjj07G06ms2sCWlKWezF")
               // .addHeader("X-Naver-Client-Secret", "4v_hXcCSrz")
                .build()
            return chain.proceed(newRequest)
        }
    }



}