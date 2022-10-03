package com.srj.w16t_marvel.model.network

import io.reactivex.rxjava3.core.Single
import retrofit2.Response

class StateWrapper {

    fun <T> wrapWithSingle(response: Single<Response<T>>): Single<State<T>> =
        response.map{
            if(it.isSuccessful){
                State.Success(it.body())
            } else{
                State.Error(it.message())
            }
        }

}