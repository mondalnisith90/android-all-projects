package com.music.designapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    private String numbers[]={"Custom","Normal","Classical","Dance","Flat","Flok","Heavy Metal","Jazz","Pop","Rock"};
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        textView=findViewById(R.id.text_view3);


        Spinner spinner=findViewById(R.id.spinner1);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this, R.layout.spinner_layout,R.id.spinner_text_view, numbers) ;
//        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(Main3Activity.this, "onItemSelected() is Called", Toast.LENGTH_SHORT).show();
                TextView textView1=view.findViewById(R.id.spinner_text_view);

                textView.setText(textView1.getText());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(Main3Activity.this, "onNothingSelected() is Called", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
