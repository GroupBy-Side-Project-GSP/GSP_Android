package com.gsps.gsp_android.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.gsps.gsp_android.R
import com.gsps.gsp_android.databinding.ActivityMainBinding
import com.gsps.gsp_android.ui.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>(
    R.layout.activity_main
) {

    private fun initBottomNav() {
        val navController =
            supportFragmentManager.findFragmentById(R.id.navHostFragmentActivityMain)?.findNavController()
        val nav = binding.bottomNav as BottomNavigationView
        navController?.let {
            nav.setupWithNavController(navController)
        }
    }

    override fun initView() {
        initBottomNav()
    }
}