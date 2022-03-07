package com.gsps.gsp_android.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.gsps.gsp_android.R
import com.gsps.gsp_android.ui.model.InterestModel

class InterestAdapter (val interestList: ArrayList<InterestModel>) : RecyclerView.Adapter<InterestAdapter.CustomViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.interest_item,parent,false)

        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bind(interestList[position])

        holder.itemView.setOnClickListener {
            itemClickListener.onCheckedChanged(it, position, false)
//            itemClickListener.onClick(it, position)
        }
    }

    // (2) 리스너 인터페이스
    interface OnItemClickListener {
//        fun onClick(v: View, position: Int)
        fun onCheckedChanged( v: View, position: Int, isChecked: Boolean)
    }
    // (3) 외부에서 클릭 시 이벤트 설정
    fun setItemClickListener(onItemClickListener: OnItemClickListener) {
        this.itemClickListener = onItemClickListener
    }
    // (4) setItemClickListener로 설정한 함수 실행
    private lateinit var itemClickListener : OnItemClickListener


    override fun getItemCount(): Int {
        return interestList.size
    }




    class CustomViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!){

        val interest = itemView?.findViewById<TextView>(R.id.TbnItem)

        fun bind(interestmodel: InterestModel){
            interest?.text = interestmodel.interest.toString()
        }
    }
}