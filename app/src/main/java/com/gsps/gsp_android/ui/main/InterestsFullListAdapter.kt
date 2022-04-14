package com.gsps.gsp_android.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gsps.gsp_android.databinding.InterestsFullListItemBinding

class InterestsFullListAdapter(context: Context, private val itemList: MutableList<MemberModel>) :
    RecyclerView.Adapter<InterestsFullListAdapter.InterestsFullListHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): InterestsFullListHolder {
        val binding =
            InterestsFullListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return InterestsFullListHolder(binding)
    }

    override fun onBindViewHolder(
        holder: InterestsFullListHolder,
        position: Int
    ) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class InterestsFullListHolder(var binding: InterestsFullListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MemberModel) {
            binding.model = item
        }
    }
}