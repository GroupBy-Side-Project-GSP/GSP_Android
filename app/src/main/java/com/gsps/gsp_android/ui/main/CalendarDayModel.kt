package com.gsps.gsp_android.ui.main

import java.time.Year

data class CalendarDayModel(
    var month: Int = 0,
    var dayOfMonth: Int = 0,
    var plan: MutableList<ScheduleModel> = MutableList(0, init = { ScheduleModel() }),
    var isSelected: Boolean = false,
    var dayOfWeek: Int = 0
)
