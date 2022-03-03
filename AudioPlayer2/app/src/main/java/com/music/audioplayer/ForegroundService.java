package com.music.audioplayer;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class ForegroundService extends Service {
   // @androidx.annotation.Nullable
    public IBinder iBinder=new MyBinder();
    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }

    public class MyBinder extends Binder{
        public ForegroundService getForgroundServiceObject(){
            return ForegroundService.this;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        return START_NOT_STICKY;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
