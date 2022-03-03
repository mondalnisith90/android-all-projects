package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> arrayList;
    EditText et;
    TextView tv;
    Button button;
    int match_name=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et=findViewById(R.id.edittext1);
        tv=findViewById(R.id.textview1);
        button=findViewById(R.id.button1);
        arrayList=new ArrayList<>();
        arrayList.add("NISITH");
        arrayList.add("NISA");
        arrayList.add("ASISH");
        arrayList.add("AKASH");
        arrayList.add("TAPAS");
        arrayList.add("ARNAB");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=et.getText().toString().toUpperCase();
                for (String n:arrayList)
                {
                    if (n.contains(name))
                    {
                        match_name=match_name+1;
                        Log.d("ABCD",""+n);
                    }
                }

                tv.setText(""+match_name);


            }
        });






        }
}
