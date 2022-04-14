package com.gsps.gsp_android.ui.main

import java.time.LocalTime

data class ScheduleModel(
    var start: LocalTime,
    var end: LocalTime,
    var title: String,
    var place: String,
    var companyName: String,
    var logoUrl: String
)
