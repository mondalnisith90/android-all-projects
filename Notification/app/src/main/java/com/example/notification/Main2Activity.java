package com.example.notification;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {
    private Button button1,button2;
    ServiceConnection connection;
    MyService.MyBinder myBinder;
    MyService myService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //button1=(Button)findViewById(R.id.buttton1025);
        //button2=(Button)findViewById(R.id.buttton1024);

        connection=new ServiceConnection(){
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                myBinder=(MyService.MyBinder) service;
                myService=myBinder.getService();

            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };


       Intent intent1=new Intent(getApplicationContext(),MyService.class);
        //Intent intent=new Intent(getApplicationContext(),MyService.class);
       bindService(intent1,connection,BIND_AUTO_CREATE);


    }
}
