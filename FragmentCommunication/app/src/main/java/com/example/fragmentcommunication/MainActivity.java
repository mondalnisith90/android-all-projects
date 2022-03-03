package com.example.fragmentcommunication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements OnFragmentCommunication {

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction1,fragmentTransaction2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager=getSupportFragmentManager();
        fragmentTransaction1=fragmentManager.beginTransaction();
        fragmentTransaction2=fragmentManager.beginTransaction();
        fragmentTransaction1.add(R.id.frame_layout1,new fragmentA(),"fragmentA");
        fragmentTransaction2.add(R.id.frame_layout2,new FragmentB(),"fragmentB");
        fragmentTransaction1.commit();
        fragmentTransaction2.commit();
    }

    @Override
    public void onCommunication(String message)
    {
        FragmentB fragmentB= (FragmentB) fragmentManager.findFragmentByTag("fragmentB");
        fragmentB.setMassege(message);

    }
}
