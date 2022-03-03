package com.example.listview;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        tv1=(TextView)findViewById(R.id.textview);
        Intent it =getIntent();
        String firstname=it.getStringExtra("FirstName");
        String lastname=it.getStringExtra("LastName");
        tv1.setText("YOUR NAM,E IS "+firstname+" "+lastname);
    }

}
