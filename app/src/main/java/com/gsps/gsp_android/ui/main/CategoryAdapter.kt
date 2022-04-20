package com.gsps.gsp_android.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gsps.gsp_android.databinding.ItemCategoryBinding

class CategoryAdapter(
    val context: Context,
    private val itemList: MutableList<CategoryModel>,
    private val mFinishCallback: SetFinish,
    private val mResultCallback: SetResult
) : RecyclerView.Adapter<CategoryAdapter.CategoryHolder>() {
    private var isNewRadioButtonChecked: Boolean = false
    private var lastCheckedPosition = -1
    private var isSomethingChecked = false

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryHolder {
        val binding =
            ItemCategoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return CategoryHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        val categoryModel = itemList[position]

        if (isNewRadioButtonChecked) {
            holder.binding.rbCategory.isChecked = categoryModel.getChecked()
        } else if (holder.adapterPosition == 0) {
            lastCheckedPosition = 0;
        }

        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class CategoryHolder(var binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.rbCategory.setOnClickListener {
                if (lastCheckedPosition == adapterPosition && itemList[adapterPosition].getChecked()) {
                    isNewRadioButtonChecked = false
                    isSomethingChecked = false
                    itemList[adapterPosition].setChecked(false)
                    notifyDataSetChanged()
                } else {
                    isNewRadioButtonChecked = true
                    isSomethingChecked = true
                    itemList[lastCheckedPosition].setChecked(false)
                    itemList[adapterPosition].setChecked(true)
                    lastCheckedPosition = adapterPosition
                    notifyDataSetChanged()
                }

                mFinishCallback.setFinish(isSomethingChecked)
                if (isSomethingChecked) {
                    mResultCallback.setResult(itemList[lastCheckedPosition].getCategory())
                }
            }
        }

        fun bind(item: CategoryModel) {
            binding.rbCategory.text = item.getCategory()
            binding.rbCategory.isChecked = item.getChecked()
        }
    }
}