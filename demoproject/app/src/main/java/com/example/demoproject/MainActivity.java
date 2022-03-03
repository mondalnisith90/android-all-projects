package com.example.demoproject;

import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private SearchView searchView;
    private MenuItem menuItem,menuItem1,menuItem2,menuItem3,menuItem4;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private FragmentManager fragmentManager;
    long maxMemory;
    Runtime rt;
//    private FragmentTransaction fragmentTransaction;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=findViewById(R.id.view_pager1);
        toolbar=findViewById(R.id.app_bar);
        tabLayout=findViewById(R.id.tab_layout);
        setSupportActionBar(toolbar);
        fragmentManager=getSupportFragmentManager();
        viewPager.setAdapter(new MyAdapter(fragmentManager));
        tabLayout.setupWithViewPager(viewPager);

        rt=Runtime.getRuntime();
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    maxMemory = rt.maxMemory();
                    Log.d("ABCD", "Heap size " + maxMemory);
                    long used_memory = (rt.totalMemory() - rt.freeMemory());
                    Log.d("ABCD", "Used Memory " + used_memory);
                    Log.d("ABCD", "Avaible Memory " + (rt.maxMemory() - used_memory));
                    SystemClock.sleep(2000);
                }
            }
        });
        thread.start();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.app_menu,menu);
        menuItem= menu.findItem(R.id.search);
        menuItem1=menu.findItem(R.id.whatsapp);
        menuItem2=menu.findItem(R.id.twiter);
        menuItem3=menu.findItem(R.id.setting);
        menuItem4=menu.findItem(R.id.help);

       searchView=(SearchView) menuItem.getActionView();
       searchView.setMaxWidth(Integer.MAX_VALUE);
       searchView.setQueryHint("search");
       menuItem.setOnActionExpandListener(new MenuItem.OnActionExpandListener() {
           @Override
           public boolean onMenuItemActionExpand(MenuItem item) {
               menuItem1.setVisible(false);
               menuItem2.setVisible(false);
               menuItem3.setVisible(false);
               menuItem4.setVisible(false);
               tabLayout.setVisibility(View.INVISIBLE);
               return true;
           }

           @Override
           public boolean onMenuItemActionCollapse(MenuItem item) {
               menuItem1.setVisible(true);
               menuItem2.setVisible(true);
               menuItem3.setVisible(true);
               menuItem4.setVisible(true);
               tabLayout.setVisibility(View.VISIBLE);
               return true;
           }
       });

        return true;
    }
}

class MyAdapter extends FragmentPagerAdapter
{

    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment=null;
        switch (i)
        {
            case  0:
                fragment=new Fragment_A();
                break;

            case  1:
                fragment=new Fragment_B();
                break;

            case  2:
                fragment=new Fragment_C();
                break;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String pageTitle=null;

        switch (position)
        {
            case 0:
                pageTitle="ALL SONGS";
                break;

            case 1:
                pageTitle="FOLDER";
                break;

            case 2:
                pageTitle="FAVOURITE";
                break;
        }


        return pageTitle;
    }
}




















