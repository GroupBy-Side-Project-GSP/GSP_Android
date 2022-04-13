package com.gsps.gsp_android.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gsps.gsp_android.R

class SearchTextAdapter : RecyclerView.Adapter<SearchTextAdapter.SearchTextViewHolder>() {
    private var items = mutableListOf<SearchTextModel>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchTextViewHolder {
        val inflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_click_search, parent, false)
        return SearchTextViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: SearchTextViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun addItems(list: List<SearchTextModel>) {
        this.items.run {
            clear()
            addAll(list)
        }
    }

    class SearchTextViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var itemsearchtext = v.findViewById<TextView>(R.id.tvSearchedItemText)

        fun bind(model: SearchTextModel) {
            itemsearchtext.text = model.searchtext
        }
    }
}