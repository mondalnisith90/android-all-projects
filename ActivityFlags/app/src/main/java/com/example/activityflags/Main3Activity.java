package com.example.activityflags;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Main3Activity extends AppCompatActivity {
    private Button b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        b3=(Button)findViewById(R.id.start_activity3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Main4Activity.class);
                startActivity(intent);
            }
        });
        Log.d("ABCD","Main 3 Activity is Created");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ABCD","MAIN 3 ACTIVITY IS DESTROYED");

    }
}
