package com.music.trainyatra;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;

public class AlertDialogForInternateConnectionFaild extends AppCompatDialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder dialogBuilder  = new AlertDialog.Builder(getContext())
                .setCancelable(true)
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setTitle("You are Offline")
                .setMessage("Please Check Your Internet Connection")
                .setIcon(R.drawable.ic_signal_cellular_off_black_24dp);


        return dialogBuilder.create();
    }
}
