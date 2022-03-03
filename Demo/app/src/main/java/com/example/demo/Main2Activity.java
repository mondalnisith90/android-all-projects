package com.example.demo;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;

public class Main2Activity extends AppCompatActivity {

    private Button button;
    private EditText editText;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button=findViewById(R.id.button2);
        editText=findViewById(R.id.edit_text2);
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        final Student student= (Student) bundle.getSerializable("data");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                student.name=editText.getText().toString();
                Log.d("ABCD","Main2 Activity name value "+student.arrayList.size());
                student.arrayList.add(new File("/90"));
                SystemClock.sleep(4000);
                Log.d("ABCD","Main2 Activity name value "+student.arrayList.size());
                student.arrayList.add(new File("/89"));
                SystemClock.sleep(4000);
                Log.d("ABCD","Main2 Activity name value "+student.arrayList.size());
            }
        });
    }
}
