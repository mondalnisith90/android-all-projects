package com.example.simplelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String name[]={"SAMIR","AKASH","AMIT","ARNAB","ASHOKE","AMITAVA","TAPAS","NISITH","ASISH","SAMARESH","RAMESH","SAMIR","AKASH","AMIT","ARNAB","ASHOKE","AMITAVA","TAPAS","NISITH","ASISH","SAMARESH","RAMESH"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.list_view);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,R.layout.single_row_listview,R.id.text_view,name);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "You are Clicking on "+name[position], Toast.LENGTH_SHORT).show();
            }
        });

    }
}
