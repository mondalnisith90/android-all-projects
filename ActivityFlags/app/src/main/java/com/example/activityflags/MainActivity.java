package com.example.activityflags;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.start_activity1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Main2Activity.class);

                startActivity(intent);
            }
        });
        Log.d("ABCD","Main Activity is Created");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ABCD","MAIN ACTIVITY IS DESTROYED");

    }
}
