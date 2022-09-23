package com.srj.w16t_marvel.view.search

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.srj.w16t_marvel.R
import com.srj.w16t_marvel.databinding.FragmentSearchBinding
import com.srj.w16t_marvel.view.base.BaseFragment

class SearchFragment: BaseFragment<FragmentSearchBinding, SearchViewModel>(R.layout.fragment_search) {
    override val viewModelClass = SearchViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).supportActionBar?.show()
        setUp()
        viewModel.searchInput.observe(viewLifecycleOwner){
            viewModel.filterCharacters(it.toString())
        }
    }

    private fun setUp() {}
}