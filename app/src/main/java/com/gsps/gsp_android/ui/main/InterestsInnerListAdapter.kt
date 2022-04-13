package com.gsps.gsp_android.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gsps.gsp_android.databinding.InterestsInnerListItemBinding

class InterestsInnerListAdapter(
    context: Context,
    private val itemList: MutableList<MemberModel>
) :
    RecyclerView.Adapter<InterestsInnerListAdapter.InterestsMemberHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): InterestsMemberHolder {
        val binding =
            InterestsInnerListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return InterestsMemberHolder(binding)
    }

    override fun onBindViewHolder(
        holder: InterestsMemberHolder,
        position: Int
    ) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class InterestsMemberHolder(var binding: InterestsInnerListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MemberModel) {
            binding.memberModel = item
        }
    }
}