package com.gsps.gsp_android.ui.main

import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
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
import java.io.FileOutputStream
import java.text.SimpleDateFormat

class MemberInfoWritingActivity :
    BaseActivity<ActivityMemberInfoWritingBinding>(R.layout.activity_member_info_writing) {
    companion object {
        private const val REQUEST_CAMERA = 1000
        private val PERMISSION_CAMERA = arrayOf(
            android.Manifest.permission.CAMERA,
            android.Manifest.permission.READ_EXTERNAL_STORAGE,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
    }

    private val categoryResultLauncher: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK && it.data != null) {
                binding.tvCategory.text = it.data?.getStringExtra("category")
            }
        }

    private val cameraResultLauncher: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK && it.data?.extras?.get("data") != null) {
                binding.llPictureBox.visibility = View.GONE
                val bitmap = it.data?.extras?.get("data") as Bitmap
                val uri = saveFile(randomFileName(), "image/*", bitmap)
                binding.ivMain.setImageURI(uri)
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
            if (permissionCheck()) {
                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                cameraResultLauncher.launch(intent)
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
        for (permission in PERMISSION_CAMERA) {
            val permissionCheck =
                ContextCompat.checkSelfPermission(this, permission)
            if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, PERMISSION_CAMERA, REQUEST_CAMERA)
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

    private fun saveFile(fileName: String, mimeType: String, bitmap: Bitmap): Uri? {
        val contentValues = ContentValues()
        contentValues.put(MediaStore.Images.Media.DISPLAY_NAME, fileName)
        contentValues.put(MediaStore.Images.Media.MIME_TYPE, mimeType)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            contentValues.put(MediaStore.Images.Media.IS_PENDING, 1)
        }

        val uri =
            contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)

        if (uri != null) {
            val descriptor = contentResolver.openFileDescriptor(uri, "w")

            if (descriptor != null) {
                val fileOutputStream = FileOutputStream(descriptor.fileDescriptor)
                bitmap.compress(Bitmap.CompressFormat.PNG, 0, fileOutputStream)
                fileOutputStream.close()

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    contentValues.clear()
                    contentValues.put(MediaStore.Images.Media.IS_PENDING, 1)
                    contentResolver.update(uri, contentValues, null, null)
                }
            }
        }
        return uri
    }

    private fun randomFileName(): String {
        return SimpleDateFormat(getString(R.string.pattern_yyyyMMdd_HHmmss)).format(System.currentTimeMillis())
    }
}