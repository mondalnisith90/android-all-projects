package com.music.trainyatra;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;

public class AlertDialogForGeneralPurpase extends AppCompatDialogFragment {

    private String dialog_title,dialog_message;

    public AlertDialogForGeneralPurpase(){}

    @SuppressLint("ValidFragment")
    public AlertDialogForGeneralPurpase(String dialog_title, String dialog_message){
        this.dialog_title = dialog_title;
        this.dialog_message = dialog_message;

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getContext())
                .setTitle(dialog_title)
                .setMessage(dialog_message)
                .setNegativeButton("CALCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        return dialogBuilder.create();
    }
}
