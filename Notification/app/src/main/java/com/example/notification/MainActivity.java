package com.example.notification;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button s_service,st_service;
    MyService myService;
   // int i=1;
    String channelId="personal_notification";
    NotificationManagerCompat notificationManagerCompat;
    NotificationCompat.Builder notification_builder;
    ServiceConnection connection;
    MyService.MyBinder myBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        s_service=(Button)findViewById(R.id.start1_service);
       // st_service=(Button)findViewById(R.id.stop1_service);




        s_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1=new Intent(getApplicationContext(),MyService.class);
                Intent intent2=new Intent(getApplicationContext(),Main2Activity.class);
                startService(intent1);
                startActivity(intent2);

            }
        });


       /* st_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myService.stopMyService();
            }
        });*/





        }

    @Override
    protected void onStop() {
        super.onStop();
    }
}




























