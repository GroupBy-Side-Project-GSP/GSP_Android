package com.gsps.gsp_android.ui.main


import android.content.Intent

import android.provider.MediaStore
import android.text.Editable
import android.text.TextWatcher
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.gsps.gsp_android.R
import com.gsps.gsp_android.databinding.ActivityProfileBinding
import com.gsps.gsp_android.ui.base.BaseActivity

class ProfileActivity : BaseActivity<ActivityProfileBinding>(
R.layout.activity_profile
) {

    val REQ_GALLERL = 1

    override fun initView() {




        binding.btnPen.setOnClickListener{
            openGallary()

        }
        binding.EdProfileName.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(binding.EdProfileName.length()==0){
                    binding.BtnProfileComplete.isEnabled=false
                }else{
                    binding.BtnProfileComplete.isEnabled=true
                }
            }
            override fun afterTextChanged(p0: Editable?) {}
        })

        binding.BtnProfileComplete.setOnClickListener{
            next()
        }


    }



    fun openGallary(){
        val intent=Intent(Intent.ACTION_PICK)
        intent.type=MediaStore.Images.Media.CONTENT_TYPE
        startActivityForResult(intent, REQ_GALLERL)

    }


    @Override
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == RESULT_OK){
            when(requestCode){
                REQ_GALLERL -> {
                    data?.data.let { uri ->
                        binding.IbProfileImage.setScaleType(ImageView.ScaleType.FIT_XY)
                        binding.IbProfileImage.setBackgroundColor(getColor(R.color.white))
                        binding.IbProfileImage.setImageURI(uri)
                    }
                }
            }
        }
    }


    fun next(){
            val intent = Intent(this,InterestActivity::class.java)
            startActivity(intent)
    }
}
