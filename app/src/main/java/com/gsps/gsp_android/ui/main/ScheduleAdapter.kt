package com.gsps.gsp_android.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gsps.gsp_android.databinding.ItemScheduleBinding
import java.time.format.DateTimeFormatter

class ScheduleAdapter :
    ListAdapter<ScheduleModel, RecyclerView.ViewHolder>(ScheduleDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        val binding =
            ItemScheduleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ScheduleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ScheduleViewHolder) {
            holder.bind(getItem(position))
        }
    }
}

class ScheduleViewHolder(private val binding: ItemScheduleBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: ScheduleModel) {
        with(binding) {
            tvScheduleTitle.text = item.title
            tvLocation.text = item.place
            tvUserName.text = item.companyName
            tvScheduleTime.text = item.start.format(DateTimeFormatter.ofPattern("a H:mm"))

            clItem.setOnClickListener {
                
            }
        }
    }
}

class ScheduleDiffCallback : DiffUtil.ItemCallback<ScheduleModel>() {
    override fun areItemsTheSame(oldItem: ScheduleModel, newItem: ScheduleModel): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: ScheduleModel, newItem: ScheduleModel): Boolean {
        return oldItem == newItem
    }
}