package com.gsps.gsp_android.ui.main

import android.widget.TextView
import androidx.databinding.BindingAdapter

object BindingAdapter {
    @JvmStatic
    @BindingAdapter("app:setDate")
    fun TextView.setDate(item: CalendarDayModel?) {
        item?.let {
            text = it.dayOfMonth.toString()
        }
    }
}