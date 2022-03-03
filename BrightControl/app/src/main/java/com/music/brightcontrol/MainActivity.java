package com.music.brightcontrol;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView textView,textview1;
    private SeekBar seekBar;
    private Button button,left_button,right_button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("ABCD","Main Activity's onCreate() is Called");
        textView = findViewById(R.id.text_view);
        textview1 = findViewById(R.id.text_view1);
        button = findViewById(R.id.button);
        left_button = findViewById(R.id.l_button);
        right_button = findViewById(R.id.r_button);
        seekBar = findViewById(R.id.seekbar);



        int screen_btrightness = Settings.System.getInt(getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, 0);
//        Toast.makeText(getApplicationContext(),""+screen_btrightness,Toast.LENGTH_LONG).show();
        seekBar.setProgress(screen_btrightness);
        textView.setText("" + screen_btrightness);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Settings.System.putInt(getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, progress);
                textView.setText("" + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int screen_brightness = Settings.System.getInt(getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, 0);
                textview1.setText("" + screen_brightness);
            }
        });

        left_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int screen_brightness = Settings.System.getInt(getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, 0);
                if (screen_brightness > 0) {
                    screen_brightness--;
                    seekBar.setProgress(screen_brightness);
                    textView.setText("" + screen_brightness);
                    Settings.System.putInt(getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, screen_brightness);
                }


            }
        });

        right_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int screen_brightness = Settings.System.getInt(getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, 0);
                if (screen_brightness < 255) {
                    screen_brightness++;
                    seekBar.setProgress(screen_brightness);
                    textView.setText("" + screen_brightness);
                    Settings.System.putInt(getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, screen_brightness);
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("ABCD","Main Activity's onDestroy() is Called");
    }


}
