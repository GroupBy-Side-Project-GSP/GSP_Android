package com.gsps.gsp_android.ui.main

import java.time.LocalDate
import java.time.LocalTime

data class ScheduleModel(
    var date: LocalDate = LocalDate.now(),
    var startTime: LocalTime = LocalTime.now(),
    var endTime: LocalTime = LocalTime.now(),
    var info: String = "",
    var place: String = "",
    var proposalCompanyId: Int = 0,
    var participantCompanyId: Int = 0
)
