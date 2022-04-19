package com.gsps.gsp_android.utils

import android.content.Context
import android.util.TypedValue

class DimensionUtils {
    fun dpToPx(context: Context, dp: Float): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dp.toFloat(),
            context.resources.displayMetrics
        ).toInt()
    }
}