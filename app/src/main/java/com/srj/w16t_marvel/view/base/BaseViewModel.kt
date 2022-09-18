package com.srj.w16t_marvel.view.base

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.srj.w16t_marvel.model.network.MarvelApi
import com.srj.w16t_marvel.model.network.State
import com.srj.w16t_marvel.model.network.StateWrapper
import com.srj.w16t_marvel.model.repository.MarvelRepositoryImpl
import com.srj.w16t_marvel.model.response.marvelResponse.Character
import com.srj.w16t_marvel.model.response.marvelResponse.CharacterDataWrapper
import com.srj.w16t_marvel.util.extensions.add
import io.reactivex.rxjava3.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {
    protected val compositeDisposable = CompositeDisposable()

    private val marvelRepository = MarvelRepositoryImpl(MarvelApi, StateWrapper())

    private val _marvelData = MutableLiveData<State<CharacterDataWrapper?>>()
    val marvelData: LiveData<State<CharacterDataWrapper?>> = _marvelData

    val marvelResult = MutableLiveData<List<Character?>?>()

    init {
        getMarvelData()
    }

    private fun getMarvelData(){
        marvelRepository.getMarvelCharacters()
            .subscribe(::onGetMarvelDataSuccess, ::onGetMarvelDataError)
            .add(compositeDisposable)
    }

    private fun onGetMarvelDataSuccess(response: State<CharacterDataWrapper>) {
        when (response) {
            is State.Loading -> _marvelData.postValue(response)
            is State.Success -> onStateSuccess(response)
            is State.Error -> onStateError(response.message)
        }
    }
    private fun onGetMarvelDataError(throwable: Throwable){
        _marvelData.postValue(State.Error(throwable.message.toString()))
    }

    private fun onStateSuccess(response: State<CharacterDataWrapper?>) {
        _marvelData.value = State.Success(response.toData())
        marvelResult.postValue(response.toData()?.data?.results)
        Log.i("MARVEL",response.toData()?.data?.results.toString())
    }

    private fun onStateError(message: String) {
        _marvelData.postValue(State.Error(message))
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}