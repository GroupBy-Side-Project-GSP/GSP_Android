package com.gsps.gsp_android.ui.main

import android.content.Intent
import com.gsps.gsp_android.R
import com.gsps.gsp_android.databinding.ActivityMainBinding
import com.gsps.gsp_android.ui.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    override fun initView() {
        binding.btnSearch.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}