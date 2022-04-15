package com.gsps.gsp_android.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gsps.gsp_android.databinding.ItemDayBinding

class CalendarAdapter :
    ListAdapter<CalendarDayModel, RecyclerView.ViewHolder>(CalendarDiffCallback()) {
    var lastCheckedPosition = -1


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

    fun initCheck() {
        lastCheckedPosition = -1
    }

    inner class CalendarViewHolder(private val binding: ItemDayBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CalendarDayModel) {
            binding.rbDay.text = item.dayOfMonth.toString()

            setVisibility(binding, item)

            binding.rbDay.setOnClickListener {
                if (lastCheckedPosition == adapterPosition && item.isChecked) {
                    lastCheckedPosition = -1
                    item.isChecked = false
                } else {
                    item.isChecked = true
                    if (lastCheckedPosition != -1) {
                        getItem(lastCheckedPosition).isChecked = false
                        setVisibility(binding, getItem(lastCheckedPosition))
                        notifyItemChanged(lastCheckedPosition)
                    }
                    lastCheckedPosition = adapterPosition
                }
                setVisibility(binding, item)

                if (item.dateType == DateType.SELECTED) {
                    scheduleAdapter.submitList(item.plan)
                } else {
                    scheduleAdapter.submitList(null)
                }
            }
        }

        private fun setDateType(item: CalendarDayModel) {
            if (item.plan.isEmpty()) item.dateType = DateType.NORMAL
            else item.dateType = DateType.PLANNED

            if (item.isChecked) item.dateType = DateType.SELECTED

            if (item.month == 0) item.dateType = DateType.EMPTY
        }

        private fun setVisibility(binding: ItemDayBinding, item: CalendarDayModel) {
            setDateType(item)

            when (item.dateType) {
                DateType.EMPTY -> {
                    binding.rbDay.visibility = View.INVISIBLE
                    binding.ivPlan.visibility = View.INVISIBLE
                }
                DateType.NORMAL -> {
                    binding.rbDay.isChecked = false
                    binding.rbDay.visibility = View.VISIBLE
                    binding.ivPlan.visibility = View.INVISIBLE
                }
                DateType.PLANNED -> {
                    binding.rbDay.isChecked = false
                    binding.rbDay.visibility = View.VISIBLE
                    binding.ivPlan.visibility = View.VISIBLE
                }
                DateType.SELECTED -> {
                    binding.rbDay.isChecked = true
                    binding.rbDay.visibility = View.VISIBLE
                    binding.ivPlan.visibility = View.INVISIBLE
                }
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