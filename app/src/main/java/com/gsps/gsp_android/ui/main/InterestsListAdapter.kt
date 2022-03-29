package com.gsps.gsp_android.ui.main

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gsps.gsp_android.databinding.InterestsListItemBinding

class InterestsListAdapter(
    val context: Context,
    private val itemList: MutableList<InterestsListModel>
) :
    RecyclerView.Adapter<InterestsListAdapter.InterestsListHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InterestsListHolder {
        Log.d("dmstjsList", "onCreateViewHolder")
        val binding =
            InterestsListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return InterestsListHolder(binding)

    }

    override fun onBindViewHolder(holder: InterestsListHolder, position: Int) {
        Log.d("dmstjsList", "onBindViewHolder")
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int {
        Log.d("dmstjsList", itemList.size.toString())
        return itemList.size
    }

    inner class InterestsListHolder(var binding: InterestsListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: InterestsListModel) {
            Log.d("dmstjsList", "bind")
            binding.model = item
            binding.container.adapter = InterestsMemberAdapter(context, item.innerList)
            binding.container.layoutManager = LinearLayoutManager(context)
        }

    }
}