package com.example.exampleonclick;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    private String []name={"NISITH","ASISH","MANISH","ARNAB","TAPAS","BIVASH","BIKASH","SAMARESH",
            "RAMESH","BIPLAB","YAUSE","ANIMESH","SOURAV","NISITH","ASISH","MANISH","ARNAB","TAPAS","BIVASH","SANTUNU"};
    private String []number={"9091473871","64533421","8768017423","8373035254","8001888402",
            "9091473871","64533421","8768017423","8373035254","8001888402",
            "9091473871","64533421","8768017423","8373035254","8001888402",
            "9091473871","64533421","8768017423","8373035254","8001888402"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycler_view);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);



    }

}
