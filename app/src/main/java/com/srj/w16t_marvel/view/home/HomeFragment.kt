package com.srj.w16t_marvel.view.home

import android.os.Bundle
import android.view.View
import com.srj.w16t_marvel.R
import com.srj.w16t_marvel.databinding.FragmentHomeBinding
import com.srj.w16t_marvel.view.base.BaseFragment
import com.srj.w16t_marvel.view.characters.CharactersViewModel

class HomeFragment: BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home) {
    override val viewModelClass = HomeViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp()
    }

    private fun setUp(){ }
}