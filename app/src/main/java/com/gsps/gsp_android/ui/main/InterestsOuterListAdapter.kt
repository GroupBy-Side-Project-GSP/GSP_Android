package com.gsps.gsp_android.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gsps.gsp_android.databinding.InterestsOuterListItemBinding

class InterestsOuterListAdapter(
    val context: Context,
    private val itemOuterList: MutableList<InterestsOuterListModel>
) :
    RecyclerView.Adapter<InterestsOuterListAdapter.InterestsListHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InterestsListHolder {
        val binding =
            InterestsOuterListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return InterestsListHolder(binding)
    }

    override fun onBindViewHolder(holder: InterestsListHolder, position: Int) {
        holder.bind(itemOuterList[position])
    }

    override fun getItemCount(): Int {
        return itemOuterList.size
    }

    inner class InterestsListHolder(var binding: InterestsOuterListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: InterestsOuterListModel) {
            binding.outerModel = item
            binding.innerContainer.adapter = InterestsInnerListAdapter(context, item.innerList)
            binding.innerContainer.layoutManager = LinearLayoutManager(context)
        }
    }
}