package com.gsps.gsp_android.ui.main

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.Window
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.gsps.gsp_android.R
import com.gsps.gsp_android.databinding.DialogScheduleBinding
import com.gsps.gsp_android.utils.DimensionUtils
import java.time.format.DateTimeFormatter

class ScheduleDialog(context: Context) : Dialog(context) {
    private val dialog = Dialog(context)
    private val binding: DialogScheduleBinding =
        DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.dialog_schedule, null, false)
    private val defaultImage = R.drawable.rounded_corner_4dp

    fun start(context: Context, item: ScheduleModel) {
        val dimension = DimensionUtils()

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(binding.root)
        dialog.setCancelable(true)

        with(binding) {
            startTime.text = item.start.format(DateTimeFormatter.ofPattern("M월 d일 a H:mm"))
            finishTime.text = item.end.format(DateTimeFormatter.ofPattern("M월 d일 a H:mm"))
            tvScheduleTitle.text = item.title
            place.text = "${item.place} ${item.placeDetail}"
            userName.text = item.companyName

            Glide.with(context)
                .load(item.logoUrl)
                .placeholder(defaultImage)
                .error(defaultImage)
                .fallback(defaultImage)
                .into(ivLogo)

            btnClose.setOnClickListener {
                dialog.dismiss()
            }
        }
        dialog.show()
        dialog.window?.setLayout(
            dimension.dpToPx(context, 320f),
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }
}