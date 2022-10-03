package com.srj.w16t_marvel.util.extensions

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

fun Disposable.add(compositeDisposable: CompositeDisposable) {
    compositeDisposable.add(this)
}

fun <T: Any> Single<T>.observeOnMainThread(): Single<T> = subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())