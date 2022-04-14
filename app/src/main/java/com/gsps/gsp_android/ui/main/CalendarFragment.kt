package com.gsps.gsp_android.ui.main

import androidx.recyclerview.widget.GridLayoutManager
import com.gsps.gsp_android.R
import com.gsps.gsp_android.databinding.FragmentCalendarBinding
import com.gsps.gsp_android.ui.base.BaseFragment

class CalendarFragment : BaseFragment<FragmentCalendarBinding>(R.layout.fragment_calendar) {
    val calendarAdapter: CalendarAdapter by lazy { CalendarAdapter() }
    override fun initView() {
        binding.calendar.apply {
            layoutManager = GridLayoutManager(context, 7, GridLayoutManager.VERTICAL, false)
            adapter = calendarAdapter
        }

        /calendarAdapter.submitList()
    }
}