package com.gsps.gsp_android.ui.main

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.os.Build
import android.provider.MediaStore
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.gsps.gsp_android.R
import com.gsps.gsp_android.databinding.ActivityMemberInfoWritingBinding
import com.gsps.gsp_android.ui.base.BaseActivity

class MemberInfoWritingActivity :
    BaseActivity<ActivityMemberInfoWritingBinding>(R.layout.activity_member_info_writing) {
    companion object {
        private const val REQUEST_CAMERA = 1000
    }

    private val categoryResultLauncher: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK && it.data != null) {
                binding.tvCategory.text = it.data?.getStringExtra("category")
            }
        }

    private val cameraResultLauncher: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK && it.data != null) {
                binding.llPictureBox.visibility = View.GONE
                val bitmap = it.data?.extras?.get("data") as Bitmap
                binding.ivMain.setImageBitmap(bitmap)
            }
        }

    private val albumResultLauncher: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK && it.data != null) {
                binding.llPictureBox.visibility = View.GONE
                val currentImageUri = it.data!!.data
                currentImageUri?.let {
                    val bitmap = if (Build.VERSION.SDK_INT < 28) {
                        MediaStore.Images.Media.getBitmap(this.contentResolver, currentImageUri)
                    } else {
                        val source =
                            ImageDecoder.createSource(this.contentResolver, currentImageUri)
                        ImageDecoder.decodeBitmap(source)
                    }
                    binding.ivMain.setImageBitmap(bitmap)
                }
            }
        }

    override fun initView() {
        binding.tvCategory.setOnClickListener {
            val intent = Intent(this, MemberInfoCategoryActivity::class.java)
            categoryResultLauncher.launch(intent)
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

        binding.btnCamera.setOnClickListener {
            if (cameraPermissionCheck()) {
                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                cameraResultLauncher.launch(intent)
            }
        }

        binding.btnAlbum.setOnClickListener {
            if (cameraPermissionCheck()) {
                val intent = Intent(Intent.ACTION_PICK)
                intent.type = "image/*"
                albumResultLauncher.launch(intent)
            }
        }
    }

    private fun cameraPermissionCheck(): Boolean {
        val permissionCheck =
            ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA)
        return if (permissionCheck == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.CAMERA),
                REQUEST_CAMERA
            )
            false
        } else true
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CAMERA) {
            if (grantResults[0] == 0) {
                cameraResultLauncher.launch(intent)
            }
        }
    }
}