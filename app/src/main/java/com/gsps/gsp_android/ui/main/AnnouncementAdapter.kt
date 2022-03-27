package com.gsps.gsp_android.ui.main

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.gsps.gsp_android.R

class AnnouncementAdapter : RecyclerView.Adapter<AnnouncementAdapter.AnnouncementHolder>(){

    private var items = mutableListOf<AnnouncementModel>()

//    interface ItemClickListener{
//        fun onItemClick(v: View, position: Int,model: AnnouncementModel)
//    }
//
//    private var listener: ItemClickListener?=null
//
//    fun setOnItemClickListener(listener: ItemClickListener){
//        this.listener=listener
//    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnnouncementAdapter.AnnouncementHolder {
        val inflater= LayoutInflater.from(parent.context).inflate(R.layout.activity_announcement,parent,false)
        return AnnouncementHolder(inflater)
    }

    override fun onBindViewHolder(holder: AnnouncementAdapter.AnnouncementHolder, position: Int) {
        holder.bind(items[position])



//        holder.itemView.setOnClickListener{
//            listener?.onItemClick(it,position,items[position])
//        }

    }

    fun addItems(list: List<AnnouncementModel>){
        this.items.run{
            clear()
            addAll(list)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class AnnouncementHolder(v: View) : RecyclerView.ViewHolder(v) {
        val itemtitle = v.findViewById<TextView>(R.id.tvAnnouncementTitle)
        val itemdate = v.findViewById<TextView>(R.id.tvAnnouncementDate)

        fun bind(model: AnnouncementModel){
            itemtitle.text=model.title
            itemdate.text=model.date
        }
    }
}