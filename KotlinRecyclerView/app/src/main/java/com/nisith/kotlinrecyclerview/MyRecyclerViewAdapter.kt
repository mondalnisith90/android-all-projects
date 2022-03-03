package com.nisith.kotlinrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.single_row_appearence.view.*

class MyRecyclerViewAdapter(private val listDataSet: List<DataModel>): RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.single_row_appearence, parent, false);
        return MyViewHolder(view)
    }



    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val dataModel: DataModel = listDataSet[position]
        holder.imageView.setBackgroundResource(dataModel.imageUri)
        holder.heading.text = dataModel.heading
        holder.subHeading.text = dataModel.subHeading
    }

    override fun getItemCount(): Int {
        return listDataSet.size
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
       val imageView: ImageView = itemView.image_view
        val heading: TextView = itemView.heading
        val subHeading: TextView = itemView.sub_heading
    }

}










