package com.nisith.texttospeechexample;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.util.Log;

import java.util.Locale;

public class TextSpeaker {

    private TextToSpeech textToSpeech;
    public TextSpeaker(Context mainActivity){
        textToSpeech = new TextToSpeech(mainActivity, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS){
                    int state = textToSpeech.setLanguage(Locale.ENGLISH);

                }else {
                    Log.d("ABCDS","ERROR");
                }
            }
        });
    }

    public void speak(String text){
        textToSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null,null);
    }

    public void closeTextSpeaker(){
        textToSpeech.stop();
        textToSpeech.shutdown();
    }

}
