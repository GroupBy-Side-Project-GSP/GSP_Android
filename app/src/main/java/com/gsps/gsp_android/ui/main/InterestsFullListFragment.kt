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
        val itemList =
            mutableListOf(
                InterestsMemberModel(
                    "회사1",
                    "회사 설명을 어디까지 적어야 두 줄 이상으로 넘어갈까요? 이정도면 되었을까요? 글씨가 작아서 아닐지도 몰라요."
                ),
                InterestsMemberModel(
                    "회사2",
                    "회사 설명을 어디까지 적어야 두 줄 이상으로 넘어갈까요? 이정도면 되었을까요? 글씨가 작아서 아닐지도 몰라요."
                ),
                InterestsMemberModel(
                    "회사3",
                    "회사 설명을 어디까지 적어야 두 줄 이상으로 넘어갈까요? 이정도면 되었을까요? 글씨가 작아서 아닐지도 몰라요."
                ),
                InterestsMemberModel(
                    "회사4",
                    "회사 설명을 어디까지 적어야 두 줄 이상으로 넘어갈까요? 이정도면 되었을까요? 글씨가 작아서 아닐지도 몰라요."
                ),
                InterestsMemberModel(
                    "회사5",
                    "회사 설명을 어디까지 적어야 두 줄 이상으로 넘어갈까요? 이정도면 되었을까요? 글씨가 작아서 아닐지도 몰라요."
                ),
                InterestsMemberModel(
                    "회사6",
                    "회사 설명을 어디까지 적어야 두 줄 이상으로 넘어갈까요? 이정도면 되었을까요? 글씨가 작아서 아닐지도 몰라요."
                ),
                InterestsMemberModel(
                    "회사7",
                    "회사 설명을 어디까지 적어야 두 줄 이상으로 넘어갈까요? 이정도면 되었을까요? 글씨가 작아서 아닐지도 몰라요."
                ),
                InterestsMemberModel(
                    "회사8",
                    "회사 설명을 어디까지 적어야 두 줄 이상으로 넘어갈까요? 이정도면 되었을까요? 글씨가 작아서 아닐지도 몰라요."
                )
            )

        binding.rlParent.adapter = InterestsFullListAdapter(requireContext(), itemList)
        binding.rlParent.layoutManager = LinearLayoutManager(requireContext())
    }
}