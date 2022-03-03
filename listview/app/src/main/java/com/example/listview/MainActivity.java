package com.example.listview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.AdapterView;
import android.view.View.OnClickListener;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1;
    EditText et1,et2;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText) findViewById(R.id.first_number);
        et2=(EditText)findViewById(R.id.second_Number);
        b1=(Button)findViewById(R.id.add);
        result=(TextView)findViewById(R.id.result);
        b1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                int a=0,b=0,sum;
                try {

                    a = Integer.parseInt(et1.getText().toString());
                    try {

                        b = Integer.parseInt(et2.getText().toString());
                        sum=a+b;
                        result.setText("Sum is "+sum);
                    }catch (Exception e)
                    {
                        Toast.makeText(MainActivity.this,"Enter integer number in Second Edit Text",Toast.LENGTH_LONG).show();
                    }

                }catch (Exception e)
                {
                    Toast.makeText(MainActivity.this,"Enter integer number in First Edit Text",Toast.LENGTH_LONG).show();
                }



            }
        });

    }
}

