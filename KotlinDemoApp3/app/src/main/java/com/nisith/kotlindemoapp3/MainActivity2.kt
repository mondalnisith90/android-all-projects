package com.nisith.kotlindemoapp3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var intent: Intent = intent
        var name: String? = intent.getStringExtra("name")
        var age: Int = intent.getIntExtra("age",0)
        text_view.setText("Name is $name and age is $age")
    }
}