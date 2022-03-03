package com.example.fregments;

import android.app.ActionBar;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {


    private ViewPager viewPager;
    private Button button;
    private int counter=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=(ViewPager)findViewById(R.id.view_pager);
        button=(Button)findViewById(R.id.change_fragment);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(counter);
                if(counter==2)
                {
                    counter=0;
                }
                else {
                    counter=counter+1;
                }

            }
        });


        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(),this));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
//                Log.d("ABCD","onPageScrolled() is Called");
            }

            @Override
            public void onPageSelected(int i) {
//                Log.d("ABCD","onPageSelected() is Called  "+i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {
//                Log.d("ABCD","onPageScrollStateChanged() is Called");
            }
        });







    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("ABCD","onStart() is Called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("ABCD","onResume() is Called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("ABCD","onStop() is Called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("ABCD","onDestroy() is Called");
    }

    public ViewPager getViewPager()
    {
        return viewPager;
    }

}


class MyPagerAdapter extends FragmentPagerAdapter
{

    private MainActivity mainActivity;
    public MyPagerAdapter(FragmentManager fm,MainActivity mainActivity) {
        super(fm);
        this.mainActivity=mainActivity;
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment=null;
        switch (i)
        {
            case 0:
                fragment=new Fragment_A(mainActivity);
                break;
            case 1:
                fragment=new Fragment_B();
                break;
            case 2:
                fragment=new Fragment_C();
                break;

        }


        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
















