package com.gsps.gsp_android.ui.main

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gsps.gsp_android.databinding.InterestsMemberItemBinding


class InterestsMemberAdapter(
    context: Context,
    private val itemList: MutableList<InterestsMemberModel>
) :
    RecyclerView.Adapter<InterestsMemberAdapter.InterestsMemberHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): InterestsMemberAdapter.InterestsMemberHolder {
        Log.d("dmstjsMember", "onCreateViewHolder")
        val binding =
            InterestsMemberItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return InterestsMemberHolder(binding)
    }

    override fun onBindViewHolder(
        holder: InterestsMemberAdapter.InterestsMemberHolder,
        position: Int
    ) {
        Log.d("dmstjsMember", "onBindViewHolder")
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int {
        Log.d("dmstjsMember", itemList.size.toString())
        return itemList.size
    }

    class InterestsMemberHolder(var binding: InterestsMemberItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: InterestsMemberModel) {
            binding.model = item
        }
    }
}
