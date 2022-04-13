package com.gsps.gsp_android.ui.main

import android.content.Intent
import androidx.recyclerview.widget.GridLayoutManager
import com.gsps.gsp_android.R
import com.gsps.gsp_android.databinding.ActivityMyOfficeBinding
import com.gsps.gsp_android.ui.base.BaseActivity

class MyOfficeActivity : BaseActivity<ActivityMyOfficeBinding>(R.layout.activity_my_office) {
    val adapter by lazy { MyOfficeAdapter() }

    override fun initView() {
        adapter()
        next()
    }

    fun next() {
        binding.btnOfficeBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    fun adapter() {
        val testList = listOf<MyOfficeModel>(
            MyOfficeModel("name1", "cate1"),
            MyOfficeModel("name2", "cate2"),
            MyOfficeModel("name3", "cate3"),
            MyOfficeModel("name4", "cate4"),
        )
        val gridLayoutManager = GridLayoutManager(applicationContext, 2)
        adapter.addItems(testList)
        binding.rvOffice.layoutManager = gridLayoutManager
        binding.rvOffice.adapter = adapter
    }
}