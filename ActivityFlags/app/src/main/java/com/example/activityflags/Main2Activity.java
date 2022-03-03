package com.example.activityflags;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {
    private Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b2=(Button)findViewById(R.id.start_activity2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Main3Activity.class);
                startActivity(intent);
            }
        });
        Log.d("ABCD","Main 2 Activity is Created");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ABCD","MAIN 2 ACTIVITY IS DESTROYED");

    }
}
