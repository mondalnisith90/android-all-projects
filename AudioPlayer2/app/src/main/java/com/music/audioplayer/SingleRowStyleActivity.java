package com.music.audioplayer;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class SingleRowStyleActivity extends AppCompatActivity {

    private SharedPraferenceForSingleRowAppearence sharedPraferenceForSingleRowAppearence;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_row_style);
        Toolbar toolbar=findViewById(R.id.app_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null)
        {
            actionBar.setTitle("Single Row Appearance");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        RelativeLayout hideFolderPath,hideFolderDateTimeInfo,hideDateTimeInfo,hideFileSize;
        final Switch hideFolderPath_switch,hideFolderDateTimeInfo_switch,hideDateTimeInfo_switch,hideFileSize_switch;
        hideFolderPath=findViewById(R.id.hide_folder_path);
        hideFolderPath_switch=hideFolderPath.findViewById(R.id.switch1);
        hideFolderDateTimeInfo=findViewById(R.id.hide_folder_dateTime_info);
        hideFolderDateTimeInfo_switch=hideFolderDateTimeInfo.findViewById(R.id.switch5);
        hideDateTimeInfo=findViewById(R.id.hide_date_time_info);
        hideDateTimeInfo_switch=hideDateTimeInfo.findViewById(R.id.switch2);
        hideFileSize=findViewById(R.id.hide_file_size);
        hideFileSize_switch=hideFileSize.findViewById(R.id.switch3);
        sharedPraferenceForSingleRowAppearence=new SharedPraferenceForSingleRowAppearence(this);
        hideFolderPath_switch.setChecked(sharedPraferenceForSingleRowAppearence.getHideFolderpathValue());
        hideFolderDateTimeInfo_switch.setChecked(sharedPraferenceForSingleRowAppearence.getHideFolderDateTimeInfoValue());
        hideDateTimeInfo_switch.setChecked(sharedPraferenceForSingleRowAppearence.getHideDateTimeInfoValue());
        hideFileSize_switch.setChecked(sharedPraferenceForSingleRowAppearence.getHideFileSizeValue());
        hideFolderPath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hideFolderPath_switch.isChecked()) {
                    hideFolderPath_switch.setChecked(false);
                    sharedPraferenceForSingleRowAppearence.saveHideFolderpathValue(false);
                }else {
                    hideFolderPath_switch.setChecked(true);
                    sharedPraferenceForSingleRowAppearence.saveHideFolderpathValue(true);
                }
            }
        });

        hideFolderDateTimeInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hideFolderDateTimeInfo_switch.isChecked()) {
                    hideFolderDateTimeInfo_switch.setChecked(false);
                    sharedPraferenceForSingleRowAppearence.saveHideFolderDateTimeInfoValue(false);
                }else {
                    hideFolderDateTimeInfo_switch.setChecked(true);
                    sharedPraferenceForSingleRowAppearence.saveHideFolderDateTimeInfoValue(true);
                }
            }
        });
        hideDateTimeInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hideDateTimeInfo_switch.isChecked()) {
                    hideDateTimeInfo_switch.setChecked(false);
                    sharedPraferenceForSingleRowAppearence.saveHideDateTimeInfoValue(false);
                }else {
                    hideDateTimeInfo_switch.setChecked(true);
                    sharedPraferenceForSingleRowAppearence.saveHideDateTimeInfoValue(true);
                }
            }
        });
        hideFileSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hideFileSize_switch.isChecked()) {
                    hideFileSize_switch.setChecked(false);
                    sharedPraferenceForSingleRowAppearence.saveHideFileSizeValue(false);
                }else {
                    hideFileSize_switch.setChecked(true);
                    sharedPraferenceForSingleRowAppearence.saveHideFileSizeValue(true);
                }
            }
        });
        //when we click switch it will not saved in shared Preaference because Click listener is attached to relative layout, not to the Switch. that's why
        // we have to attached Click Listener to Switch as well

        hideFolderPath_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked) {
                    sharedPraferenceForSingleRowAppearence.saveHideFolderpathValue(false);
                }else {
                    sharedPraferenceForSingleRowAppearence.saveHideFolderpathValue(true);
                }
            }
        });

        hideFolderDateTimeInfo_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked) {
                    sharedPraferenceForSingleRowAppearence.saveHideFolderDateTimeInfoValue(false);
                }else {
                    sharedPraferenceForSingleRowAppearence.saveHideFolderDateTimeInfoValue(true);
                }
            }
        });



        hideDateTimeInfo_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked) {
                    sharedPraferenceForSingleRowAppearence.saveHideDateTimeInfoValue(false);
                }else {
                    sharedPraferenceForSingleRowAppearence.saveHideDateTimeInfoValue(true);
                }
            }
        });

        hideFileSize_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked) {
                    sharedPraferenceForSingleRowAppearence.saveHideFileSizeValue(false);
                }else {
                    sharedPraferenceForSingleRowAppearence.saveHideFileSizeValue(true);
                }
            }
        });

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
}
