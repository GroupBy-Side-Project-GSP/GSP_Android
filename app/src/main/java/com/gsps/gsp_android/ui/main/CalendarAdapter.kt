package com.gsps.gsp_android.ui.main

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CalendarAdapter(context: Context, private val itemList: MutableList<CalendarDayModel>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

}