package com.gsps.gsp_android.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gsps.gsp_android.R

class SearchRecentRecordAdapter : RecyclerView.Adapter<SearchRecentRecordAdapter.SearchRecentRecordViewHolder>(){

    private var items = mutableListOf<SearchRecentRecordModel>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchRecentRecordAdapter.SearchRecentRecordViewHolder {
        val inflater= LayoutInflater.from(parent.context).inflate(R.layout.fragment_click_search,parent,false)
        return SearchRecentRecordAdapter.SearchRecentRecordViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: SearchRecentRecordAdapter.SearchRecentRecordViewHolder, position: Int) {
        holder.bind(items[position])

    }

    override fun getItemCount(): Int {
        return items.size
    }
    fun addItems(list: List<SearchRecentRecordModel>){
        this.items.run{
            clear()
            addAll(list)
        }
    }

    class SearchRecentRecordViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var itemsearchtext = v.findViewById<TextView>(R.id.tvClickRecentRecordItem)
        var itemrecentdelete = v.findViewById<Button>(R.id.btnClickRecentRecordDeleteItem)

        fun bind(model: SearchRecentRecordModel){
            itemsearchtext.text=model.recentrecord
        }
    }
}