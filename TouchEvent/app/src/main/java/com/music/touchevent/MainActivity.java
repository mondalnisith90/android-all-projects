package com.music.touchevent;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout relativeLayout;
    private ImageView imageView;
    private int xDelta,yDelta;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relativeLayout = findViewById(R.id.parent_layout);
        imageView = findViewById(R.id.image_view);

        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        Log.d("abcd","Left Margen= "+layoutParams.leftMargin);
        Log.d("abcd","Top Margen= "+layoutParams.topMargin);


        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                final int x=(int)event.getRawX();
                final int y=(int)event.getRawY();

                Log.d("abcd","Raw X= "+x/ getApplicationContext().getResources().getDisplayMetrics().density);
                Log.d("abcd","Raw Y= "+y/ getApplicationContext().getResources().getDisplayMetrics().density);

//                Log.d("abcd"," X= "+event.getX());
//                Log.d("abcd"," Y= "+event.getY());


//                Log.d("ABCD","ACTION= "+event.getAction());
                switch (event.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        Log.d("ABCD","ACTION_DOWN"+" X="+(int)event.getX()+" Y="+(int)event.getY());
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
                        xDelta=x-layoutParams.leftMargin;
                        yDelta=y-layoutParams.topMargin;
                        break;
                    case MotionEvent.ACTION_UP:
//                        Log.d("ABCD","ACTION_UP"+" X="+(int)event.getX()+" Y="+(int)event.getY());
                        break;
                    case MotionEvent.ACTION_MOVE:
                        RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
//                        lParams.leftMargin=200;
                        lParams.topMargin=y-yDelta;
//                        lParams.rightMargin=50;
//                        lParams.bottomMargin=100;
                        v.setLayoutParams(lParams);
                        lParams.setMarginStart(100);

//                        Log.d("ABCD","ACTION_MOVE"+" X="+(int)event.getX()+" Y="+(int)event.getY());
                        break;


                }
                return true;
            }
        });
    }
}
