package com.example.musicappdesign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private HashMap hashMap,hashMap1;
    private Map map,map1;
//    String []name={"NISITH","TAPAS","ASISH","ARNAB","SAMARESH","RAMESH","BIVASH"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        map=new HashMap();
        map1=map;
        map.put("key1","NISITH");
        map.put("key1","NISITH");
        map.put("key3","NISITH");

        Log.d("ABCD",""+map.get("key1"));
        Log.d("ABCD",""+map.get("key2"));
        Log.d("ABCD",""+map.get("key3"));




    }
}

