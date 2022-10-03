package com.srj.w16t_marvel.view.home

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.srj.w16t_marvel.R
import com.srj.w16t_marvel.databinding.FragmentHomeBinding
import com.srj.w16t_marvel.view.base.BaseFragment

class HomeFragment: BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home) {
    override val viewModelClass = HomeViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()
        binding.recyclerMarvelCharacter.adapter = HomeAdapter(mutableListOf(), viewModel)
        setUp()
    }

    private fun setUp(){
        binding.apply {
            textAllCharacters.setOnClickListener {
                requireView().findNavController().navigate(R.id.action_homeFragment_to_charactersFragment)
            }
            textSearchForCharacter.setOnClickListener {
                requireView().findNavController().navigate(R.id.action_homeFragment_to_searchFragment)
            }
        }

    }
}