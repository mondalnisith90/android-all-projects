package com.nisith.kotlindemoapp3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.Exception

class SumActivity : AppCompatActivity() {

    private lateinit var firstNumberEditText: EditText
    private lateinit var secondNumberEditText: EditText
    private lateinit var sumButton: Button
    private lateinit var resultTextView: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sum)
        firstNumberEditText = findViewById(R.id.first_number_edit_text)
        secondNumberEditText = findViewById(R.id.second_number_edit_text)
        sumButton = findViewById(R.id.sum_button)
        resultTextView = findViewById(R.id.result_text_view)
        sumButton.setOnClickListener(View.OnClickListener {
            val firstNumber: String = firstNumberEditText.text.toString()
            val secondNumber: String = secondNumberEditText.text.toString()
            if (! TextUtils.isEmpty(firstNumber) && ! TextUtils.isEmpty(secondNumber)){
                try {
                    val result: Int = firstNumber.toInt() + secondNumber.toInt()
                    resultTextView.text = "Sum is $result"
                }catch (e: Exception){
                    Toast.makeText(applicationContext, "Enter only Integer Number", Toast.LENGTH_SHORT).show()
                }

            }else{
                Toast.makeText(applicationContext, "Enter Numbers", Toast.LENGTH_SHORT).show()
            }
        })
    }
}