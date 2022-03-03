package com.nisith.kotlindemoapp3.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nisith.kotlindemoapp3.Model.Country
import com.nisith.kotlindemoapp3.R

class MyRecyclerViewAdapter(var countryList: ArrayList<Country>, var itemClickListener: OnItemClickListener): RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>() {

    interface OnItemClickListener{
        fun onItemClick(countryName: String)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.single_row_appearence, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.countryNameTextView.text = countryList[position].countryName
    }


    override fun getItemCount(): Int {
        return countryList.size
    }


    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var countryNameTextView: TextView = itemView.findViewById(R.id.country_name_text_view)
        init {
            itemView.setOnClickListener(View.OnClickListener {
                itemClickListener.onItemClick(countryList[absoluteAdapterPosition].countryName)
            })
        }
    }

}