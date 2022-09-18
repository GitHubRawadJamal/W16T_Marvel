package com.srj.w16t_marvel.view.search

import androidx.lifecycle.MutableLiveData
import com.srj.w16t_marvel.model.response.marvelResponse.Character
import com.srj.w16t_marvel.view.base.BaseViewModel

class SearchViewModel: BaseViewModel(), SearchInteractionListener {

    val filteredCharacters = MutableLiveData<List<Character?>?>()

    fun filterCharacters(characterName: String?){
        marvelResult.value?.forEach {
            if(characterName?.toLowerCase()?.let { cn -> it?.name?.toLowerCase()?.contains(cn) } == true)
                filteredCharacters.postValue(listOf(it))
        }

    }

}