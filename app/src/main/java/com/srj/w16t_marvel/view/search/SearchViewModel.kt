package com.srj.w16t_marvel.view.search

import androidx.lifecycle.MutableLiveData
import com.srj.w16t_marvel.model.response.marvelResponse.Character
import com.srj.w16t_marvel.view.base.BaseViewModel

class SearchViewModel: BaseViewModel(), SearchInteractionListener {

    val filteredCharacters = MutableLiveData<List<Character?>?>()
    val searchInput = MutableLiveData<String?>()
    private val filteredList = mutableListOf<Character?>()


    fun filterCharacters(characterName: String?){
        filteredList.clear()
        listCharacters.value?.forEach {
            if(characterName?.toLowerCase()?.let { cn -> it?.name?.toLowerCase()?.contains(cn) } == true) filteredList.add(it)
        }
        if(filteredList.isNotEmpty() && characterName != "") filteredCharacters.postValue(filteredList) else filteredCharacters.postValue(emptyList())
    }

}