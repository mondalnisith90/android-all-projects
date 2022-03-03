package com.music.audioplayer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class SettingActivity extends AppCompatActivity {
    private TextView folderSetting,textStyle,singleRowApperance,color,backGroundTheme,animation;
    private TextView textView,path;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        folderSetting=findViewById(R.id.folder_setting);
        textStyle=findViewById(R.id.text_style);
        backGroundTheme=findViewById(R.id.background_theme);
        singleRowApperance=findViewById(R.id.single_row_apperance);
        color=findViewById(R.id.color);
        animation=findViewById(R.id.animation);
        color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SettingActivity.this,ColorSettingActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_from_right,R.anim.slide_to_left);
            }
        });
        singleRowApperance.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SettingActivity.this,SingleRowStyleActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_from_right,R.anim.slide_to_left);
            }
        });
        textStyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogForTextStyle();
            }
        });

        backGroundTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SettingActivity.this,ThemeActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_from_right,R.anim.slide_to_left);
            }
        });
        folderSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

        animation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialogForAnimation alertDialogForAnimation=new AlertDialogForAnimation(SettingActivity.this);
                alertDialogForAnimation.show(getSupportFragmentManager(),"dialog");
            }
        });
        Toolbar toolbar=findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar !=null)
        {
            actionBar.setTitle("Setting");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

    }

    private void showDialog()
    {
        MyFolderDialog folderDialog=new MyFolderDialog();
        folderDialog.show(getSupportFragmentManager(),"dialog");
    }
    private void showDialogForTextStyle()
    {
        AlertDialogForTextStyle alertDialogForTextStyle=new AlertDialogForTextStyle(this);
        alertDialogForTextStyle.show(getSupportFragmentManager(),"dia");
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case 16908332://For Back Button Press in Toolbar
            {
                finish();
                overridePendingTransition(R.anim.slide_from_left,R.anim.slide_to_right);
            }
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_from_left,R.anim.slide_to_right);
    }
}
