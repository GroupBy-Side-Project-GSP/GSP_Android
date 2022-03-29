package com.gsps.gsp_android.ui.main

import java.time.LocalDate
import java.time.LocalTime

data class PlanModel(
    val date: LocalDate,
    val time: LocalTime,
    val info: String,
    val proposalCompanyId: Int,
    val participantCompanyId: Int
)
