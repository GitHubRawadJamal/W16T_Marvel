package com.srj.w16t_marvel.model.repository

import com.srj.w16t_marvel.model.network.MarvelApi
import com.srj.w16t_marvel.model.network.State
import com.srj.w16t_marvel.model.network.StateWrapper
import com.srj.w16t_marvel.model.response.marvelResponse.CharacterDataWrapper
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers


class MarvelRepositoryImpl(
    private val api: MarvelApi,
    private val stateWrapper: StateWrapper
): MarvelRepository{
    override fun getMarvelCharacters(): Observable<State<CharacterDataWrapper>> {
        return stateWrapper.wrapWithObservable { api.marvelApiService.getMarvelCharacters() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

}