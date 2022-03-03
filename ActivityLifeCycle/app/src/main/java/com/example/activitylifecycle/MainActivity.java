package com.example.activitylifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("ABC","onCreate() method is Called");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ABC","onStart() method is Called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ABC","onResume() method is Called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("ABC","onRestart() method is Called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ABC","onPause() method is Called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ABC","onStop() method is Called");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ABC","onDestroy() method is Called");
    }
}






















