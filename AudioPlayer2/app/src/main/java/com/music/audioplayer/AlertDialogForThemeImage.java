package com.music.audioplayer;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.widget.Toast;

@SuppressLint("ValidFragment")
public class AlertDialogForThemeImage extends AppCompatDialogFragment {

    private int imageDrawableValue;
    private  ApplicationThemeActivity applicationThemeActivity;

    public AlertDialogForThemeImage(ApplicationThemeActivity applicationThemeActivity,int imageDrawableValue)
    {
        this.applicationThemeActivity=applicationThemeActivity;
        this.imageDrawableValue=imageDrawableValue;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder dialogBuilder=new AlertDialog.Builder(getContext());
        dialogBuilder.setTitle("Set For BackGround Theme")
                .setMessage("This Theme Will Display in Music Control Activity")
        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                SharedPreferenceForSavingTheme sharedPreferenceForSavingTheme=new SharedPreferenceForSavingTheme(applicationThemeActivity);
                sharedPreferenceForSavingTheme.saveThemeSource("application_theme");
                sharedPreferenceForSavingTheme.saveThemeImageDrawableValue(imageDrawableValue);
                Toast.makeText(applicationThemeActivity, "Theme is Set", Toast.LENGTH_SHORT).show();
            }
        })

        .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        return dialogBuilder.create();
    }
}
