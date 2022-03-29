package com.gsps.gsp_android.ui.main

import java.time.LocalDate

data class CalendarDayModel(
    val date: LocalDate,
    val plan: MutableList<PlanModel>
)
