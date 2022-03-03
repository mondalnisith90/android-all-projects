package com.nisith.kotlindemoapp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.nisith.kotlindemoapp2.AlertDialog.MyAlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var alertButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        alertButton = findViewById(R.id.button)
        alertButton.setOnClickListener {
            Toast.makeText(this, "Button is Clicked",Toast.LENGTH_SHORT).show()
        }



    }


    fun buttonClick(view: View){
        val button = view as Button
        if (alertButton.isEnabled) {
            alertButton.isEnabled = false
            button.text = "Enable Above Button"
        }else{
            alertButton.isEnabled = true
            button.text = "Disable Above Button"
        }

    }






}