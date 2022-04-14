package com.gsps.gsp_android.ui.main

import com.gsps.gsp_android.R
import com.gsps.gsp_android.databinding.FragmentCalendarBinding
import com.gsps.gsp_android.ui.base.BaseFragment
import java.util.*

class CalendarFragment : BaseFragment<FragmentCalendarBinding>(R.layout.fragment_calendar) {
    override fun initView() {
        var calendar = Calendar.getInstance()

        calendar.timeInMillis = System.currentTimeMillis()
        calendar.set(Calendar.DAY_OF_MONTH, 1)

        val itemList: MutableList<CalendarDayModel> = setCalendar(calendar)
        val plan: MutableList<ScheduleModel> = mutableListOf(ScheduleModel())
        itemList[15].setPlan(plan)
        val calendarAdapter = CalendarAdapter(requireContext(), itemList)

        binding.calendar.adapter = calendarAdapter

        binding.btnLastMonth.setOnClickListener {
            calendar = changeMonth(calendar, -1)

            val lastItemList: MutableList<CalendarDayModel> = setCalendar(calendar)
            val lastCalendarAdapter = CalendarAdapter(requireContext(), lastItemList)

            binding.calendar.removeAllViewsInLayout()
            binding.calendar.adapter = lastCalendarAdapter
        }

        binding.btnNextMonth.setOnClickListener {
            calendar = changeMonth(calendar, +1)

            val nextItemList: MutableList<CalendarDayModel> = setCalendar(calendar)
            val nextCalendarAdapter = CalendarAdapter(requireContext(), nextItemList)

            binding.calendar.removeAllViewsInLayout()
            binding.calendar.adapter = nextCalendarAdapter
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

    private fun setCalendar(calendar: Calendar): MutableList<CalendarDayModel> {
        val maxDate = calendar.getActualMaximum(Calendar.DATE)
        val week = calendar.get(Calendar.DAY_OF_WEEK) - 1
        val month = calendar.get(Calendar.MONTH) + 1
        val list: MutableList<CalendarDayModel> = mutableListOf()
        val plan: MutableList<ScheduleModel> = mutableListOf()

        for (i in 1..week) {
            list.add(CalendarDayModel(0, 0, plan, false, 0))
        }

        for (i in 1..maxDate) {
            list.add(CalendarDayModel(month, i, plan, false, week))
        }

        binding.tvMonth.text =
            String.format(getString(R.string.set_year), calendar.get(Calendar.YEAR), month)

        return list
    }
}