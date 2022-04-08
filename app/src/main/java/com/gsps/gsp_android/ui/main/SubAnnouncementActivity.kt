package com.gsps.gsp_android.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gsps.gsp_android.R
import com.gsps.gsp_android.databinding.ActivityAnnouncementBinding
import com.gsps.gsp_android.databinding.ActivitySubAnnouncementBinding
import com.gsps.gsp_android.ui.base.BaseActivity

class SubAnnouncementActivity : BaseActivity<ActivitySubAnnouncementBinding>(
    R.layout.activity_sub_announcement
) {
    override fun initView() {
        if (intent.hasExtra("title") || intent.hasExtra("date")) {
            binding.tvSubAnnouncementItemTitle.text = intent.getStringExtra("title")
            binding.tvSubAnnouncementItemDate.text = intent.getStringExtra("date")
        }
    }
}