package com.music.touchevent;

import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private ImageView imageView1,imageView2,imageView3,imageView4,imageView5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        imageView1 = findViewById(R.id.image_view1);
        imageView2 = findViewById(R.id.image_view2);
        imageView3 = findViewById(R.id.image_view3);
        imageView4 = findViewById(R.id.image_view4);
        imageView5 = findViewById(R.id.image_view5);


        Display display = getWindowManager().getDefaultDisplay();
        final Point point = new Point();
        display.getSize(point);
        int width = point.x;
        final int height = point.y;
        Log.d("ABCD","Display Width="+width+"  Display Height="+height);
        final RelativeLayout.LayoutParams layoutParams1 = (RelativeLayout.LayoutParams) imageView1.getLayoutParams();
        final RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) imageView2.getLayoutParams();
        final RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) imageView3.getLayoutParams();
        final RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) imageView4.getLayoutParams();
        final RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) imageView5.getLayoutParams();
        layoutParams1.leftMargin =  width/6-30;
        layoutParams2.leftMargin = width/6*2-30;
        layoutParams3.leftMargin = width/6*3-30;
        layoutParams4.leftMargin = width/6*4-30;
        layoutParams5.leftMargin = width/6*5-30;
        layoutParams1.topMargin = 0;
        layoutParams3.topMargin = 0;
        layoutParams5.topMargin = 0;
        Drawable drawable = getDrawable(R.drawable.ic_android_black_24dp);


        Log.d("ABCD","Image Height="+drawable.getIntrinsicHeight());

        Thread thread =new Thread(new Runnable() {
            @Override
            public void run() {
                int i=1,j=1;
                while (true){
                    if (layoutParams1.topMargin<height){
                        layoutParams1.topMargin=i;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                imageView1.setLayoutParams(layoutParams1);
                            }
                        });
                        i++;
                    }else {
                        i=-190;
                        layoutParams1.topMargin = -190;
                        SystemClock.sleep(1000);
                    }

                    if (layoutParams4.bottomMargin<height){
                        layoutParams4.bottomMargin=j;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                imageView4.setLayoutParams(layoutParams4);
                            }
                        });
                        j++;
                    }else {
                        j=-170;
                        layoutParams4.bottomMargin = -170;
                        SystemClock.sleep(1000);
                    }

                    SystemClock.sleep(10);
                }


                }
        });
        thread.start();

    }
}
