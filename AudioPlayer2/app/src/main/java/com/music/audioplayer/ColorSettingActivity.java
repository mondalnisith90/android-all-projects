package com.music.audioplayer;

import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ColorSettingActivity extends AppCompatActivity {

    private ImageView folderIconImageColor,folderPathImageColor,folderItemImageColor,folderDateTimeImageColor,folderTitleImageColor,
            fileTitleImageColor,fileSizeImageColor,fileDateTimeImageColor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_setting);
        Toolbar toolbar=findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null)
        {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Select Color");
        }
        RelativeLayout folderIconColor=findViewById(R.id.folder_icon_color);
        folderIconImageColor=folderIconColor.findViewById(R.id.folder_icon_image_color);
        RelativeLayout folderPathColor=findViewById(R.id.folder_path_color);
        folderPathImageColor=folderPathColor.findViewById(R.id.folder_path_image_color);
        RelativeLayout folderItemColor=findViewById(R.id.folder_item_color);
        folderItemImageColor=folderItemColor.findViewById(R.id.folder_item_image_color);
        RelativeLayout folderDateTimeColor=findViewById(R.id.folder_Date_time_color);
        folderDateTimeImageColor=folderDateTimeColor.findViewById(R.id.folder_Date_time_image_color);
        RelativeLayout folderTitleColor=findViewById(R.id.folder_Title_color);
        folderTitleImageColor=folderTitleColor.findViewById(R.id.folder_Title_image_color);
        RelativeLayout fileTitleColor=findViewById(R.id.file_Title_color);
        fileTitleImageColor=fileTitleColor.findViewById(R.id.file_Title_image_color);
        RelativeLayout fileSizeColor=findViewById(R.id.file_size_color);
        fileSizeImageColor=fileSizeColor.findViewById(R.id.file_size_image_color);
        RelativeLayout fileDateTimeColor=findViewById(R.id.file_date_time_color);
        fileDateTimeImageColor=fileDateTimeColor.findViewById(R.id.file_date_time_image_color);
        SharedPraferanceForSavingColors sharedPraferanceForSavingColors=new SharedPraferanceForSavingColors(this);
        String color;
        color=sharedPraferanceForSavingColors.getSavedFolderIconColor();
        folderIconImageColor.setBackgroundColor(Color.parseColor(color));
        color=sharedPraferanceForSavingColors.getSavedFolderPathColor();
        folderPathImageColor.setBackgroundColor(Color.parseColor(color));
        color=sharedPraferanceForSavingColors.getSavedFolderItemColor();
        folderItemImageColor.setBackgroundColor(Color.parseColor(color));
        color=sharedPraferanceForSavingColors.getSavedFolderDateTimeInfoColor();
        folderDateTimeImageColor.setBackgroundColor(Color.parseColor(color));
        color=sharedPraferanceForSavingColors.getSavedFolderTitleColor();
        folderTitleImageColor.setBackgroundColor(Color.parseColor(color));
        color=sharedPraferanceForSavingColors.getSavedFileTitleColor();
        fileTitleImageColor.setBackgroundColor(Color.parseColor(color));
        color=sharedPraferanceForSavingColors.getSavedFileSizeColor();
        fileSizeImageColor.setBackgroundColor(Color.parseColor(color));
        color=sharedPraferanceForSavingColors.getSavedFileDateTimeInfoColor();
        fileDateTimeImageColor.setBackgroundColor(Color.parseColor(color));

        folderIconColor.setOnClickListener(new MyOnClickListener());
        folderPathColor.setOnClickListener(new MyOnClickListener());
        folderItemColor.setOnClickListener(new MyOnClickListener());
        folderDateTimeColor.setOnClickListener(new MyOnClickListener());
        folderTitleColor.setOnClickListener(new MyOnClickListener());
        fileTitleColor.setOnClickListener(new MyOnClickListener());
        fileSizeColor.setOnClickListener(new MyOnClickListener());
        fileDateTimeColor.setOnClickListener(new MyOnClickListener());
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_from_left,R.anim.slide_to_right);
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

    public void setFolderIconImageColor(String color)
    {
        folderIconImageColor.setBackgroundColor(Color.parseColor(color));
    }
    public void setFolderPathImageColor(String color)
    {
        folderPathImageColor.setBackgroundColor(Color.parseColor(color));
    }
    public void setFolderItemImageColor(String color)
    {
        folderItemImageColor.setBackgroundColor(Color.parseColor(color));
    }
    public void setFolderDateTimeImageColor(String color)
    {
        folderDateTimeImageColor.setBackgroundColor(Color.parseColor(color));
    }
    public void setFolderTitleImageColor(String color)
    {
        folderTitleImageColor.setBackgroundColor(Color.parseColor(color));
    }
    public void setFileTitleImageColor(String color)
    {
        fileTitleImageColor.setBackgroundColor(Color.parseColor(color));
    }
    public void setFileSizeImageColor(String color)
    {
        fileSizeImageColor.setBackgroundColor(Color.parseColor(color));
    }
    public void setFileDateTimeImageColor(String color)
    {
        fileDateTimeImageColor.setBackgroundColor(Color.parseColor(color));
    }

    private class MyOnClickListener implements View.OnClickListener
    {
        @Override
        public void onClick(View v) {
            AlertDialogForAllColors alertDialogForAllColors=null;
            int positionNumber;
            switch (v.getId())
            {
                case R.id.folder_icon_color:
                    positionNumber=0;
                    alertDialogForAllColors=new AlertDialogForAllColors(ColorSettingActivity.this,positionNumber);
                    alertDialogForAllColors.setAlertDialogForAllColorsObject(alertDialogForAllColors);
                    alertDialogForAllColors.show(getSupportFragmentManager(),"dialog");
                    break;
                case R.id.folder_path_color:
                    positionNumber=1;
                    alertDialogForAllColors=new AlertDialogForAllColors(ColorSettingActivity.this,positionNumber);
                    alertDialogForAllColors.setAlertDialogForAllColorsObject(alertDialogForAllColors);
                    alertDialogForAllColors.show(getSupportFragmentManager(),"dialog");
                    break;
                case R.id.folder_item_color:
                    positionNumber=2;
                    alertDialogForAllColors=new AlertDialogForAllColors(ColorSettingActivity.this,positionNumber);
                    alertDialogForAllColors.setAlertDialogForAllColorsObject(alertDialogForAllColors);
                    alertDialogForAllColors.show(getSupportFragmentManager(),"dialog");
                    break;
                case R.id.folder_Date_time_color:
                    positionNumber=3;
                    alertDialogForAllColors=new AlertDialogForAllColors(ColorSettingActivity.this,positionNumber);
                    alertDialogForAllColors.setAlertDialogForAllColorsObject(alertDialogForAllColors);
                    alertDialogForAllColors.show(getSupportFragmentManager(),"dialog");
                    break;
                case R.id.folder_Title_color:
                    positionNumber=4;
                    alertDialogForAllColors=new AlertDialogForAllColors(ColorSettingActivity.this,positionNumber);
                    alertDialogForAllColors.setAlertDialogForAllColorsObject(alertDialogForAllColors);
                    alertDialogForAllColors.show(getSupportFragmentManager(),"dialog");
                    break;
                case R.id.file_Title_color:
                    positionNumber=5;
                    alertDialogForAllColors=new AlertDialogForAllColors(ColorSettingActivity.this,positionNumber);
                    alertDialogForAllColors.setAlertDialogForAllColorsObject(alertDialogForAllColors);
                    alertDialogForAllColors.show(getSupportFragmentManager(),"dialog");
                    break;
                case R.id.file_size_color:
                    positionNumber=6;
                    alertDialogForAllColors=new AlertDialogForAllColors(ColorSettingActivity.this,positionNumber);
                    alertDialogForAllColors.setAlertDialogForAllColorsObject(alertDialogForAllColors);
                    alertDialogForAllColors.show(getSupportFragmentManager(),"dialog");
                    break;
                case R.id.file_date_time_color:
                    positionNumber=7;
                    alertDialogForAllColors=new AlertDialogForAllColors(ColorSettingActivity.this,positionNumber);
                    alertDialogForAllColors.setAlertDialogForAllColorsObject(alertDialogForAllColors);
                    alertDialogForAllColors.show(getSupportFragmentManager(),"dialog");
                    break;
            }

        }
    }
}












