package com.gsps.gsp_android.ui.main

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Gallery
import android.widget.Toast
import com.gsps.gsp_android.R
import com.gsps.gsp_android.databinding.ActivityProfileBinding
import com.gsps.gsp_android.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileActivity : BaseActivity<ActivityProfileBinding>(
R.layout.activity_profile
) {

    private lateinit var pbinding: ActivityProfileBinding

    val PERM_STORAGE=9
    val PERM_CAMEARA=10

    val REQ_GALLERL = 12


    override fun initView() {
        pbinding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(pbinding.root)

        binding.IbProfileImage.setOnClickListener{
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
                        pbinding.IbProfileImage.setImageURI(uri)
                    }
                }
            }
        }
    }
    fun next(){
        if(pbinding.EdProfileName.text.toString()==null){
            Toast.makeText(this, "기업 이름이 비어있습니다.", Toast.LENGTH_SHORT).show()
        }else{
            val intent = Intent(this,InterestActivity::class.java)
        }

    }




}






//        pbinding.IbProfileImage.setOnClickListener{
//            val intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
//            intent.setType("image/*")
//            startActivityForResult(intent,1)
//        }
//
//        @Override
//        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//            super.onActivityResult(requestCode, resultCode, data)
//            if( resultCode == Activity.RESULT_OK){
//                if( requestCode == 1) {
//                    var ImnageData: Uri? = data?.data
//                    Toast.makeText(this,ImnageData.toString(), Toast.LENGTH_SHORT ).show()
//                    try {
//                        val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, ImnageData)
//                        GImageView.setImageBitmap(bitmap)
//                    } catch (e:Exception) {
//                        e.printStackTrace()
//                    }
//                }
//            }
//        }
