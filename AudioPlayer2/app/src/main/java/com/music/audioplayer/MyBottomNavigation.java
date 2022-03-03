package com.music.audioplayer;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.karumi.dexter.listener.single.PermissionListener;

public class MyBottomNavigation implements BottomNavigationView.OnNavigationItemSelectedListener {
    private Context context;

    public MyBottomNavigation(Context context)
    {
        this.context=  context;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
    {
        Intent intent=null;
        switch (menuItem.getItemId())
        {
            case R.id.home:
                intent=new Intent(context,HomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
                break;
            case R.id.setting:
//                Log.d("ABCD","delete is Clicked");
                intent=new Intent(context,SettingActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
                break;
            case R.id.storage_status:
//                Log.d("ABCD","details is Clicked");
                intent=new Intent(context,SongInfoActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
                break;
            case R.id.play_list:
//                Log.d("ABCD","favourite is Clicked");
                intent=new Intent(context,SettingActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
                break;
        }
        return true;
    }
}
