package com.gsps.gsp_android.ui.main

import android.util.Log
import com.gsps.gsp_android.R
import com.gsps.gsp_android.databinding.FragmentCalendarBinding
import com.gsps.gsp_android.ui.base.BaseFragment
import java.util.*

class CalendarFragment : BaseFragment<FragmentCalendarBinding>(R.layout.fragment_calendar) {
    override fun initView() {
        val calendarAdapter = CalendarAdapter()
        binding.calendar.adapter = calendarAdapter

        var calendar = Calendar.getInstance()

        calendar.timeInMillis = System.currentTimeMillis()
        calendar.set(Calendar.DAY_OF_MONTH, 1)

        val tempCalendar = calendar.timeInMillis
        calendar.timeInMillis = tempCalendar

        setCalendar(calendarAdapter, calendar)

        binding.btnLastMonth.setOnClickListener {
            Log.d("CalendarFragment", "Last Button Clicked!!!")

            calendar = changeMonth(calendar, -1)
            setCalendar(calendarAdapter, calendar)
        }

        binding.btnNextMonth.setOnClickListener {
            Log.d("CalendarFragment", "Next Button Clicked!!!")

            calendar = changeMonth(calendar, +1)
            setCalendar(calendarAdapter, calendar)
        }
    }

    private fun changeMonth(calendarNow: Calendar, factor: Int): Calendar {
        val calendarPast = Calendar.getInstance()
        if (factor == -1) {
            when (calendarNow.get(Calendar.MONTH)) {
                0 -> calendarPast.set(
                    calendarNow.get(Calendar.YEAR) - 1,
                    11,
                    1
                )
                else -> calendarPast.set(
                    calendarNow.get(Calendar.YEAR),
                    calendarNow.get(Calendar.MONTH) - 1,
                    1
                )
            }
        } else {
            when (calendarNow.get(Calendar.MONTH)) {
                11 -> calendarPast.set(
                    calendarNow.get(Calendar.YEAR) + 1,
                    0,
                    1
                )

                else -> calendarPast.set(
                    calendarNow.get(Calendar.YEAR),
                    calendarNow.get(Calendar.MONTH) + 1,
                    1
                )
            }
        }
        return calendarPast
    }

    private fun setCalendar(adapter: CalendarAdapter, calendar: Calendar) {
        val maxDate = calendar.getActualMaximum(Calendar.DATE)
        val week = calendar.get(Calendar.DAY_OF_WEEK) - 1
        val month = calendar.get(Calendar.MONTH) + 1
        val list: MutableList<CalendarDayModel> = MutableList(week, init = { CalendarDayModel() })

        for (i in 1..maxDate) {
            list.add(CalendarDayModel(month, i))
        }
        adapter.submitList(list)

        binding.tvMonth.text =
            String.format(getString(R.string.set_year), calendar.get(Calendar.YEAR), month)
    }
}