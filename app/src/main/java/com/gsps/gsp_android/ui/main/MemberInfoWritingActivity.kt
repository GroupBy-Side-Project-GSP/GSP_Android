package com.gsps.gsp_android.ui.main

import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.gsps.gsp_android.R
import com.gsps.gsp_android.databinding.ActivityMemberInfoWritingBinding
import com.gsps.gsp_android.ui.base.BaseActivity
import java.text.SimpleDateFormat


class MemberInfoWritingActivity :
    BaseActivity<ActivityMemberInfoWritingBinding>(R.layout.activity_member_info_writing) {
    companion object {
        private const val REQUEST_CAMERA = 1000
        private lateinit var permissions: Array<String>
    }

    private var imageUri: Uri? = null

    private val categoryResultLauncher: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK && it.data != null) {
                binding.tvCategory.text = it.data?.getStringExtra("category")
            }
        }

    private val cameraResultLauncher: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            binding.llPictureBox.visibility = View.GONE

            when (it.resultCode) {
                RESULT_OK -> {
                    binding.ivMain.setImageURI(imageUri)
                }
                else -> {
                    imageUri?.let { uri -> contentResolver.delete(uri, null, null) }
                }
            }
        }

    private val albumResultLauncher: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            binding.llPictureBox.visibility = View.GONE

            if (it.resultCode == RESULT_OK && it.data != null) {
                val currentImageUri = it.data!!.data
                currentImageUri?.let {
                    val bitmap = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                        val source =
                            ImageDecoder.createSource(this.contentResolver, currentImageUri)
                        ImageDecoder.decodeBitmap(source)
                    } else {
                        MediaStore.Images.Media.getBitmap(this.contentResolver, currentImageUri)
                    }
                    binding.ivMain.setImageBitmap(bitmap)
                }
            }
        }

    override fun initView() {
        permissions = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            arrayOf(android.Manifest.permission.CAMERA)
        } else {
            arrayOf(
                android.Manifest.permission.CAMERA,
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE
            )
        }

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
            if (permissionCheck()) {
                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

                if (intent.resolveActivity(packageManager) != null) {
                    imageUri = saveImageInExternalPublicStorage()
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri)
                    cameraResultLauncher.launch(intent)
                }
            }
        }

        binding.btnAlbum.setOnClickListener {
            if (permissionCheck()) {
                val intent = Intent(Intent.ACTION_PICK)
                intent.type = "image/*"
                albumResultLauncher.launch(intent)
            }
        }
    }

    private fun permissionCheck(): Boolean {
        for (permission in permissions) {
            val permissionCheck =
                ContextCompat.checkSelfPermission(this, permission)
            if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, permissions, REQUEST_CAMERA)
                return false
            }
        }
        return true
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            REQUEST_CAMERA -> {
                for (grant in grantResults) {
                    if (grant != PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(this, "권한을 승인해주세요", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

    private fun saveImageInExternalPublicStorage(): Uri? {
        val timeStamp: String =
            SimpleDateFormat("yyyyMMdd_HHmmss").format(System.currentTimeMillis())
        val resolver = applicationContext.contentResolver
        val imageCollection = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            MediaStore.Images.Media.getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY)
        } else {
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        }
        val imageFileName = "BRIDGE_$timeStamp.jpg"
        val imageDetails =
            ContentValues().apply { put(MediaStore.Images.Media.DISPLAY_NAME, imageFileName) }
        val imageContentUri = resolver.insert(imageCollection, imageDetails)

        if (imageContentUri != null) {
            resolver.update(imageContentUri, imageDetails, null, null)
        }

        return imageContentUri
    }
}