package com.gsps.gsp_android.ui.main

import java.util.*

data class ScheduleModel(
    var start: Calendar,
    var end: Calendar,
    var title: String,
    var place: String,
    var companyName: String,
    var logoUrl: String
)
