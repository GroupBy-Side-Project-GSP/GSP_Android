package com.gsps.gsp_android.ui.main

import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

data class ScheduleModel(
    var start: LocalDateTime = Instant.ofEpochMilli(System.currentTimeMillis())
        .atZone(ZoneId.systemDefault()).toLocalDateTime(),
    var end: LocalDateTime = Instant.ofEpochMilli(System.currentTimeMillis())
        .atZone(ZoneId.systemDefault()).toLocalDateTime(),
    var title: String = "",
    var place: String = "",
    var placeDetail: String = "",
    var companyName: String = "",
    var logoUrl: String = ""
)
