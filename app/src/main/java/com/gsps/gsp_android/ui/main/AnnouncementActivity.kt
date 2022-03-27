package com.gsps.gsp_android.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.gsps.gsp_android.R
import com.gsps.gsp_android.databinding.ActivityAnnouncementBinding
import com.gsps.gsp_android.ui.base.BaseActivity

class AnnouncementActivity : BaseActivity<ActivityAnnouncementBinding>(
    R.layout.activity_announcement
) {

    val adapter by lazy { AnnouncementAdapter() }



    override fun initView() {

        val testList = listOf(
            AnnouncementModel("testTitle1","testDate1"),
            AnnouncementModel("testTitle2","testDate2"),
            AnnouncementModel("testTitle3","testDate3")
        )


        val linearLayoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)


        binding.RvAnnouncement.layoutManager=linearLayoutManager

        binding.RvAnnouncement.adapter=adapter

        adapter.addItems(testList)


        adapter.setOnItemClickListener(object :AnnouncementAdapter.ItemClickListener{
            override fun onItemClick(v: View, position: Int, model: AnnouncementModel) {
                val intent = Intent(this@AnnouncementActivity,SubAnnouncementActivity::class.java)
                intent.putExtra("title",model.title)
                intent.putExtra("date",model.date)
                startActivity(intent)
            }
        })
    }
}