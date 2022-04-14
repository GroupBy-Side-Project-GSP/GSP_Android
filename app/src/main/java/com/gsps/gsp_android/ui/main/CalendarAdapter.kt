package com.gsps.gsp_android.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.gsps.gsp_android.databinding.ItemDayBinding

class CalendarAdapter(context: Context, private val itemList: MutableList<CalendarDayModel>) :
    RecyclerView.Adapter<CalendarAdapter.CalendarDayHolder>() {
    private var isNewRadioButtonChecked: Boolean = false
    private var lastCheckedPosition = -1
    private var isSomethingChecked = false

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CalendarDayHolder {
        val binding = ItemDayBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CalendarDayHolder(binding)
    }

    override fun onBindViewHolder(holder: CalendarDayHolder, position: Int) {
        if (isNewRadioButtonChecked) {
            holder.binding.rbDay.isChecked = itemList[position].getChecked()
        } else if (holder.adapterPosition == 0) {
            lastCheckedPosition = 0;
        }

        holder.bind(itemList[position])
    }

    inner class CalendarDayHolder(val binding: ItemDayBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.rbDay.setOnClickListener {
                if (lastCheckedPosition == adapterPosition && itemList[adapterPosition].getChecked()) {
                    binding.rbDay.visibility = View.VISIBLE
                    binding.ivPlan.visibility = View.VISIBLE
                    isNewRadioButtonChecked = false
                    isSomethingChecked = false
                    itemList[adapterPosition].setChecked(false)
                    notifyDataSetChanged()
                } else {
                    binding.rbDay.visibility = View.VISIBLE
                    binding.ivPlan.visibility = View.INVISIBLE
                    isNewRadioButtonChecked = true
                    isSomethingChecked = true
                    itemList[lastCheckedPosition].setChecked(false)
                    itemList[adapterPosition].setChecked(true)
                    lastCheckedPosition = adapterPosition
                    notifyDataSetChanged()
                }
            }
        }

        fun bind(item: CalendarDayModel) {
            when {
                item.getDayOfMonth() == 0 -> {
                    binding.rbDay.visibility = View.INVISIBLE
                    binding.ivPlan.visibility = View.INVISIBLE
                }
                item.getPlan().size == 0 -> {
                    binding.rbDay.visibility = View.VISIBLE
                    binding.ivPlan.visibility = View.INVISIBLE
                }
            }

            binding.calendarDayModel = item
            binding.rbDay.text = item.getDayOfMonth().toString()
            binding.executePendingBindings()
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}

class CalendarAdapterDiffCallback : DiffUtil.ItemCallback<CalendarDayModel>() {
    override fun areItemsTheSame(
        oldItem: CalendarDayModel,
        newItem: CalendarDayModel
    ): Boolean {
        return oldItem.getDayOfMonth() == newItem.getDayOfMonth()
    }

    override fun areContentsTheSame(
        oldItem: CalendarDayModel,
        newItem: CalendarDayModel
    ): Boolean {
        return oldItem == newItem
    }
}