package com.nisith.texttospeechexample;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private TextToSpeech textToSpeech;
    private TextSpeaker textSpeaker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
//        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
//            @Override
//            public void onInit(int status) {
//                if (status == TextToSpeech.SUCCESS){
//                    int state = textToSpeech.setLanguage(Locale.ENGLISH);
//
//                }else {
//                    Log.d("ABCDS","ERROR");
//                }
//            }
//        });
//
        textSpeaker = new TextSpeaker(getApplicationContext());
        final TextView textView = findViewById(R.id.text_view);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textSpeaker.speak("HELLO WORLD NISITH");
            }
        });





    }
}
