package com.gsps.gsp_android.ui.main

import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.gsps.gsp_android.R
import com.gsps.gsp_android.databinding.FragmentMainPageBinding
import com.gsps.gsp_android.ui.base.BaseFragment

class MainPageFragment : BaseFragment<FragmentMainPageBinding>(R.layout.fragment_main_page) {
    //    list size = 0 ~ 5
    private val interestsCategoryList: MutableList<InterestsOuterListModel> = mutableListOf()
    override fun initView() {
        val fragmentNewMember = NewMemberFragment()
        val fragmentManager: FragmentManager = childFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.newMemberContainer, fragmentNewMember)
        fragmentTransaction.commit()

        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        binding.outerContainer.adapter =
            InterestsOuterListAdapter(requireContext(), interestsCategoryList)
        binding.outerContainer.layoutManager = LinearLayoutManager(requireContext())
    }
}