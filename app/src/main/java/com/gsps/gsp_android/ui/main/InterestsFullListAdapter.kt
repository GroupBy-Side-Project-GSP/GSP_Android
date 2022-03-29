package com.gsps.gsp_android.ui.main

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gsps.gsp_android.databinding.InterestsFullListItemBinding

class InterestsFullListAdapter(
    context: Context,
    private val itemList: MutableList<InterestsMemberModel>
) : RecyclerView.Adapter<InterestsFullListAdapter.InterestsFullListHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): InterestsFullListAdapter.InterestsFullListHolder {
        Log.d("dmstjsFullList", "onCreateViewHolder")
        val binding =
            InterestsFullListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return InterestsFullListHolder(binding)
    }

    override fun onBindViewHolder(
        holder: InterestsFullListAdapter.InterestsFullListHolder,
        position: Int
    ) {
        Log.d("dmstjsFullList", "onBindViewHolder")
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int {
        Log.d("dmstjsFullList", itemList.size.toString())
        return itemList.size
    }

    inner class InterestsFullListHolder(var binding: InterestsFullListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: InterestsMemberModel) {
            binding.model = item
        }
    }
}
