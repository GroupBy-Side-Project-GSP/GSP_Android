package com.gsps.gsp_android.ui.main

import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gsps.gsp_android.R
import com.gsps.gsp_android.databinding.ItemDayBinding

class CalendarAdapter :
    ListAdapter<CalendarDayModel, CalendarAdapter.ViewHolder>(CalendarAdapterDiffCallback()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        when {
            item.dayOfMonth == 0 -> {
                holder.ivSelected.visibility = View.GONE
                holder.tvDate.visibility = View.GONE
                holder.ivPlan.visibility = View.GONE
            }
            item.isSelected -> {
                val drawable: GradientDrawable = holder.ivSelected.background as GradientDrawable
                drawable.setColor(R.color.main_lighten.toInt())
                holder.tvDate.setTextColor(R.color.white.toInt())
                holder.ivPlan.visibility = View.GONE
            }
            item.plan.size == 0 -> {
                holder.ivSelected.visibility = View.GONE
                holder.tvDate.setTextColor(R.color.black.toInt())
                holder.ivPlan.visibility = View.GONE
            }
            else -> {
                val drawable: GradientDrawable = holder.ivPlan.background as GradientDrawable
                holder.ivSelected.visibility = View.GONE
                holder.tvDate.setTextColor(R.color.black.toInt())
                drawable.setColor(R.color.main_lighten.toInt())
            }
        }
        holder.bind(item)
    }

    class ViewHolder private constructor(private val itemDayBinding: ItemDayBinding) :
        RecyclerView.ViewHolder(itemDayBinding.root) {
        val ivSelected = itemDayBinding.ivSelected
        val tvDate = itemDayBinding.tvDate
        val ivPlan = itemDayBinding.ivPlan

        fun bind(item: CalendarDayModel) {
            itemDayBinding.calendarDayModel = item
            itemDayBinding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val binding =
                    ItemDayBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

class CalendarAdapterDiffCallback : DiffUtil.ItemCallback<CalendarDayModel>() {
    override fun areItemsTheSame(oldItem: CalendarDayModel, newItem: CalendarDayModel): Boolean {
        return oldItem.dayOfMonth == newItem.dayOfMonth
    }

    override fun areContentsTheSame(oldItem: CalendarDayModel, newItem: CalendarDayModel): Boolean {
        return oldItem == newItem
    }
}