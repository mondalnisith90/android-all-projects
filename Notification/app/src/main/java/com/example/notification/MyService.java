package com.example.notification;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;

public class MyService extends Service {

    IBinder binder=new MyBinder();
    int icon_pause=R.drawable.pause_icon;
    int icon_play=R.drawable.icon_play;
    int icon_id;
    String PLAY="PLAY ",PAUSE="PAUSE";


    //@androidx.annotation.Nullable

    NotificationCompat.Builder notification_builder;
   // NotificationManagerCompat notificationManagerCompat;


    public class MyBinder extends Binder
    {
        public MyService getService()
        {
            return MyService.this;
        }
    }
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("CCCC","onBind() is Called");
        counter();
        return binder;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        startForeground(79,showNotification(icon_pause,PAUSE));
        Log.d("CCCC","OnCreate() is Called");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("CCCC","OnStartCommand() is Called");
        //int i=intent.getStringExtra("key");
        int i=intent.getIntExtra("key",0);
        //Log.d("CCCC","KEY="+name);
        if(i==1)
        {
            stopSelf();
        }
        if(icon_id==12)
        {
            startForeground(79,showNotification(icon_play,PLAY));
        }else if(icon_id==13)
        {
            startForeground(79,showNotification(icon_pause,PAUSE));
        }





        return super.onStartCommand(intent, flags, startId);


    }



    public Notification showNotification(int icon,String mode)
    {
        Intent intent=new Intent(getApplicationContext(),Main2Activity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pendingIntent=PendingIntent.getActivity(getApplicationContext(),11,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        Intent intent1=new Intent(getApplicationContext(),MyService.class);
        intent1.putExtra("key",1);
        PendingIntent pendingIntent1=PendingIntent.getService(getApplicationContext(),23,intent1,PendingIntent.FLAG_UPDATE_CURRENT);
        intent1.putExtra("key",1);
        Intent intent2=new Intent(getApplicationContext(),MyService.class);
        PendingIntent pendingIntent2=PendingIntent.getService(getApplicationContext(),33,intent2,PendingIntent.FLAG_UPDATE_CURRENT);

        notification_builder=new NotificationCompat.Builder(getApplicationContext(),"MONDAL")
                .setSmallIcon(R.drawable.icon_audiotrac)
                .setContentTitle("Download Songs")
                .setContentTitle("Downloading")
                .setContentIntent(pendingIntent)
                .addAction(R.drawable.ic_cancel_black_24dp,"",pendingIntent1)
                .addAction(icon,""+mode,pendingIntent2)
        .setPriority(2)


        .setAutoCancel(true);
        if(icon==R.drawable.pause_icon)
        {
            icon_id=12;
        }
        else
        {
            icon_id=13;
        }
        return notification_builder.build();

    }

    public void stopMyService()
    {
        stopSelf();
    }
    public void counter()
    {

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                int i;
                for ( i = 1; i <20 ; i++) {
                    Log.d("CCCC","i="+i);
                    SystemClock.sleep(1000);

                }
            }
        });
        t1.start();
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("CCCC","onDestroy() is Called");
    }
}








































