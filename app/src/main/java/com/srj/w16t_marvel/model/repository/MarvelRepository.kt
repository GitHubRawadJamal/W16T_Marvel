package com.srj.w16t_marvel.model.repository

import com.srj.w16t_marvel.model.network.State
import com.srj.w16t_marvel.model.response.marvelResponse.CharacterDataWrapper
import io.reactivex.rxjava3.core.Observable

interface MarvelRepository {
    fun getMarvelCharacters(): Observable<State<CharacterDataWrapper>>
}