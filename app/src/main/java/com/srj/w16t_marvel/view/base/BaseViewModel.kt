package com.srj.w16t_marvel.view.base

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.srj.w16t_marvel.model.network.State
import com.srj.w16t_marvel.model.repository.MarvelRepositoryImpl
import com.srj.w16t_marvel.model.response.marvelResponse.Character
import com.srj.w16t_marvel.model.response.marvelResponse.CharacterDataWrapper
import com.srj.w16t_marvel.util.extensions.add
import com.srj.w16t_marvel.util.extensions.observeOnMainThread
import io.reactivex.rxjava3.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {
    protected val compositeDisposable = CompositeDisposable()

    private val marvelRepository = MarvelRepositoryImpl()

    private val _charactersResponseData = MutableLiveData<State<CharacterDataWrapper?>>(State.Loading)
    val charactersResponseData: LiveData<State<CharacterDataWrapper?>> = _charactersResponseData

    val listCharacters = MutableLiveData<List<Character?>?>()

    init {
       getAllCharacters()
    }

    private fun getAllCharacters(){
        marvelRepository.getAllCharacters().run {
            observeOnMainThread()
                .subscribe(::onGetAllCharactersSuccess, ::onGetAllCharactersError)
        }.add(compositeDisposable)
    }

    private fun onGetAllCharactersSuccess(response: State<CharacterDataWrapper>) {
        when (response) {
            is State.Success -> onStateSuccess(response)
            is State.Error -> onStateError(response.message)
        }
    }
    private fun onGetAllCharactersError(throwable: Throwable){
        _charactersResponseData.postValue(State.Error(throwable.message.toString()))
    }

    private fun onStateSuccess(response: State<CharacterDataWrapper?>) {
        Log.i("MARVEL",response.toData()?.data?.results.toString())
        _charactersResponseData.value = State.Success(response.toData())
        listCharacters.postValue(response.toData()?.data?.results)
    }

    private fun onStateError(message: String) {
        _charactersResponseData.postValue(State.Error(message))
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}