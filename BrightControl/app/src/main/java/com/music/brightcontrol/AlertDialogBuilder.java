package com.music.brightcontrol;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AlertDialog;

public class AlertDialogBuilder {
    private Context context;
    private StartActivity mainActivity;

    public AlertDialogBuilder(Context context, StartActivity mainActivity) {
        this.context = context;
        this.mainActivity = mainActivity;
    }

    public AlertDialog getDialog(){

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(mainActivity)
                .setTitle("Permission")
                .setMessage("This Application Needs Permission To Control System Brightness")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
                        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        context.startActivity(intent);
                    }
                })
                .setNegativeButton("CALCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mainActivity.finish();
                    }
                })
                .setCancelable(false);

        return dialogBuilder.create();

    }



}
