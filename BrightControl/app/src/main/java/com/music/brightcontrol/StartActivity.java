package com.music.brightcontrol;

import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class StartActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M) {
            boolean can_write = Settings.System.canWrite(getApplicationContext());
            if (!can_write) {

                AlertDialogBuilder alertDialogBuilder = new AlertDialogBuilder(getApplicationContext(), this);
                alertDialogBuilder.getDialog().show();
            }else {
                Intent intent = new Intent(StartActivity.this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }

        }else {
            Intent intent = new Intent(StartActivity.this,MainActivity.class);
            startActivity(intent);
        }

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M) {
            boolean can_write = Settings.System.canWrite(getApplicationContext());
            if (!can_write) {

                AlertDialogBuilder alertDialogBuilder = new AlertDialogBuilder(getApplicationContext(), this);
                alertDialogBuilder.getDialog().show();

            }else {

                Intent intent = new Intent(StartActivity.this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }

        }

    }
}
