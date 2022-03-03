package com.music.trainyatra;


import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int timmer = 1,timeLimit =3;

                while (timmer<timeLimit){
                    SystemClock.sleep(1000);
                    timmer = timmer+1;
                }
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
                finish();
            }
        });
        thread.start();






    }






}
