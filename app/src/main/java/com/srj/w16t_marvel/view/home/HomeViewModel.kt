package com.srj.w16t_marvel.view.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.srj.w16t_marvel.model.network.MarvelApi
import com.srj.w16t_marvel.model.network.State
import com.srj.w16t_marvel.model.network.StateWrapper
import com.srj.w16t_marvel.model.repository.MarvelRepositoryImpl
import com.srj.w16t_marvel.model.response.marvelResponse.Character
import com.srj.w16t_marvel.model.response.marvelResponse.CharacterDataWrapper
import com.srj.w16t_marvel.util.extensions.add
import com.srj.w16t_marvel.view.base.BaseViewModel
import com.srj.w16t_marvel.view.characters.CharactersInteractionListener

class HomeViewModel: BaseViewModel(), HomeInteractionListener {

}