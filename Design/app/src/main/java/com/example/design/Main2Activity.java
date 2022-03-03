package com.example.design;

import android.graphics.Color;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {

    private ImageView imageView;
    private boolean stopThread=false;
    private int i=0;
    private int[] images={R.drawable.ic_favorite0,R.drawable.ic_favorite1,R.drawable.ic_favorite2,R.drawable.ic_favorite3,
            R.drawable.ic_favorite4,R.drawable.ic_favorite5,R.drawable.ic_favorite6,R.drawable.ic_favorite7,
            R.drawable.ic_favorite8,R.drawable.ic_favorite9,R.drawable.ic_favorite10,R.drawable.ic_favorite11,
            R.drawable.ic_favorite12,R.drawable.ic_favorite13,};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        imageView=findViewById(R.id.image_view);


        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                while (true)
                {

                    if(stopThread)
                    {
                        break;
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            imageView.setBackgroundResource(images[i]);
                        }
                    });
                    SystemClock.sleep(1000);
                    if (i==13)
                    {
                        i=0;
                    }
                    else
                    {
                        i++;
                    }
                }
            }
        });
        thread.start();

    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("ABCD","onResume() is called");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopThread=true;
    }
}
