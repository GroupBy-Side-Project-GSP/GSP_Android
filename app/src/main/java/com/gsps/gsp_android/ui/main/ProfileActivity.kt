package com.gsps.gsp_android.ui.main

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Gallery
import android.widget.ImageView
import android.widget.Toast
import com.gsps.gsp_android.R
import com.gsps.gsp_android.databinding.ActivityProfileBinding
import com.gsps.gsp_android.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

//@AndroidEntryPoint
class ProfileActivity : BaseActivity<ActivityProfileBinding>(
R.layout.activity_profile
) {

    val REQ_GALLERL = 1

    override fun initView() {
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPen.setOnClickListener{
            openGallary()

        }
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
        if(binding.EdProfileName.text.isEmpty()){
            Toast.makeText(this, "기업 이름이 비어있습니다.", Toast.LENGTH_SHORT).show()
        }else{
            val intent = Intent(this,InterestActivity::class.java)
            startActivity(intent)
        }

    }
}
