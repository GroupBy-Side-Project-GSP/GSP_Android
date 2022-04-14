package com.gsps.gsp_android.ui.main

import java.time.Instant
import java.time.LocalTime
import java.time.ZoneId

data class ScheduleModel(
    var start: LocalTime = Instant.ofEpochMilli(System.currentTimeMillis()).atZone(ZoneId.systemDefault()).toLocalTime(),
    var end: LocalTime = Instant.ofEpochMilli(System.currentTimeMillis()).atZone(ZoneId.systemDefault()).toLocalTime(),
    var title: String = "",
    var place: String = "",
    var companyName: String = "",
    var logoUrl: String = ""
)
