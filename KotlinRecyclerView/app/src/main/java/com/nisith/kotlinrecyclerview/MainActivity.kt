package com.nisith.kotlinrecyclerview

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.adapter = MyRecyclerViewAdapter(getDataModelList(100))
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
    }

    private fun getDataModelList(size: Int): List<DataModel>{
        val dataModelList = ArrayList<DataModel>()
        for (i in 1 until size){
            val imageUri: Int = R.drawable.ic_image2
            dataModelList.add(DataModel(imageUri, "Heading $i", "Subheading $i"))
        }
        return dataModelList
    }
}