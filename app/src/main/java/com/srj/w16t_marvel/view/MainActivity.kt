package com.srj.w16t_marvel.view

import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.srj.w16t_marvel.R
import com.srj.w16t_marvel.databinding.ActivityMainBinding
import com.srj.w16t_marvel.view.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun onResume() {
        super.onResume()
        NavigationUI.setupActionBarWithNavController(this, findNavController(R.id.fragment_host))
        supportActionBar?.setIcon(R.drawable.ic_arrow_back)
        supportActionBar?.elevation = 0F
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragment_host)
        navController.navigateUp()
        return true
    }
}