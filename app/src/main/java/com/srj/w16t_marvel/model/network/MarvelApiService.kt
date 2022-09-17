package com.srj.w16t_marvel.model.network

import com.srj.w16t_marvel.model.response.marvelResponse.CharacterDataWrapper
import com.srj.w16t_marvel.util.Constants
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApiService {
    @GET("/v1/public/characters")
    fun getMarvelCharacters(
        @Query("apikey")apikey:String =Constants.API_KEY,
        @Query("ts")ts:String = Constants.TIME_STAMP,
        @Query("hash")hash:String = Constants.hash(),
        @Query("limit")limit:String = Constants.LIMIT
    ): Single<Response<CharacterDataWrapper>>
}