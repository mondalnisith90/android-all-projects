package com.example.process;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button start_service,start_activity;
    TextView counter;
    ServiceConnection connection;
    MyService.MyBinder binder;
    MyService myService;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start_service=(Button)findViewById(R.id.start_service);
        start_activity=(Button)findViewById(R.id.start_activity);
        counter=(TextView)findViewById(R.id.counter);
        start_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MyService.class);
                startService(intent);
            }
        });
        start_activity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
               Intent intent=new Intent(MainActivity.this,Main2Activity.class);
               startActivity(intent);
            }
        });



    }


}












