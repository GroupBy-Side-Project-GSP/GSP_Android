package com.gsps.gsp_android.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gsps.gsp_android.R

class SearchResultAdapter : RecyclerView.Adapter<SearchResultAdapter.SearchResultViewHolder>() {

    private var items = mutableListOf<SearchResultModel>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchResultAdapter.SearchResultViewHolder {
        val inflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_search_result, parent, false)
        return SearchResultViewHolder(inflater)
    }

    override fun onBindViewHolder(
        holder: SearchResultAdapter.SearchResultViewHolder,
        position: Int
    ) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun addItems(list: List<SearchResultModel>) {
        this.items.run {
            clear()
            addAll(list)
        }
    }

    class SearchResultViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var itemsearchresulttext = v.findViewById<TextView>(R.id.tvSearchResultContentItem)
        var itemsearchresultname = v.findViewById<TextView>(R.id.tvSearchResultNameItem)
        var itemsearchresultbtn = v.findViewById<Button>(R.id.btnSearchResultheart)
        fun bind(model: SearchResultModel) {
            itemsearchresulttext.text = model.content
            itemsearchresultname.text = model.name
        }
    }
}