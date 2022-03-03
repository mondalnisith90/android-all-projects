package com.example.anotherbottomtoolbar;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private BottomNavigationView bottomNavigationView;
//    private FrameLayout frameLayout;
    private FragmentManager fragmentManager=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=(Toolbar)findViewById(R.id.toolbar);
        tabLayout=(TabLayout)findViewById(R.id.tab_layout);
        setSupportActionBar(toolbar);
        bottomNavigationView=(BottomNavigationView) findViewById(R.id.bottom_navigation);
        viewPager=(ViewPager) findViewById(R.id.view_pager);
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);



        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId())
                {
                    case R.id.home:
                        Toast.makeText(getApplicationContext(),"HOME",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.information:
                        Toast.makeText(getApplicationContext(),"Info",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.live_tv:
                        Toast.makeText(getApplicationContext(),"LiveTV",Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return true;
    }
}

class MyPagerAdapter extends FragmentPagerAdapter
{


    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment=null;

        switch (i)
        {
            case 0:
                fragment=new FragmentA();
                break;
            case 1:
                fragment=new FragmentB();
                break;
            case 2:
                fragment=new FragmentC();
                break;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

}











































