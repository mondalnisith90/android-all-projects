package com.example.process;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView tv2;
    Button bound,counter;
    ServiceConnection connection;
    MyService.MyBinder binder;
    MyService myService;
    int check=1;
    int check_connection=0;
    Thread t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv2=(TextView)findViewById(R.id.tv2);
        bound=(Button)findViewById(R.id.bound_service);
        counter=(Button)findViewById(R.id.counter);
        bound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



        connection=new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                binder= (MyService.MyBinder) service;
                myService=binder.getService();
                Log.d("TAG","Main2Activity onServiceConnection() is Called");
                check_connection=1;
                //Log.d("TAG","i value is "+myService.getIValue());
                t1.start();
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };

        Intent intent=new Intent(Main2Activity.this,MyService.class);
        bindService(intent,connection, Context.BIND_AUTO_CREATE);


        t1=new Thread(new Runnable() {
           @Override
           public void run() {
               int i=myService.getIValue();
               while (i<50)
               {
                   i=myService.getIValue();
                   final int finalI = i;
                   runOnUiThread(new Runnable() {
                       @Override
                       public void run() {
                           tv2.setText(" "+ finalI);
                       }
                   });
                   SystemClock.sleep(1000);
                  if (check==0)
                  {
                      break;
                  }
               }
           }
       });









    }



    @Override
    protected void onStop() {
        super.onStop();
        check=0;
        if(check_connection==1)
        {
            unbindService(connection);
        }
    }
}







