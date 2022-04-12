package com.gsps.gsp_android.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gsps.gsp_android.databinding.ItemScheduleBinding

class ScheduleAdapter(
    context: Context,
    private val itemList: MutableList<ScheduleModel>
) : RecyclerView.Adapter<ScheduleAdapter.ScheduleHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ScheduleAdapter.ScheduleHolder {
        val binding =
            ItemScheduleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ScheduleHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ScheduleAdapter.ScheduleHolder,
        position: Int
    ) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ScheduleHolder(var binding: ItemScheduleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ScheduleModel) {
            binding.scheduleModel = item
        }
    }
}