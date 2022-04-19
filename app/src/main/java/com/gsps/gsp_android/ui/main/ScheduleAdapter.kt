package com.gsps.gsp_android.ui.main

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gsps.gsp_android.R
import com.gsps.gsp_android.databinding.ItemScheduleBinding
import java.time.format.DateTimeFormatter

class ScheduleAdapter(private val context: Context) :
    ListAdapter<ScheduleModel, RecyclerView.ViewHolder>(ScheduleDiffCallback()) {
    lateinit var holder: ScheduleViewHolder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        val binding =
            ItemScheduleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ScheduleViewHolder(context, binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ScheduleViewHolder) {
            holder.setScheduleView(position)
            holder.bind(getItem(position))
            this.holder = holder
        }
    }
}

class ScheduleViewHolder(private val context: Context, private val binding: ItemScheduleBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: ScheduleModel) {
        with(binding) {
            tvScheduleTitle.text = item.title
            tvLocation.text = item.place
            tvUserName.text = item.companyName
            tvScheduleTime.text = item.start.format(DateTimeFormatter.ofPattern("a H:mm"))

            clItem.setOnClickListener {
                val dialog = ScheduleDialog(context)
                dialog.start(context, item)
            }
        }
    }

    fun setScheduleView(position: Int) {
        val drawable: GradientDrawable =
            ContextCompat.getDrawable(context, R.drawable.circle) as GradientDrawable

        when (position % 3) {
            0 -> {
                drawable.setColor(context.getColor(R.color.main_lighten))
                binding.icCircle.setImageDrawable(drawable)
            }
            1 -> {
                drawable.setColor(context.getColor(R.color.main))
                binding.icCircle.setImageDrawable(drawable)
            }
            2 -> {
                drawable.setColor(context.getColor(R.color.main_darken))
                binding.icCircle.setImageDrawable(drawable)
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

