package com.example.musictest;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;

import java.io.IOException;

public class MyService extends Service {
   // @androidx.annotation.Nullable
   static MediaPlayer mediaPlayer=null;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        mediaPlayer=new MediaPlayer();
        Log.d("ABC","onCreate() is Called");


    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
      //Log.d("ABC","Service is Stared");
        Log.d("ABC","onStartCommand() is Called");

                 if(mediaPlayer.isPlaying())
                 {
                     mediaPlayer.reset();
                 }
                 Uri uri=Uri.parse("/storage/emulated/0/Samsung/Music/Over");
        try {
            mediaPlayer.setDataSource(getApplicationContext(),uri);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(!mediaPlayer.isPlaying())
                 {
                     mediaPlayer.start();
                 }
                 /*Log.d("ABC","onErroeListener() is Called");
                 mediaPlayer.reset();
                 Uri uri=Uri.parse("/storage/emulated/0/Samsung/Music/Over the Horizon.mp3");
                 try {
                     mediaPlayer.setDataSource(getApplicationContext(),uri);
                     mediaPlayer.prepare();
                     if(!mediaPlayer.isPlaying())
                     {
                         mediaPlayer.start();
                     }
                 } catch (IOException le) {
                     le.printStackTrace();
                 }*/



       //stopSelf();


        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("ABC","onDestroy() is Called");
    }
}
