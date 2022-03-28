package com.gsps.gsp_android.ui.main

import androidx.recyclerview.widget.LinearLayoutManager
import com.gsps.gsp_android.R
import com.gsps.gsp_android.databinding.FragmentMainPageBinding
import com.gsps.gsp_android.ui.base.BaseFragment

class MainPageFragment : BaseFragment<FragmentMainPageBinding>(R.layout.fragment_main_page) {
    override fun initView() {
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        val itemList = mutableListOf(
            InterestsListModel(
                "#디자인",
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
                    )
                )
            ),
            InterestsListModel(
                "#환경&에너지",
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
                    )
                )
            )
        )

        binding.interestsListContainer.adapter = InterestsListAdapter(requireContext(), itemList)
        binding.interestsListContainer.layoutManager = LinearLayoutManager(requireContext())
    }
}