package com.gsps.gsp_android.ui.main

import androidx.recyclerview.widget.LinearLayoutManager
import com.gsps.gsp_android.R
import com.gsps.gsp_android.databinding.FragmentInterestsFullListBinding
import com.gsps.gsp_android.ui.base.BaseFragment

class InterestsFullListFragment :
    BaseFragment<FragmentInterestsFullListBinding>(R.layout.fragment_interests_full_list) {
    override fun initView() {
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        binding.fullListContainer.adapter =
            InterestsFullListAdapter(requireContext(), binding.model!!.innerList)
        binding.fullListContainer.layoutManager = LinearLayoutManager(requireContext())
    }
}