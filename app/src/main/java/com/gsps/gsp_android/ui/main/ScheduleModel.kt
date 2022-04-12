package com.gsps.gsp_android.ui.main

import java.time.LocalTime

data class ScheduleModel(
    var year: Int = 2022,
    var month: Int = 4,
    var date: Int = 12,
    var startTime: LocalTime = LocalTime.now(),
    var endTime: LocalTime = LocalTime.now(),
    var info: String = "",
    var place: String = "",
    var companyName: String = "",
    var logoUrl: String = ""
)
