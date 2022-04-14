package com.gsps.gsp_android.ui.main

data class CalendarDayModel(
    var dateType: DateType,
    var month: Int,
    var dayOfMonth: Int,
    var plan: MutableList<ScheduleModel>,
    var isChecked: Boolean,
    var dayOfWeek: Int
)

enum class DateType{
    EMPTY, NORMAL, PLANNED, SELECTED
}
