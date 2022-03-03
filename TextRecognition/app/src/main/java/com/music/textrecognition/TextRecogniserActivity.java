package com.music.textrecognition;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class TextRecogniserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_recogniser);

        String name = "Nisith Mondal";
        int code = name.hashCode();
        Log.d("ABCD",""+code);
        code = name.hashCode();
        Log.d("ABCD",""+code);
    }
}
