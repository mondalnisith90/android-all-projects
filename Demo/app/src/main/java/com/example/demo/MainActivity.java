package com.example.demo;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.File;
import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements Serializable {

    private Button button;
    private EditText editText;
    private TextView textView;
    public String name;
    Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button1);
        editText=findViewById(R.id.edit_text1);
        textView=findViewById(R.id.text_view1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name=editText.getText().toString();
//                Log.d("ABCD","Main Activity name "+name);
                Intent intent=new Intent(getApplicationContext(),Main2Activity.class);
                student=new Student();
//                student.setName(name);
                intent.putExtra("data",student);
                startActivity(intent);

                Thread thread=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (true)
                        {
                            if (student!=null)
                            {
                                Log.e("ABCD","NAME "+student.arrayList.size());
                                SystemClock.sleep(1000);
                            }
                        }


                    }
                });
                thread.start();
            }
        });






    }

    @Override
    protected void onStart() {
        super.onStart();
        if (student!=null)
        {
//            textView.setText(student.getName());
//            Log.d("ABCD","Main Activity name value "+student.getName());
        }
    }

    public  void permission()
    {
        Dexter.withActivity(this)
                .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response) {



                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                        token.continuePermissionRequest();

                    }
                }).check();
    }
}
