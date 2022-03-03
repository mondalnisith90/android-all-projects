package com.nisith.kotlindemoapp3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var countButton: Button
    private lateinit var nextActivityButton: Button
    private lateinit var sumActivityButton: Button
    private lateinit var countryActivityButton: Button
    private lateinit var countTextView: TextView
    private var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        count_text_view.text = 0.toString()
        countButton = findViewById(R.id.count_button)
        nextActivityButton = findViewById(R.id.next_activity_button)
        sumActivityButton = findViewById(R.id.sum_activity_button)
        countryActivityButton = findViewById(R.id.country_activity_button)
        countTextView = findViewById(R.id.count_text_view)
        countButton.setOnClickListener(MyClickListener())
        nextActivityButton.setOnClickListener(MyClickListener())
        sumActivityButton.setOnClickListener(MyClickListener())
        countryActivityButton.setOnClickListener(MyClickListener())

    }

    inner class MyClickListener: View.OnClickListener {
        override fun onClick(v: View?) {
            when (v?.id) {
                R.id.count_button -> {
                    count++
                    countTextView.text = count.toString()
                }
                R.id.next_activity_button -> {
                    var myIntent = Intent(applicationContext, MainActivity2::class.java)
                    myIntent.putExtra("name", "Nisith Mondal")
                    myIntent.putExtra("age", 23)
                    startActivity(myIntent)
                }
                R.id.sum_activity_button -> {
                    startActivity(Intent(applicationContext, SumActivity::class.java))
                }
                R.id.country_activity_button -> {
                    startActivity(Intent(applicationContext, CountryListActivity::class.java))
                }
            }

        }


    }

}