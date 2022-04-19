package com.gsps.gsp_android.ui.main

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gsps.gsp_android.R
import com.gsps.gsp_android.databinding.FragmentCalendarBinding
import com.gsps.gsp_android.ui.base.BaseFragment
import com.gsps.gsp_android.utils.DimensionUtils
import java.util.*

lateinit var scheduleAdapter: ScheduleAdapter

class CalendarFragment : BaseFragment<FragmentCalendarBinding>(R.layout.fragment_calendar) {
    private val calendarAdapter: CalendarAdapter by lazy { CalendarAdapter(requireContext()) }

    override fun initView() {
        scheduleAdapter = ScheduleAdapter(requireContext())

        binding.dayContainer.apply {
            itemAnimator = null
            layoutManager = GridLayoutManager(context, 7, GridLayoutManager.VERTICAL, false)
            adapter = calendarAdapter
        }

        binding.scheduleContainer.apply {
            itemAnimator = null
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = scheduleAdapter
        }

        var calendar = Calendar.getInstance()

        calendar.timeInMillis = System.currentTimeMillis()
        calendar.set(Calendar.DAY_OF_MONTH, 1)

        val tmpCal = calendar.timeInMillis
        calendar.timeInMillis = tmpCal

        setCalendar(calendar)

        binding.btnLastMonth.setOnClickListener {
            calendar = changeCalendar(calendar, -1)
            setCalendar(calendar)
        }

        binding.btnNextMonth.setOnClickListener {
            calendar = changeCalendar(calendar, +1)
            setCalendar(calendar)
        }

        binding.tvMonth.setOnClickListener {
            calendar.timeInMillis = System.currentTimeMillis()
            calendar.set(Calendar.DAY_OF_MONTH, 1)

            val tmpCal = calendar.timeInMillis
            calendar.timeInMillis = tmpCal

            setCalendar(calendar)
        }

        binding.scheduleContainer.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                super.getItemOffsets(outRect, view, parent, state)

                val dimension = DimensionUtils()

                when (parent.getChildAdapterPosition(view)) {
                    0 -> {
                        outRect.top = dimension.dpToPx(context!!, 16f)
                        outRect.bottom = dimension.dpToPx(context!!, 8f)
                    }
                    scheduleAdapter.itemCount - 1 -> {
                        outRect.top = dimension.dpToPx(context!!, 8f)
                        outRect.bottom = dimension.dpToPx(context!!, 16f)
                    }
                    else -> {
                        outRect.top = dimension.dpToPx(context!!, 8f)
                        outRect.bottom = dimension.dpToPx(context!!, 8f)
                    }
                }

                if (scheduleAdapter.itemCount == 1) {
                    outRect.top = dimension.dpToPx(context!!, 16f)
                    outRect.bottom = dimension.dpToPx(context!!, 16f)
                }
            }
        })
    }

    private fun changeCalendar(calendar: Calendar, factor: Int): Calendar {
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH) + 1

        when (factor) {
            -1 -> {
                if (month == 1)
                    calendar.set(year - 1, 11, 1)
                else
                    calendar.set(year, month - 2, 1)
            }
            +1 -> {
                if (month == 12)
                    calendar.set(year + 1, 0, 1)
                else
                    calendar.set(year, month, 1)
            }
        }
        return calendar
    }

    private fun setCalendar(calendar: Calendar) {
        val maxDate = calendar.getActualMaximum(Calendar.DATE)
        val week = calendar.get(Calendar.DAY_OF_WEEK) - 1
        val month = calendar.get(Calendar.MONTH) + 1
        val list = MutableList(week, init = { CalendarDayModel() })

        for (i in 1..maxDate) {
            list.add(CalendarDayModel(DateType.NORMAL, month, i))
        }

        binding.tvMonth.text = "${calendar.get(Calendar.YEAR)}년 ${month}월"

        calendarAdapter.initCheck()
        calendarAdapter.submitList(list)
    }
}