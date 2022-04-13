package com.gsps.gsp_android.ui.main

import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.gsps.gsp_android.R
import com.gsps.gsp_android.databinding.ActivityMemberInfoCategoryBinding
import com.gsps.gsp_android.ui.base.BaseActivity

class MemberInfoCategoryActivity :
    BaseActivity<ActivityMemberInfoCategoryBinding>(R.layout.activity_member_info_category), SetFinish {
    var category: String = ""
    var isSelected: Boolean = false
    override fun initView() {
        val category: MutableList<CategoryModel> = mutableListOf(
            CategoryModel("디자인", false),
            CategoryModel("건설", false),
            CategoryModel("인쇄&공예", false),
            CategoryModel("사무", false),
            CategoryModel("환경&에너지", false),
            CategoryModel("경영&회계", false),
            CategoryModel("화학&바이오", false),
            CategoryModel("영업판매", false),
            CategoryModel("섬유&의복", false),
            CategoryModel("기획&마케팅", false),
            CategoryModel("보건&의료", false),
            CategoryModel("전기&전자", false),
            CategoryModel("사회복지", false),
            CategoryModel("재료", false)
        )
        binding.categoryContainer.adapter = CategoryAdapter(this, category, this)
        binding.categoryContainer.layoutManager =
            StaggeredGridLayoutManager(5, LinearLayout.HORIZONTAL)
    }

    override fun setFinish(status: Boolean) {
        binding.btnFinish.isEnabled = status
    }
}