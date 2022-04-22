package com.gsps.gsp_android.ui.main

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.ImageDecoder
import android.media.MediaScannerConnection
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import com.gsps.gsp_android.R
import com.gsps.gsp_android.databinding.ActivityMemberInfoWritingBinding
import com.gsps.gsp_android.ui.base.BaseActivity
import java.io.File
import java.io.IOException
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

    private lateinit var photoUri: Uri
    private lateinit var imageFilePath: String

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

                /*
                RESULT_OK -> {
                    binding.llPictureBox.visibility = View.GONE
                    binding.ivMain.setImageURI(photoUri)
                }
                RESULT_CANCELED -> {
                    binding.llPictureBox.visibility = View.GONE

                }
                */

                RESULT_OK -> {
                    val file = File(imageFilePath)
                    if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.Q) {
                        val mediaScanIntent = Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE)
                        mediaScanIntent.data = Uri.fromFile(file)
                        sendBroadcast(mediaScanIntent)

                    } else {
                        var mediaScannerConnection: MediaScannerConnection? = null
                        val mMediaScannerClient =
                            object : MediaScannerConnection.MediaScannerConnectionClient {
                                override fun onMediaScannerConnected() {
                                    mediaScannerConnection?.scanFile(imageFilePath, null)
                                }

                                override fun onScanCompleted(path: String, uri: Uri) {
                                    mediaScannerConnection?.disconnect()
                                }
                            }

                        mediaScannerConnection = MediaScannerConnection(this, mMediaScannerClient)
                        mediaScannerConnection.connect()
                    }
                    binding.ivMain.setImageURI(photoUri)
                }
                RESULT_CANCELED -> {}
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
                if (intent.resolveActivity(packageManager) != null) {
                    var photoFile: File? = null

                    try {
                        photoFile = createImageFile()
                    } catch (ex: IOException) {
                        Log.d(
                            "MemberInfoWritingActivity!",
                            "Error occurred while creating the File"
                        )
                    }

                    if (photoFile != null) {
                        Log.d(
                            "MemberInfoWritingActivity!",
                            "btnCamera.setOnClickListener1"
                        )
                        photoUri =
                            FileProvider.getUriForFile(this, "com.gsps.gsp_android", photoFile)
                        Log.d(
                            "MemberInfoWritingActivity!",
                            "btnCamera.setOnClickListener2"
                        )
                        intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri)
                        Log.d(
                            "MemberInfoWritingActivity!",
                            "btnCamera.setOnClickListener3"
                        )
                        cameraResultLauncher.launch(intent)
                        Log.d(
                            "MemberInfoWritingActivity!",
                            "btnCamera.setOnClickListener4"
                        )
                    }
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

    @Throws(IOException::class)
    private fun createImageFile(): File {
        val timeStamp: String =
            SimpleDateFormat("yyyyMMdd_HHmmss").format(System.currentTimeMillis())
        val imageFileName = "BRIDGE_$timeStamp.jpg"
        val storageDir = File("${Environment.getExternalStorageDirectory()}/Pictures")
        if (!storageDir.exists()) {
            Log.d("MemberInfoWritingActivity!", storageDir.toString())
            storageDir.mkdirs()
        }
        val imageFile = File(storageDir, imageFileName)
        imageFilePath = imageFile.absolutePath
        return imageFile
    }
}