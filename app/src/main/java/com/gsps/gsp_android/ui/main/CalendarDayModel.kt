package com.gsps.gsp_android.ui.main

import java.time.LocalDate

data class CalendarDayModel(
    var date: LocalDate,
    var plan: MutableList<PlanModel>,
    var isSelected: Boolean
)
