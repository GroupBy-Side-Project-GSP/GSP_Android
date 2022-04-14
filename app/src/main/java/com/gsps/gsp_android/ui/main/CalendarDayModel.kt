package com.gsps.gsp_android.ui.main

data class CalendarDayModel(
    private var month: Int,
    private var dayOfMonth: Int,
    private var plan: MutableList<ScheduleModel>,
    private var isChecked: Boolean,
    private var dayOfWeek: Int
) {
    fun getMonth(): Int {
        return month
    }

    fun setMonth(month: Int) {
        this.month = month
    }

    fun getDayOfMonth(): Int {
        return dayOfMonth
    }

    fun setDayOfMonth(dayOfMonth: Int) {
        this.dayOfMonth = dayOfMonth
    }

    fun getDayOfWeek(): Int {
        return dayOfMonth
    }

    fun setDayOfWeek(dayOfWeek: Int) {
        this.dayOfWeek = dayOfWeek
    }

    fun getPlan(): MutableList<ScheduleModel> {
        return plan
    }

    fun setPlan(plan: MutableList<ScheduleModel>) {
        this.plan = plan
    }

    fun getChecked(): Boolean {
        return isChecked
    }

    fun setChecked(isChecked: Boolean) {
        this.isChecked = isChecked
    }
}
