package com.gsps.gsp_android.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.gsps.gsp_android.R
import com.gsps.gsp_android.databinding.FragmentClickSearchBinding
import com.gsps.gsp_android.databinding.FragmentSearchBinding
import com.gsps.gsp_android.ui.base.BaseFragment


class ClickSearchFragment : BaseFragment<FragmentClickSearchBinding>(
    R.layout.fragment_click_search
) {

    val adapter by lazy { SearchTextAdapter() }
    val recentrecordadapter by lazy { SearchRecentRecordAdapter() }

    override fun initView() {
        adapter()
        recentrecordadapter()
    }

    fun adapter(){
        val testList = listOf<SearchTextModel>(
            SearchTextModel("검색어"),
        )

        val linearLayoutManager = LinearLayoutManager(requireContext())
        adapter.addItems(testList)
        binding.rvClickSearchText.layoutManager=linearLayoutManager
        binding.rvClickSearchText.adapter=adapter
    }

    fun recentrecordadapter(){
        val testList2 = listOf<SearchRecentRecordModel>(
            SearchRecentRecordModel("최근기록")
        )

        val linearLayoutManager = LinearLayoutManager(requireContext())
        recentrecordadapter.addItems(testList2)
        binding.rvRecentRecord.layoutManager=linearLayoutManager
        binding.rvRecentRecord.adapter=recentrecordadapter
    }
}