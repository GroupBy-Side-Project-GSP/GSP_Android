package com.gsps.gsp_android.ui.main

import androidx.recyclerview.widget.GridLayoutManager
import com.gsps.gsp_android.R
import com.gsps.gsp_android.databinding.FragmentCalendarBinding
import com.gsps.gsp_android.ui.base.BaseFragment
import java.util.*

class CalendarFragment : BaseFragment<FragmentCalendarBinding>(R.layout.fragment_calendar) {
    private val calendarAdapter: CalendarAdapter by lazy { CalendarAdapter() }
    override fun initView() {
        binding.dayContainer.apply {
            layoutManager = GridLayoutManager(context, 7, GridLayoutManager.VERTICAL, false)
            adapter = calendarAdapter
        }

        val calendar = Calendar.getInstance()

        calendar.timeInMillis = System.currentTimeMillis()
        calendar.set(Calendar.DAY_OF_MONTH, 1)

        val tmpCal = calendar.timeInMillis
        calendar.timeInMillis = tmpCal

        setCalendar(calendar)

    }

    fun setCalendar(calendar: Calendar) {
        val maxDate = calendar.getActualMaximum(Calendar.DATE)
        val week = calendar.get(Calendar.DAY_OF_WEEK) - 1
        val month = calendar.get(Calendar.MONTH) + 1
        val list = MutableList(week, init = { CalendarDayModel() })

        for (i in 1..maxDate) {
            list.add(CalendarDayModel(DateType.NORMAL, month, i))
            list[week + i - 1].plan.add(ScheduleModel(title = "임시 약속"))
        }

        binding.tvMonth.text = "${calendar.get(Calendar.YEAR)}년 ${month}월"
        calendarAdapter.submitList(list)
    }
}