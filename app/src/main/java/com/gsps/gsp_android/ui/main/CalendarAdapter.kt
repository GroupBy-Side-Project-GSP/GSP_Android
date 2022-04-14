package com.gsps.gsp_android.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gsps.gsp_android.databinding.ItemDayBinding

class CalendarAdapter :
    ListAdapter<CalendarDayModel, RecyclerView.ViewHolder>(CalendarDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CalendarViewHolder(
            ItemDayBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is CalendarViewHolder) {
            holder.bind(getItem(position))
        }
    }
}

class CalendarViewHolder(private val binding: ItemDayBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: CalendarDayModel) {
        with(binding) {
            rbDay.text = item.dayOfMonth.toString()

            rbDay.setOnClickListener {
                // rbDay 클릭 리스너
                // 1. 배경 색 바뀜, 하단 원 안 보임.
                // 2. 달력 하단에 스케쥴 리스트 생성 됨.
            }
        }
    }
}

class CalendarDiffCallback : DiffUtil.ItemCallback<CalendarDayModel>() {
    override fun areItemsTheSame(oldItem: CalendarDayModel, newItem: CalendarDayModel): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: CalendarDayModel, newItem: CalendarDayModel): Boolean {
        return oldItem == newItem
    }
}