package com.nisith.nevigationdrawerexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        final ImageView imageView = findViewById(R.id.image_view);
        TextView textView = findViewById(R.id.text_view);
        final Animation animation = AnimationUtils.loadAnimation(this,R.anim.rotation);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.startAnimation(animation);
            }
        });

    }
}
