package com.srj.w16t_marvel.view.characters

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.srj.w16t_marvel.R
import com.srj.w16t_marvel.databinding.FragmentCharactersBinding
import com.srj.w16t_marvel.view.base.BaseFragment

class CharactersFragment: BaseFragment<FragmentCharactersBinding, CharactersViewModel>(R.layout.fragment_characters) {
    override val viewModelClass = CharactersViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).supportActionBar?.show()
        binding.recyclerMarvelCharacter.adapter = CharactersAdapter(mutableListOf(), viewModel)
        setUp()
    }

    private fun setUp(){ }

}