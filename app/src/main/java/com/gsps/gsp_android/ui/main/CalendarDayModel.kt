package com.gsps.gsp_android.ui.main

data class CalendarDayModel(
    var dateType: DateType = DateType.EMPTY,
    var month: Int = 0,
    var dayOfMonth: Int = 0,
    var plan: MutableList<ScheduleModel> = mutableListOf(),
    var isChecked: Boolean = false,
    var dayOfWeek: Int = 0
)

enum class DateType {
    EMPTY, NORMAL, PLANNED, SELECTED
}
