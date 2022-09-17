package com.srj.w16t_marvel.model.network

import com.srj.w16t_marvel.util.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object MarvelApi {
    private val marvelClient = OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor()).build()
    private val marvelRetrofit = Retrofit.Builder()
        .baseUrl(Constants.MARVEL_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .client(marvelClient)
        .build()

    val marvelApiService = marvelRetrofit.create(MarvelApiService::class.java)

}

