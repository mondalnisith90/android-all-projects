package com.nisith.kotlindemoapp2.AlertDialog

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDialogFragment
import com.nisith.kotlindemoapp2.R

class MyAlertDialog(var activity: AppCompatActivity) : AppCompatDialogFragment() {


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(activity)
            .setTitle("Title")
            .setMessage("This is Alert Dialog")
            .setIcon(R.drawable.ic_clock_icon)
            .setPositiveButton("Accept", DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(activity, "Accept", Toast.LENGTH_SHORT).show()
                Toast.makeText(activity, "Hello", Toast.LENGTH_SHORT).show()
            })
            .setNegativeButton("Decline") { dialog, which ->
                Toast.makeText(activity, "Decline", Toast.LENGTH_SHORT).show()
            }


        return dialogBuilder.create()
    }



}