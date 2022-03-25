package com.gsps.gsp_android.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gsps.gsp_android.R
import com.gsps.gsp_android.databinding.ActivityMyPageBinding
import com.gsps.gsp_android.ui.base.BaseActivity

class MyPageActivity : BaseActivity<ActivityMyPageBinding>(
    R.layout.activity_my_page
) {


    override fun initView() {

        binding.conMyProEdite.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        binding.conMyOffice.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.conMyInterest.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.conMyNotion.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.conMyAppSetting.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}