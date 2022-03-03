package com.example.process;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;


public class MyService extends Service {
    int i;

    IBinder binder=new MyBinder();
   // @androidx.annotation.Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("TAG","onBind() is Called");

        return binder;
    }
    public class MyBinder extends Binder
    {
        public MyService getService()
        {
            return MyService.this;
        }
    }

    public int getIValue()
    {
        return i;
    }

    @Override
    public void onCreate() {
        Log.d("TAG","onCreate() is Called");


    }

    @Override
    public int onStartCommand(Intent intent, int flags, final int startId) {
        Log.d("TAG","onStartCommand() is Called");
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                for (i = 1; i <50; i++) {
                    Log.d("TAG",""+i);
                    SystemClock.sleep(1000);
                }
                stopSelf();
            }
        });
        t1.start();
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.d("TAG","onDestroy() is Called");
        super.onDestroy();
    }
}
