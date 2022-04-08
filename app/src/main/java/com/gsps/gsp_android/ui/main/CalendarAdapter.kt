package com.gsps.gsp_android.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gsps.gsp_android.databinding.ItemDayBinding
import com.gsps.gsp_android.databinding.ItemDayEmptyBinding

class CalendarAdapter(context: Context, private val itemList: MutableList<CalendarDayModel>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        if (viewType == 0) {
            val itemDayBinding =
                ItemDayBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ViewHolder(itemDayBinding)
        }
        else if (viewType == 1) {
            val itemDayEmptyBinding = ItemDayEmptyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return EmptyViewHolder(itemDayEmptyBinding)
        }

    }

    class EmptyViewHolder(itemDayEmptyBinding: ItemDayEmptyBinding) : RecyclerView.ViewHolder() {

    }

    class ViewHolder(itemDayBinding: ItemDayBinding) : RecyclerView.ViewHolder() {

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun getItemViewType(position: Int): Int {
        return when {
            itemList[position].isSelected -> 2
            itemList[position].plan.isEmpty() -> 0
            else -> 1
        }
    }
}