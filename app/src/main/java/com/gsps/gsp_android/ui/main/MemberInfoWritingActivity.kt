package com.gsps.gsp_android.ui.main

import android.content.Intent
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.gsps.gsp_android.R
import com.gsps.gsp_android.databinding.ActivityMemberInfoWritingBinding
import com.gsps.gsp_android.ui.base.BaseActivity

class MemberInfoWritingActivity :
    BaseActivity<ActivityMemberInfoWritingBinding>(R.layout.activity_member_info_writing) {
    private val categoryResultListener: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                binding.tvCategory.text = it.data?.getStringExtra("category")
            }
        }
    
    override fun initView() {
        binding.tvCategory.setOnClickListener {
            val intent = Intent(this, MemberInfoCategoryActivity::class.java)
            categoryResultListener.launch(intent)
        }

        binding.clPictures.setOnClickListener {
            binding.llPictureBox.apply {
                when (this.visibility) {
                    View.GONE -> this.visibility = View.VISIBLE
                    View.VISIBLE -> this.visibility = View.GONE
                    View.INVISIBLE -> this.visibility = View.VISIBLE
                }
            }
        }
    }
}