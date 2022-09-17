package com.srj.w16t_marvel.model.network

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.Response

class StateWrapper {
    fun <T> wrapWithObservable(function: () -> Single<Response<T>>):
            Observable<State<T>> = Observable.create { emitter ->
        emitter.onNext(State.Loading)
        try {
            function().subscribe(
                { emitter.onNext(State.Success(it.body())) },
                { emitter.onNext(State.Error(it.message.toString())) }
            )
        } catch (e: Exception) {
            emitter.onNext(State.Error(e.message.toString()))
        }
    }
}