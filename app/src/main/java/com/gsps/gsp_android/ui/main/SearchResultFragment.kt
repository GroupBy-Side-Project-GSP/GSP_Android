package com.gsps.gsp_android.ui.main

import androidx.recyclerview.widget.LinearLayoutManager
import com.gsps.gsp_android.R
import com.gsps.gsp_android.databinding.FragmentSearchResultBinding
import com.gsps.gsp_android.ui.base.BaseFragment

class SearchResultFragment :
    BaseFragment<FragmentSearchResultBinding>(R.layout.fragment_search_result) {
    val adapter by lazy { SearchResultAdapter() }

    override fun initView() {
        adapter()
    }

    fun adapter() {
        val testList = listOf<SearchResultModel>(
            SearchResultModel("회사내용", "회사이름")
        )

        val linearLayoutManager = LinearLayoutManager(requireContext())
        adapter.addItems(testList)
        binding.rvSearchResult.layoutManager = linearLayoutManager
        binding.rvSearchResult.adapter = adapter
    }
}