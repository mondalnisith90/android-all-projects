package com.example.materialdesign;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    Toolbar toolbar;
    private FragmentManager fragmentManager;

    private FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=(Toolbar)findViewById(R.id.toolbar1);
        frameLayout=(FrameLayout)findViewById(R.id.frame_layout);
        setSupportActionBar(toolbar);
        fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frame_layout,new First_Fregment(),null);
        fragmentTransaction.commit();




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.item1:
                Toast.makeText(getApplicationContext(),"Item 1 is clicked",Toast.LENGTH_SHORT).show();
                break;

            case R.id.item2:
                Toast.makeText(getApplicationContext(),"Item 2 is clicked",Toast.LENGTH_SHORT).show();
                break;

            case R.id.item3:
                Toast.makeText(getApplicationContext(),"Item 3 is clicked",Toast.LENGTH_SHORT).show();
                break;

            case R.id.item4:
                Toast.makeText(getApplicationContext(),"Item 4 is clicked",Toast.LENGTH_SHORT).show();
                break;
            case R.id.item5:
                Toast.makeText(getApplicationContext(),"Item 5 is clicked",Toast.LENGTH_SHORT).show();
                break;

            case R.id.search:
                Toast.makeText(getApplicationContext(),"Share is clicked",Toast.LENGTH_SHORT).show();
                break;

            case R.id.setting:
                Toast.makeText(getApplicationContext(),"Setting is clicked",Toast.LENGTH_SHORT).show();
                break;


            case R.id.sub_item1:
                Toast.makeText(getApplicationContext(),"Sub Item 1 is clicked",Toast.LENGTH_SHORT).show();
                break;
            case R.id.sub_item2:
                Toast.makeText(getApplicationContext(),"Sub Item 2 is clicked",Toast.LENGTH_SHORT).show();
                break;
            case R.id.sub_item3:
                Toast.makeText(getApplicationContext(),"Sub Item 3 is clicked",Toast.LENGTH_SHORT).show();
                break;
            case R.id.sub_item4:
                Toast.makeText(getApplicationContext(),"Sub Item 4 is clicked",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
