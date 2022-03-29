package com.gsps.gsp_android.ui.main

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gsps.gsp_android.R

class MyOfficeAdapter : RecyclerView.Adapter<MyOfficeAdapter.MyOfficeViewHolder>(){

    private var items = mutableListOf<MyOfficeModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyOfficeAdapter.MyOfficeViewHolder {
        val inflater= LayoutInflater.from(parent.context).inflate(R.layout.my_office_item,parent,false)
        return MyOfficeViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: MyOfficeAdapter.MyOfficeViewHolder, position: Int) {

        holder.bind(items[position])

        holder.itemheart.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                if(items.isNotEmpty()){
                    items.removeAt(holder.adapterPosition)
                    notifyDataSetChanged()
                }
            }
        })
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun addItems(list: List<MyOfficeModel>){
        this.items.run{
            clear()
            addAll(list)
        }
    }

    inner class MyOfficeViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        var itemname = v.findViewById<TextView>(R.id.tvRvItemMyOfficeName)
        var itemcategory = v.findViewById<TextView>(R.id.tvRvItemMyOfficeCate)
        var itemheart = v.findViewById<Button>(R.id.btnMyOfficeFavorite)

        fun bind(model: MyOfficeModel){
            itemname.text=model.officename
            itemcategory.text=model.category
        }
    }
}
