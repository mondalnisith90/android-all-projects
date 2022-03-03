package com.music.example_app;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

public class CreateDialog {
    private Context context;
    public CreateDialog(Context context){
        this.context = context;
    }

    public AlertDialog getDialog(){

        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setMessage("Hi, This is  A Alert Dialog And I Am Nisith Monda. I am an Engneering Student of Haldia Institute of Technology. My Most Fevourite Domain is Software Development")
                .setIcon(R.drawable.ic_alert)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("CALCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setCancelable(false)
                .setTitle("Alert Dialog");
        return builder.create();

    }
}
