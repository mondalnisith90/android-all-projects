package com.music.audioplayer;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Objects;

import static com.music.audioplayer.R.id.color1;

@SuppressLint("ValidFragment")
public class AlertDialogForAllColors extends AppCompatDialogFragment {

    private AlertDialogForAllColors alertDialogForAllColors;
    private ColorSettingActivity colorSettingActivity;
    private int positionNumber;
    public AlertDialogForAllColors(ColorSettingActivity colorSettingActivity,int positionNumber)
    {
      this.colorSettingActivity=colorSettingActivity;
      this.positionNumber=positionNumber;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater layoutInflater= Objects.requireNonNull(getActivity()).getLayoutInflater();
        View view=layoutInflater.inflate(R.layout.all_colors_layout,null);
        ImageView color1,color2,color3,color4,color5,color6,color7,color8,color9,color10,color11,color12,color13,color14,color15,
                color16,color17,color18,color19,color20,color21,color22,color23,color24,color25,color26,color27,color28,color29,
                color30,color31,color32,color33,color34,color35;

        color1=view.findViewById(R.id.color1);
        color2=view.findViewById(R.id.color2);
        color3=view.findViewById(R.id.color3);
        color4=view.findViewById(R.id.color4);
        color5=view.findViewById(R.id.color5);
        color6=view.findViewById(R.id.color6);
        color7=view.findViewById(R.id.color7);
        color8=view.findViewById(R.id.color8);
        color9=view.findViewById(R.id.color9);
        color10=view.findViewById(R.id.color10);
        color11=view.findViewById(R.id.color11);
        color12=view.findViewById(R.id.color12);
        color13=view.findViewById(R.id.color13);
        color14=view.findViewById(R.id.color14);
        color15=view.findViewById(R.id.color15);
        color16=view.findViewById(R.id.color16);
        color17=view.findViewById(R.id.color17);
        color18=view.findViewById(R.id.color18);
        color19=view.findViewById(R.id.color19);
        color20=view.findViewById(R.id.color20);
        color21=view.findViewById(R.id.color21);
        color22=view.findViewById(R.id.color22);
        color23=view.findViewById(R.id.color23);
        color24=view.findViewById(R.id.color24);
        color25=view.findViewById(R.id.color25);
        color26=view.findViewById(R.id.color26);
        color27=view.findViewById(R.id.color27);
        color28=view.findViewById(R.id.color28);
        color29=view.findViewById(R.id.color29);
        color30=view.findViewById(R.id.color30);
        color31=view.findViewById(R.id.color31);
        color32=view.findViewById(R.id.color32);
        color33=view.findViewById(R.id.color33);
        color34=view.findViewById(R.id.color34);
        color35=view.findViewById(R.id.color35);
        color1.setOnClickListener(new MyOnClickListener());
        color2.setOnClickListener(new MyOnClickListener());
        color3.setOnClickListener(new MyOnClickListener());
        color4.setOnClickListener(new MyOnClickListener());
        color5.setOnClickListener(new MyOnClickListener());
        color6.setOnClickListener(new MyOnClickListener());
        color7.setOnClickListener(new MyOnClickListener());
        color8.setOnClickListener(new MyOnClickListener());
        color9.setOnClickListener(new MyOnClickListener());
        color10.setOnClickListener(new MyOnClickListener());
        color11.setOnClickListener(new MyOnClickListener());
        color12.setOnClickListener(new MyOnClickListener());
        color13.setOnClickListener(new MyOnClickListener());
        color14.setOnClickListener(new MyOnClickListener());
        color15.setOnClickListener(new MyOnClickListener());
        color16.setOnClickListener(new MyOnClickListener());
        color17.setOnClickListener(new MyOnClickListener());
        color18.setOnClickListener(new MyOnClickListener());
        color19.setOnClickListener(new MyOnClickListener());
        color20.setOnClickListener(new MyOnClickListener());
        color21.setOnClickListener(new MyOnClickListener());
        color22.setOnClickListener(new MyOnClickListener());
        color23.setOnClickListener(new MyOnClickListener());
        color24.setOnClickListener(new MyOnClickListener());
        color25.setOnClickListener(new MyOnClickListener());
        color26.setOnClickListener(new MyOnClickListener());
        color27.setOnClickListener(new MyOnClickListener());
        color28.setOnClickListener(new MyOnClickListener());
        color29.setOnClickListener(new MyOnClickListener());
        color30.setOnClickListener(new MyOnClickListener());
        color31.setOnClickListener(new MyOnClickListener());
        color32.setOnClickListener(new MyOnClickListener());
        color33.setOnClickListener(new MyOnClickListener());
        color34.setOnClickListener(new MyOnClickListener());
        color35.setOnClickListener(new MyOnClickListener());

        AlertDialog.Builder dialogBuilder=new AlertDialog.Builder(getContext());
        dialogBuilder.setView(view)
                .setTitle("Choose Color");

        return dialogBuilder.create();
    }



    private class MyOnClickListener implements View.OnClickListener
    {
        @Override
        public void onClick(View v) {
            SharedPraferanceForSavingColors sharedPraferanceForSavingColors=new SharedPraferanceForSavingColors(colorSettingActivity);
            switch (v.getId())
            {
                case R.id.color1:
                {
                    switch (positionNumber)
                    {
                        case 0:
                        {
                            sharedPraferanceForSavingColors.saveFolderIconColor("#0000FF");
                            colorSettingActivity.setFolderIconImageColor("#0000FF");
                            break;
                        }

                        case 1:
                        {
                            sharedPraferanceForSavingColors.saveFolderPathColor("#0000FF");
                            colorSettingActivity.setFolderPathImageColor("#0000FF");
                            break;
                        }
                        case 2:
                        {
                            sharedPraferanceForSavingColors.saveFolderItemColor("#0000FF");
                            colorSettingActivity.setFolderItemImageColor("#0000FF");
                            break;
                        }
                        case 3:
                        {
                            sharedPraferanceForSavingColors.saveFolderDateTimeInfoColor("#0000FF");
                            colorSettingActivity.setFolderDateTimeImageColor("#0000FF");
                            break;
                        }
                        case 4:
                        {
                            sharedPraferanceForSavingColors.saveFolderTitleColor("#0000FF");
                            colorSettingActivity.setFolderTitleImageColor("#0000FF");
                            break;
                        }
                        case 5:
                        {
                            sharedPraferanceForSavingColors.saveFileTitleColor("#0000FF");
                            colorSettingActivity.setFileTitleImageColor("#0000FF");
                            break;
                        }
                        case 6:
                        {
                            sharedPraferanceForSavingColors.saveFileSizeColor("#0000FF");
                            colorSettingActivity.setFileSizeImageColor("#0000FF");
                            break;
                        }
                        case 7:
                        {
                            sharedPraferanceForSavingColors.saveFileDateTimeInfoColor("#0000FF");
                            colorSettingActivity.setFileDateTimeImageColor("#0000FF");
                            break;
                        }

                    }
                    Toast.makeText(getContext(), "Color is Set", Toast.LENGTH_SHORT).show();
                    alertDialogForAllColors.dismiss();
                    break;
                }
                case R.id.color2:
                {
                    switch (positionNumber)
                    {
                        case 0:
                        {
                            sharedPraferanceForSavingColors.saveFolderIconColor("#008000");
                            colorSettingActivity.setFolderIconImageColor("#008000");
                            break;
                        }

                        case 1:
                        {
                            sharedPraferanceForSavingColors.saveFolderPathColor("#008000");
                            colorSettingActivity.setFolderPathImageColor("#008000");
                            break;
                        }
                        case 2:
                        {
                            sharedPraferanceForSavingColors.saveFolderItemColor("#008000");
                            colorSettingActivity.setFolderItemImageColor("#008000");
                            break;
                        }
                        case 3:
                        {
                            sharedPraferanceForSavingColors.saveFolderDateTimeInfoColor("#008000");
                            colorSettingActivity.setFolderDateTimeImageColor("#008000");
                            break;
                        }
                        case 4:
                        {
                            sharedPraferanceForSavingColors.saveFolderTitleColor("#008000");
                            colorSettingActivity.setFolderTitleImageColor("#008000");
                            break;
                        }
                        case 5:
                        {
                            sharedPraferanceForSavingColors.saveFileTitleColor("#008000");
                            colorSettingActivity.setFileTitleImageColor("#008000");
                            break;
                        }
                        case 6:
                        {
                            sharedPraferanceForSavingColors.saveFileSizeColor("#008000");
                            colorSettingActivity.setFileSizeImageColor("#008000");
                            break;
                        }
                        case 7:
                        {
                            sharedPraferanceForSavingColors.saveFileDateTimeInfoColor("#008000");
                            colorSettingActivity.setFileDateTimeImageColor("#008000");
                            break;
                        }

                    }
                    Toast.makeText(getContext(), "Color is Set", Toast.LENGTH_SHORT).show();
                    alertDialogForAllColors.dismiss();
                    break;
                }
                case R.id.color3:
                {
                    switch (positionNumber)
                    {
                        case 0:
                        {
                            sharedPraferanceForSavingColors.saveFolderIconColor("#800080");
                            colorSettingActivity.setFolderIconImageColor("#800080");
                            break;
                        }

                        case 1:
                        {
                            sharedPraferanceForSavingColors.saveFolderPathColor("#800080");
                            colorSettingActivity.setFolderPathImageColor("#800080");
                            break;
                        }
                        case 2:
                        {
                            sharedPraferanceForSavingColors.saveFolderItemColor("#800080");
                            colorSettingActivity.setFolderItemImageColor("#800080");
                            break;
                        }
                        case 3:
                        {
                            sharedPraferanceForSavingColors.saveFolderDateTimeInfoColor("#800080");
                            colorSettingActivity.setFolderDateTimeImageColor("#800080");
                            break;
                        }
                        case 4:
                        {
                            sharedPraferanceForSavingColors.saveFolderTitleColor("#800080");
                            colorSettingActivity.setFolderTitleImageColor("#800080");
                            break;
                        }
                        case 5:
                        {
                            sharedPraferanceForSavingColors.saveFileTitleColor("#800080");
                            colorSettingActivity.setFileTitleImageColor("#800080");
                            break;
                        }
                        case 6:
                        {
                            sharedPraferanceForSavingColors.saveFileSizeColor("#800080");
                            colorSettingActivity.setFileSizeImageColor("#800080");
                            break;
                        }
                        case 7:
                        {
                            sharedPraferanceForSavingColors.saveFileDateTimeInfoColor("#800080");
                            colorSettingActivity.setFileDateTimeImageColor("#800080");
                            break;
                        }
                    }
                    Toast.makeText(getContext(), "Color is Set", Toast.LENGTH_SHORT).show();
                    alertDialogForAllColors.dismiss();
                    break;
                }
                case R.id.color4:
                {
                    switch (positionNumber)
                    {
                        case 0:
                        {
                            sharedPraferanceForSavingColors.saveFolderIconColor("#FFFF00");
                            colorSettingActivity.setFolderIconImageColor("#FFFF00");
                            break;
                        }

                        case 1:
                        {
                            sharedPraferanceForSavingColors.saveFolderPathColor("#FFFF00");
                            colorSettingActivity.setFolderPathImageColor("#FFFF00");
                            break;
                        }
                        case 2:
                        {
                            sharedPraferanceForSavingColors.saveFolderItemColor("#FFFF00");
                            colorSettingActivity.setFolderItemImageColor("#FFFF00");
                            break;
                        }
                        case 3:
                        {
                            sharedPraferanceForSavingColors.saveFolderDateTimeInfoColor("#FFFF00");
                            colorSettingActivity.setFolderDateTimeImageColor("#FFFF00");
                            break;
                        }
                        case 4:
                        {
                            sharedPraferanceForSavingColors.saveFolderTitleColor("#FFFF00");
                            colorSettingActivity.setFolderTitleImageColor("#FFFF00");
                            break;
                        }
                        case 5:
                        {
                            sharedPraferanceForSavingColors.saveFileTitleColor("#FFFF00");
                            colorSettingActivity.setFileTitleImageColor("#FFFF00");
                            break;
                        }
                        case 6:
                        {
                            sharedPraferanceForSavingColors.saveFileSizeColor("#FFFF00");
                            colorSettingActivity.setFileSizeImageColor("#FFFF00");
                            break;
                        }
                        case 7:
                        {
                            sharedPraferanceForSavingColors.saveFileDateTimeInfoColor("#FFFF00");
                            colorSettingActivity.setFileDateTimeImageColor("#FFFF00");
                            break;
                        }
                    }
                    Toast.makeText(getContext(), "Color is Set", Toast.LENGTH_SHORT).show();
                    alertDialogForAllColors.dismiss();
                    break;
                }
                case R.id.color5:
                {
                    switch (positionNumber)
                    {
                        case 0:
                        {
                            sharedPraferanceForSavingColors.saveFolderIconColor("#FF8C00");
                            colorSettingActivity.setFolderIconImageColor("#FF8C00");
                            break;
                        }

                        case 1:
                        {
                            sharedPraferanceForSavingColors.saveFolderPathColor("#FF8C00");
                            colorSettingActivity.setFolderPathImageColor("#FF8C00");
                            break;
                        }
                        case 2:
                        {
                            sharedPraferanceForSavingColors.saveFolderItemColor("#FF8C00");
                            colorSettingActivity.setFolderItemImageColor("#FF8C00");
                            break;
                        }
                        case 3:
                        {
                            sharedPraferanceForSavingColors.saveFolderDateTimeInfoColor("#FF8C00");
                            colorSettingActivity.setFolderDateTimeImageColor("#FF8C00");
                            break;
                        }
                        case 4:
                        {
                            sharedPraferanceForSavingColors.saveFolderTitleColor("#FF8C00");
                            colorSettingActivity.setFolderTitleImageColor("#FF8C00");
                            break;
                        }
                        case 5:
                        {
                            sharedPraferanceForSavingColors.saveFileTitleColor("#FF8C00");
                            colorSettingActivity.setFileTitleImageColor("#FF8C00");
                            break;
                        }
                        case 6:
                        {
                            sharedPraferanceForSavingColors.saveFileSizeColor("#FF8C00");
                            colorSettingActivity.setFileSizeImageColor("#FF8C00");
                            break;
                        }
                        case 7:
                        {
                            sharedPraferanceForSavingColors.saveFileDateTimeInfoColor("#FF8C00");
                            colorSettingActivity.setFileDateTimeImageColor("#FF8C00");
                            break;
                        }
                    }
                    Toast.makeText(getContext(), "Color is Set", Toast.LENGTH_SHORT).show();
                    alertDialogForAllColors.dismiss();
                    break;
                }
                case R.id.color6:
                {
                    switch (positionNumber)
                    {
                        case 0:
                        {
                            sharedPraferanceForSavingColors.saveFolderIconColor("#808080");
                            colorSettingActivity.setFolderIconImageColor("#808080");
                            break;
                        }

                        case 1:
                        {
                            sharedPraferanceForSavingColors.saveFolderPathColor("#808080");
                            colorSettingActivity.setFolderPathImageColor("#808080");
                            break;
                        }
                        case 2:
                        {
                            sharedPraferanceForSavingColors.saveFolderItemColor("#808080");
                            colorSettingActivity.setFolderItemImageColor("#808080");
                            break;
                        }
                        case 3:
                        {
                            sharedPraferanceForSavingColors.saveFolderDateTimeInfoColor("#808080");
                            colorSettingActivity.setFolderDateTimeImageColor("#808080");
                            break;
                        }
                        case 4:
                        {
                            sharedPraferanceForSavingColors.saveFolderTitleColor("#808080");
                            colorSettingActivity.setFolderTitleImageColor("#808080");
                            break;
                        }
                        case 5:
                        {
                            sharedPraferanceForSavingColors.saveFileTitleColor("#808080");
                            colorSettingActivity.setFileTitleImageColor("#808080");
                            break;
                        }
                        case 6:
                        {
                            sharedPraferanceForSavingColors.saveFileSizeColor("#808080");
                            colorSettingActivity.setFileSizeImageColor("#808080");
                            break;
                        }
                        case 7:
                        {
                            sharedPraferanceForSavingColors.saveFileDateTimeInfoColor("#808080");
                            colorSettingActivity.setFileDateTimeImageColor("#808080");
                            break;
                        }
                    }
                    Toast.makeText(getContext(), "Color is Set", Toast.LENGTH_SHORT).show();
                    alertDialogForAllColors.dismiss();
                    break;
                }
                case R.id.color7:
                {
                    switch (positionNumber)
                    {
                        case 0:
                        {
                            sharedPraferanceForSavingColors.saveFolderIconColor("#FF00FF");
                            colorSettingActivity.setFolderIconImageColor("#FF00FF");
                            break;
                        }

                        case 1:
                        {
                            sharedPraferanceForSavingColors.saveFolderPathColor("#FF00FF");
                            colorSettingActivity.setFolderPathImageColor("#FF00FF");
                            break;
                        }
                        case 2:
                        {
                            sharedPraferanceForSavingColors.saveFolderItemColor("#FF00FF");
                            colorSettingActivity.setFolderItemImageColor("#FF00FF");
                            break;
                        }
                        case 3:
                        {
                            sharedPraferanceForSavingColors.saveFolderDateTimeInfoColor("#FF00FF");
                            colorSettingActivity.setFolderDateTimeImageColor("#FF00FF");
                            break;
                        }
                        case 4:
                        {
                            sharedPraferanceForSavingColors.saveFolderTitleColor("#FF00FF");
                            colorSettingActivity.setFolderTitleImageColor("#FF00FF");
                            break;
                        }
                        case 5:
                        {
                            sharedPraferanceForSavingColors.saveFileTitleColor("#FF00FF");
                            colorSettingActivity.setFileTitleImageColor("#FF00FF");
                            break;
                        }
                        case 6:
                        {
                            sharedPraferanceForSavingColors.saveFileSizeColor("#FF00FF");
                            colorSettingActivity.setFileSizeImageColor("#FF00FF");
                            break;
                        }
                        case 7:
                        {
                            sharedPraferanceForSavingColors.saveFileDateTimeInfoColor("#FF00FF");
                            colorSettingActivity.setFileDateTimeImageColor("#FF00FF");
                            break;
                        }
                    }
                    Toast.makeText(getContext(), "Color is Set", Toast.LENGTH_SHORT).show();
                    alertDialogForAllColors.dismiss();
                    break;
                }
                case R.id.color8:
                {
                    switch (positionNumber)
                    {
                        case 0:
                        {
                            sharedPraferanceForSavingColors.saveFolderIconColor("#00FFFF");
                            colorSettingActivity.setFolderIconImageColor("#00FFFF");
                            break;
                        }

                        case 1:
                        {
                            sharedPraferanceForSavingColors.saveFolderPathColor("#00FFFF");
                            colorSettingActivity.setFolderPathImageColor("#00FFFF");
                            break;
                        }
                        case 2:
                        {
                            sharedPraferanceForSavingColors.saveFolderItemColor("#00FFFF");
                            colorSettingActivity.setFolderItemImageColor("#00FFFF");
                            break;
                        }
                        case 3:
                        {
                            sharedPraferanceForSavingColors.saveFolderDateTimeInfoColor("#00FFFF");
                            colorSettingActivity.setFolderDateTimeImageColor("#00FFFF");
                            break;
                        }
                        case 4:
                        {
                            sharedPraferanceForSavingColors.saveFolderTitleColor("#00FFFF");
                            colorSettingActivity.setFolderTitleImageColor("#00FFFF");
                            break;
                        }
                        case 5:
                        {
                            sharedPraferanceForSavingColors.saveFileTitleColor("#00FFFF");
                            colorSettingActivity.setFileTitleImageColor("#00FFFF");
                            break;
                        }
                        case 6:
                        {
                            sharedPraferanceForSavingColors.saveFileSizeColor("#00FFFF");
                            colorSettingActivity.setFileSizeImageColor("#00FFFF");
                            break;
                        }
                        case 7:
                        {
                            sharedPraferanceForSavingColors.saveFileDateTimeInfoColor("#00FFFF");
                            colorSettingActivity.setFileDateTimeImageColor("#00FFFF");
                            break;
                        }
                    }
                    Toast.makeText(getContext(), "Color is Set", Toast.LENGTH_SHORT).show();
                    alertDialogForAllColors.dismiss();
                    break;
                }
                case R.id.color9:
                {
                    switch (positionNumber)
                    {
                        case 0:
                        {
                            sharedPraferanceForSavingColors.saveFolderIconColor("#DE3163");
                            colorSettingActivity.setFolderIconImageColor("#DE3163");
                            break;
                        }

                        case 1:
                        {
                            sharedPraferanceForSavingColors.saveFolderPathColor("#DE3163");
                            colorSettingActivity.setFolderPathImageColor("#DE3163");
                            break;
                        }
                        case 2:
                        {
                            sharedPraferanceForSavingColors.saveFolderItemColor("#DE3163");
                            colorSettingActivity.setFolderItemImageColor("#DE3163");
                            break;
                        }
                        case 3:
                        {
                            sharedPraferanceForSavingColors.saveFolderDateTimeInfoColor("#DE3163");
                            colorSettingActivity.setFolderDateTimeImageColor("#DE3163");
                            break;
                        }
                        case 4:
                        {
                            sharedPraferanceForSavingColors.saveFolderTitleColor("#DE3163");
                            colorSettingActivity.setFolderTitleImageColor("#DE3163");
                            break;
                        }
                        case 5:
                        {
                            sharedPraferanceForSavingColors.saveFileTitleColor("#DE3163");
                            colorSettingActivity.setFileTitleImageColor("#DE3163");
                            break;
                        }
                        case 6:
                        {
                            sharedPraferanceForSavingColors.saveFileSizeColor("#DE3163");
                            colorSettingActivity.setFileSizeImageColor("#DE3163");
                            break;
                        }
                        case 7:
                        {
                            sharedPraferanceForSavingColors.saveFileDateTimeInfoColor("#DE3163");
                            colorSettingActivity.setFileDateTimeImageColor("#DE3163");
                            break;
                        }
                    }
                    Toast.makeText(getContext(), "Color is Set", Toast.LENGTH_SHORT).show();
                    alertDialogForAllColors.dismiss();
                    break;
                }
                case R.id.color10:
                {
                    switch (positionNumber)
                    {
                        case 0:
                        {
                            sharedPraferanceForSavingColors.saveFolderIconColor("#17BECF");
                            colorSettingActivity.setFolderIconImageColor("#17BECF");
                            break;
                        }

                        case 1:
                        {
                            sharedPraferanceForSavingColors.saveFolderPathColor("#17BECF");
                            colorSettingActivity.setFolderPathImageColor("#17BECF");
                            break;
                        }
                        case 2:
                        {
                            sharedPraferanceForSavingColors.saveFolderItemColor("#17BECF");
                            colorSettingActivity.setFolderItemImageColor("#17BECF");
                            break;
                        }
                        case 3:
                        {
                            sharedPraferanceForSavingColors.saveFolderDateTimeInfoColor("#17BECF");
                            colorSettingActivity.setFolderDateTimeImageColor("#17BECF");
                            break;
                        }
                        case 4:
                        {
                            sharedPraferanceForSavingColors.saveFolderTitleColor("#17BECF");
                            colorSettingActivity.setFolderTitleImageColor("#17BECF");
                            break;
                        }
                        case 5:
                        {
                            sharedPraferanceForSavingColors.saveFileTitleColor("#17BECF");
                            colorSettingActivity.setFileTitleImageColor("#17BECF");
                            break;
                        }
                        case 6:
                        {
                            sharedPraferanceForSavingColors.saveFileSizeColor("#17BECF");
                            colorSettingActivity.setFileSizeImageColor("#17BECF");
                            break;
                        }
                        case 7:
                        {
                            sharedPraferanceForSavingColors.saveFileDateTimeInfoColor("#17BECF");
                            colorSettingActivity.setFileDateTimeImageColor("#17BECF");
                            break;
                        }
                    }
                    Toast.makeText(getContext(), "Color is Set", Toast.LENGTH_SHORT).show();
                    alertDialogForAllColors.dismiss();
                    break;
                }
                case R.id.color11:
                {
                    switch (positionNumber)
                    {
                        case 0:
                        {
                            sharedPraferanceForSavingColors.saveFolderIconColor("#99bbCF");
                            colorSettingActivity.setFolderIconImageColor("#99bbCF");
                            break;
                        }

                        case 1:
                        {
                            sharedPraferanceForSavingColors.saveFolderPathColor("#99bbCF");
                            colorSettingActivity.setFolderPathImageColor("#99bbCF");
                            break;
                        }
                        case 2:
                        {
                            sharedPraferanceForSavingColors.saveFolderItemColor("#99bbCF");
                            colorSettingActivity.setFolderItemImageColor("#99bbCF");
                            break;
                        }
                        case 3:
                        {
                            sharedPraferanceForSavingColors.saveFolderDateTimeInfoColor("#99bbCF");
                            colorSettingActivity.setFolderDateTimeImageColor("#99bbCF");
                            break;
                        }
                        case 4:
                        {
                            sharedPraferanceForSavingColors.saveFolderTitleColor("#99bbCF");
                            colorSettingActivity.setFolderTitleImageColor("#99bbCF");
                            break;
                        }
                        case 5:
                        {
                            sharedPraferanceForSavingColors.saveFileTitleColor("#99bbCF");
                            colorSettingActivity.setFileTitleImageColor("#99bbCF");
                            break;
                        }
                        case 6:
                        {
                            sharedPraferanceForSavingColors.saveFileSizeColor("#99bbCF");
                            colorSettingActivity.setFileSizeImageColor("#99bbCF");
                            break;
                        }
                        case 7:
                        {
                            sharedPraferanceForSavingColors.saveFileDateTimeInfoColor("#99bbCF");
                            colorSettingActivity.setFileDateTimeImageColor("#99bbCF");
                            break;
                        }
                    }
                    Toast.makeText(getContext(), "Color is Set", Toast.LENGTH_SHORT).show();
                    alertDialogForAllColors.dismiss();
                    break;
                }
                case R.id.color12:
                {
                    switch (positionNumber)
                    {
                        case 0:
                        {
                            sharedPraferanceForSavingColors.saveFolderIconColor("#98DF8A");
                            colorSettingActivity.setFolderIconImageColor("#98DF8A");
                            break;
                        }

                        case 1:
                        {
                            sharedPraferanceForSavingColors.saveFolderPathColor("#98DF8A");
                            colorSettingActivity.setFolderPathImageColor("#98DF8A");
                            break;
                        }
                        case 2:
                        {
                            sharedPraferanceForSavingColors.saveFolderItemColor("#98DF8A");
                            colorSettingActivity.setFolderItemImageColor("#98DF8A");
                            break;
                        }
                        case 3:
                        {
                            sharedPraferanceForSavingColors.saveFolderDateTimeInfoColor("#98DF8A");
                            colorSettingActivity.setFolderDateTimeImageColor("#98DF8A");
                            break;
                        }
                        case 4:
                        {
                            sharedPraferanceForSavingColors.saveFolderTitleColor("#98DF8A");
                            colorSettingActivity.setFolderTitleImageColor("#98DF8A");
                            break;
                        }
                        case 5:
                        {
                            sharedPraferanceForSavingColors.saveFileTitleColor("#98DF8A");
                            colorSettingActivity.setFileTitleImageColor("#98DF8A");
                            break;
                        }
                        case 6:
                        {
                            sharedPraferanceForSavingColors.saveFileSizeColor("#98DF8A");
                            colorSettingActivity.setFileSizeImageColor("#98DF8A");
                            break;
                        }
                        case 7:
                        {
                            sharedPraferanceForSavingColors.saveFileDateTimeInfoColor("#98DF8A");
                            colorSettingActivity.setFileDateTimeImageColor("#98DF8A");
                            break;
                        }
                    }
                    Toast.makeText(getContext(), "Color is Set", Toast.LENGTH_SHORT).show();
                    alertDialogForAllColors.dismiss();
                    break;
                }
                case R.id.color13:
                {
                    switch (positionNumber)
                    {
                        case 0:
                        {
                            sharedPraferanceForSavingColors.saveFolderIconColor("#C7C7C7");
                            colorSettingActivity.setFolderIconImageColor("#C7C7C7");
                            break;
                        }

                        case 1:
                        {
                            sharedPraferanceForSavingColors.saveFolderPathColor("#C7C7C7");
                            colorSettingActivity.setFolderPathImageColor("#C7C7C7");
                            break;
                        }
                        case 2:
                        {
                            sharedPraferanceForSavingColors.saveFolderItemColor("#C7C7C7");
                            colorSettingActivity.setFolderItemImageColor("#C7C7C7");
                            break;
                        }
                        case 3:
                        {
                            sharedPraferanceForSavingColors.saveFolderDateTimeInfoColor("#C7C7C7");
                            colorSettingActivity.setFolderDateTimeImageColor("#C7C7C7");
                            break;
                        }
                        case 4:
                        {
                            sharedPraferanceForSavingColors.saveFolderTitleColor("#C7C7C7");
                            colorSettingActivity.setFolderTitleImageColor("#C7C7C7");
                            break;
                        }
                        case 5:
                        {
                            sharedPraferanceForSavingColors.saveFileTitleColor("#C7C7C7");
                            colorSettingActivity.setFileTitleImageColor("#C7C7C7");
                            break;
                        }
                        case 6:
                        {
                            sharedPraferanceForSavingColors.saveFileSizeColor("#C7C7C7");
                            colorSettingActivity.setFileSizeImageColor("#C7C7C7");
                            break;
                        }
                        case 7:
                        {
                            sharedPraferanceForSavingColors.saveFileDateTimeInfoColor("#C7C7C7");
                            colorSettingActivity.setFileDateTimeImageColor("#C7C7C7");
                            break;
                        }
                    }
                    Toast.makeText(getContext(), "Color is Set", Toast.LENGTH_SHORT).show();
                    alertDialogForAllColors.dismiss();
                    break;
                }
                case R.id.color14:
                {
                    switch (positionNumber)
                    {
                        case 0:
                        {
                            sharedPraferanceForSavingColors.saveFolderIconColor("#FF0000");
                            colorSettingActivity.setFolderIconImageColor("#FF0000");
                            break;
                        }

                        case 1:
                        {
                            sharedPraferanceForSavingColors.saveFolderPathColor("#FF0000");
                            colorSettingActivity.setFolderPathImageColor("#FF0000");
                            break;
                        }
                        case 2:
                        {
                            sharedPraferanceForSavingColors.saveFolderItemColor("#FF0000");
                            colorSettingActivity.setFolderItemImageColor("#FF0000");
                            break;
                        }
                        case 3:
                        {
                            sharedPraferanceForSavingColors.saveFolderDateTimeInfoColor("#FF0000");
                            colorSettingActivity.setFolderDateTimeImageColor("#FF0000");
                            break;
                        }
                        case 4:
                        {
                            sharedPraferanceForSavingColors.saveFolderTitleColor("#FF0000");
                            colorSettingActivity.setFolderTitleImageColor("#FF0000");
                            break;
                        }
                        case 5:
                        {
                            sharedPraferanceForSavingColors.saveFileTitleColor("#FF0000");
                            colorSettingActivity.setFileTitleImageColor("#FF0000");
                            break;
                        }
                        case 6:
                        {
                            sharedPraferanceForSavingColors.saveFileSizeColor("#FF0000");
                            colorSettingActivity.setFileSizeImageColor("#FF0000");
                            break;
                        }
                        case 7:
                        {
                            sharedPraferanceForSavingColors.saveFileDateTimeInfoColor("#FF0000");
                            colorSettingActivity.setFileDateTimeImageColor("#FF0000");
                            break;
                        }
                    }
                    Toast.makeText(getContext(), "Color is Set", Toast.LENGTH_SHORT).show();
                    alertDialogForAllColors.dismiss();
                    break;
                }
                case R.id.color15:
                {
                    switch (positionNumber)
                    {
                        case 0:
                        {
                            sharedPraferanceForSavingColors.saveFolderIconColor("#7F7F7F");
                            colorSettingActivity.setFolderIconImageColor("#7F7F7F");
                            break;
                        }

                        case 1:
                        {
                            sharedPraferanceForSavingColors.saveFolderPathColor("#7F7F7F");
                            colorSettingActivity.setFolderPathImageColor("#7F7F7F");
                            break;
                        }
                        case 2:
                        {
                            sharedPraferanceForSavingColors.saveFolderItemColor("#7F7F7F");
                            colorSettingActivity.setFolderItemImageColor("#7F7F7F");
                            break;
                        }
                        case 3:
                        {
                            sharedPraferanceForSavingColors.saveFolderDateTimeInfoColor("#7F7F7F");
                            colorSettingActivity.setFolderDateTimeImageColor("#7F7F7F");
                            break;
                        }
                        case 4:
                        {
                            sharedPraferanceForSavingColors.saveFolderTitleColor("#7F7F7F");
                            colorSettingActivity.setFolderTitleImageColor("#7F7F7F");
                            break;
                        }
                        case 5:
                        {
                            sharedPraferanceForSavingColors.saveFileTitleColor("#7F7F7F");
                            colorSettingActivity.setFileTitleImageColor("#7F7F7F");
                            break;
                        }
                        case 6:
                        {
                            sharedPraferanceForSavingColors.saveFileSizeColor("#7F7F7F");
                            colorSettingActivity.setFileSizeImageColor("#7F7F7F");
                            break;
                        }
                        case 7:
                        {
                            sharedPraferanceForSavingColors.saveFileDateTimeInfoColor("#7F7F7F");
                            colorSettingActivity.setFileDateTimeImageColor("#7F7F7F");
                            break;
                        }
                    }
                    Toast.makeText(getContext(), "Color is Set", Toast.LENGTH_SHORT).show();
                    alertDialogForAllColors.dismiss();
                    break;
                }
                case R.id.color16:
                {
                    switch (positionNumber)
                    {
                        case 0:
                        {
                            sharedPraferanceForSavingColors.saveFolderIconColor("#D8D88D");
                            colorSettingActivity.setFolderIconImageColor("#D8D88D");
                            break;
                        }

                        case 1:
                        {
                            sharedPraferanceForSavingColors.saveFolderPathColor("#D8D88D");
                            colorSettingActivity.setFolderPathImageColor("#D8D88D");
                            break;
                        }
                        case 2:
                        {
                            sharedPraferanceForSavingColors.saveFolderItemColor("#D8D88D");
                            colorSettingActivity.setFolderItemImageColor("#D8D88D");
                            break;
                        }
                        case 3:
                        {
                            sharedPraferanceForSavingColors.saveFolderDateTimeInfoColor("#D8D88D");
                            colorSettingActivity.setFolderDateTimeImageColor("#D8D88D");
                            break;
                        }
                        case 4:
                        {
                            sharedPraferanceForSavingColors.saveFolderTitleColor("#D8D88D");
                            colorSettingActivity.setFolderTitleImageColor("#D8D88D");
                            break;
                        }
                        case 5:
                        {
                            sharedPraferanceForSavingColors.saveFileTitleColor("#D8D88D");
                            colorSettingActivity.setFileTitleImageColor("#D8D88D");
                            break;
                        }
                        case 6:
                        {
                            sharedPraferanceForSavingColors.saveFileSizeColor("#D8D88D");
                            colorSettingActivity.setFileSizeImageColor("#D8D88D");
                            break;
                        }
                        case 7:
                        {
                            sharedPraferanceForSavingColors.saveFileDateTimeInfoColor("#D8D88D");
                            colorSettingActivity.setFileDateTimeImageColor("#D8D88D");
                            break;
                        }
                    }
                    Toast.makeText(getContext(), "Color is Set", Toast.LENGTH_SHORT).show();
                    alertDialogForAllColors.dismiss();
                    break;
                }
                case R.id.color17:
                {
                    switch (positionNumber)
                    {
                        case 0:
                        {
                            sharedPraferanceForSavingColors.saveFolderIconColor("#2D6D66");
                            colorSettingActivity.setFolderIconImageColor("#2D6D66");
                            break;
                        }

                        case 1:
                        {
                            sharedPraferanceForSavingColors.saveFolderPathColor("#2D6D66");
                            colorSettingActivity.setFolderPathImageColor("#2D6D66");
                            break;
                        }
                        case 2:
                        {
                            sharedPraferanceForSavingColors.saveFolderItemColor("#2D6D66");
                            colorSettingActivity.setFolderItemImageColor("#2D6D66");
                            break;
                        }
                        case 3:
                        {
                            sharedPraferanceForSavingColors.saveFolderDateTimeInfoColor("#2D6D66");
                            colorSettingActivity.setFolderDateTimeImageColor("#2D6D66");
                            break;
                        }
                        case 4:
                        {
                            sharedPraferanceForSavingColors.saveFolderTitleColor("#2D6D66");
                            colorSettingActivity.setFolderTitleImageColor("#2D6D66");
                            break;
                        }
                        case 5:
                        {
                            sharedPraferanceForSavingColors.saveFileTitleColor("#2D6D66");
                            colorSettingActivity.setFileTitleImageColor("#2D6D66");
                            break;
                        }
                        case 6:
                        {
                            sharedPraferanceForSavingColors.saveFileSizeColor("#2D6D66");
                            colorSettingActivity.setFileSizeImageColor("#2D6D66");
                            break;
                        }
                        case 7:
                        {
                            sharedPraferanceForSavingColors.saveFileDateTimeInfoColor("#2D6D66");
                            colorSettingActivity.setFileDateTimeImageColor("#2D6D66");
                            break;
                        }
                    }
                    Toast.makeText(getContext(), "Color is Set", Toast.LENGTH_SHORT).show();
                    alertDialogForAllColors.dismiss();
                    break;
                }
                case R.id.color18:
                {
                    switch (positionNumber)
                    {
                        case 0:
                        {
                            sharedPraferanceForSavingColors.saveFolderIconColor("#008BBC");
                            colorSettingActivity.setFolderIconImageColor("#008BBC");
                            break;
                        }

                        case 1:
                        {
                            sharedPraferanceForSavingColors.saveFolderPathColor("#008BBC");
                            colorSettingActivity.setFolderPathImageColor("#008BBC");
                            break;
                        }
                        case 2:
                        {
                            sharedPraferanceForSavingColors.saveFolderItemColor("#008BBC");
                            colorSettingActivity.setFolderItemImageColor("#008BBC");
                            break;
                        }
                        case 3:
                        {
                            sharedPraferanceForSavingColors.saveFolderDateTimeInfoColor("#008BBC");
                            colorSettingActivity.setFolderDateTimeImageColor("#008BBC");
                            break;
                        }
                        case 4:
                        {
                            sharedPraferanceForSavingColors.saveFolderTitleColor("#008BBC");
                            colorSettingActivity.setFolderTitleImageColor("#008BBC");
                            break;
                        }
                        case 5:
                        {
                            sharedPraferanceForSavingColors.saveFileTitleColor("#008BBC");
                            colorSettingActivity.setFileTitleImageColor("#008BBC");
                            break;
                        }
                        case 6:
                        {
                            sharedPraferanceForSavingColors.saveFileSizeColor("#008BBC");
                            colorSettingActivity.setFileSizeImageColor("#008BBC");
                            break;
                        }
                        case 7:
                        {
                            sharedPraferanceForSavingColors.saveFileDateTimeInfoColor("#008BBC");
                            colorSettingActivity.setFileDateTimeImageColor("#008BBC");
                            break;
                        }
                    }
                    Toast.makeText(getContext(), "Color is Set", Toast.LENGTH_SHORT).show();
                    alertDialogForAllColors.dismiss();
                    break;
                }
                case R.id.color19:
                {
                    switch (positionNumber)
                    {
                        case 0:
                        {
                            sharedPraferanceForSavingColors.saveFolderIconColor("#9C27B0");
                            colorSettingActivity.setFolderIconImageColor("#9C27B0");
                            break;
                        }

                        case 1:
                        {
                            sharedPraferanceForSavingColors.saveFolderPathColor("#9C27B0");
                            colorSettingActivity.setFolderPathImageColor("#9C27B0");
                            break;
                        }
                        case 2:
                        {
                            sharedPraferanceForSavingColors.saveFolderItemColor("#9C27B0");
                            colorSettingActivity.setFolderItemImageColor("#9C27B0");
                            break;
                        }
                        case 3:
                        {
                            sharedPraferanceForSavingColors.saveFolderDateTimeInfoColor("#9C27B0");
                            colorSettingActivity.setFolderDateTimeImageColor("#9C27B0");
                            break;
                        }
                        case 4:
                        {
                            sharedPraferanceForSavingColors.saveFolderTitleColor("#9C27B0");
                            colorSettingActivity.setFolderTitleImageColor("#9C27B0");
                            break;
                        }
                        case 5:
                        {
                            sharedPraferanceForSavingColors.saveFileTitleColor("#9C27B0");
                            colorSettingActivity.setFileTitleImageColor("#9C27B0");
                            break;
                        }
                        case 6:
                        {
                            sharedPraferanceForSavingColors.saveFileSizeColor("#9C27B0");
                            colorSettingActivity.setFileSizeImageColor("#9C27B0");
                            break;
                        }
                        case 7:
                        {
                            sharedPraferanceForSavingColors.saveFileDateTimeInfoColor("#9C27B0");
                            colorSettingActivity.setFileDateTimeImageColor("#9C27B0");
                            break;
                        }
                    }
                    Toast.makeText(getContext(), "Color is Set", Toast.LENGTH_SHORT).show();
                    alertDialogForAllColors.dismiss();
                    break;
                }
                case R.id.color20:
                {
                    switch (positionNumber)
                    {
                        case 0:
                        {
                            sharedPraferanceForSavingColors.saveFolderIconColor("#880E4F");
                            colorSettingActivity.setFolderIconImageColor("#880E4F");
                            break;
                        }

                        case 1:
                        {
                            sharedPraferanceForSavingColors.saveFolderPathColor("#880E4F");
                            colorSettingActivity.setFolderPathImageColor("#880E4F");
                            break;
                        }
                        case 2:
                        {
                            sharedPraferanceForSavingColors.saveFolderItemColor("#880E4F");
                            colorSettingActivity.setFolderItemImageColor("#880E4F");
                            break;
                        }
                        case 3:
                        {
                            sharedPraferanceForSavingColors.saveFolderDateTimeInfoColor("#880E4F");
                            colorSettingActivity.setFolderDateTimeImageColor("#880E4F");
                            break;
                        }
                        case 4:
                        {
                            sharedPraferanceForSavingColors.saveFolderTitleColor("#880E4F");
                            colorSettingActivity.setFolderTitleImageColor("#880E4F");
                            break;
                        }
                        case 5:
                        {
                            sharedPraferanceForSavingColors.saveFileTitleColor("#880E4F");
                            colorSettingActivity.setFileTitleImageColor("#880E4F");
                            break;
                        }
                        case 6:
                        {
                            sharedPraferanceForSavingColors.saveFileSizeColor("#880E4F");
                            colorSettingActivity.setFileSizeImageColor("#880E4F");
                            break;
                        }
                        case 7:
                        {
                            sharedPraferanceForSavingColors.saveFileDateTimeInfoColor("#880E4F");
                            colorSettingActivity.setFileDateTimeImageColor("#880E4F");
                            break;
                        }
                    }
                    Toast.makeText(getContext(), "Color is Set", Toast.LENGTH_SHORT).show();
                    alertDialogForAllColors.dismiss();
                    break;
                }
                case R.id.color21:
                {
                    switch (positionNumber)
                    {
                        case 0:
                        {
                            sharedPraferanceForSavingColors.saveFolderIconColor("#536DFE");
                            colorSettingActivity.setFolderIconImageColor("#536DFE");
                            break;
                        }

                        case 1:
                        {
                            sharedPraferanceForSavingColors.saveFolderPathColor("#536DFE");
                            colorSettingActivity.setFolderPathImageColor("#536DFE");
                            break;
                        }
                        case 2:
                        {
                            sharedPraferanceForSavingColors.saveFolderItemColor("#536DFE");
                            colorSettingActivity.setFolderItemImageColor("#536DFE");
                            break;
                        }
                        case 3:
                        {
                            sharedPraferanceForSavingColors.saveFolderDateTimeInfoColor("#536DFE");
                            colorSettingActivity.setFolderDateTimeImageColor("#536DFE");
                            break;
                        }
                        case 4:
                        {
                            sharedPraferanceForSavingColors.saveFolderTitleColor("#536DFE");
                            colorSettingActivity.setFolderTitleImageColor("#536DFE");
                            break;
                        }
                        case 5:
                        {
                            sharedPraferanceForSavingColors.saveFileTitleColor("#536DFE");
                            colorSettingActivity.setFileTitleImageColor("#536DFE");
                            break;
                        }
                        case 6:
                        {
                            sharedPraferanceForSavingColors.saveFileSizeColor("#536DFE");
                            colorSettingActivity.setFileSizeImageColor("#536DFE");
                            break;
                        }
                        case 7:
                        {
                            sharedPraferanceForSavingColors.saveFileDateTimeInfoColor("#536DFE");
                            colorSettingActivity.setFileDateTimeImageColor("#536DFE");
                            break;
                        }
                    }
                    Toast.makeText(getContext(), "Color is Set", Toast.LENGTH_SHORT).show();
                    alertDialogForAllColors.dismiss();
                    break;
                }
                case R.id.color22:
                {
                    switch (positionNumber)
                    {
                        case 0:
                        {
                            sharedPraferanceForSavingColors.saveFolderIconColor("#A4C639");
                            colorSettingActivity.setFolderIconImageColor("#A4C639");
                            break;
                        }

                        case 1:
                        {
                            sharedPraferanceForSavingColors.saveFolderPathColor("#A4C639");
                            colorSettingActivity.setFolderPathImageColor("#A4C639");
                            break;
                        }
                        case 2:
                        {
                            sharedPraferanceForSavingColors.saveFolderItemColor("#A4C639");
                            colorSettingActivity.setFolderItemImageColor("#A4C639");
                            break;
                        }
                        case 3:
                        {
                            sharedPraferanceForSavingColors.saveFolderDateTimeInfoColor("#A4C639");
                            colorSettingActivity.setFolderDateTimeImageColor("#A4C639");
                            break;
                        }
                        case 4:
                        {
                            sharedPraferanceForSavingColors.saveFolderTitleColor("#A4C639");
                            colorSettingActivity.setFolderTitleImageColor("#A4C639");
                            break;
                        }
                        case 5:
                        {
                            sharedPraferanceForSavingColors.saveFileTitleColor("#A4C639");
                            colorSettingActivity.setFileTitleImageColor("#A4C639");
                            break;
                        }
                        case 6:
                        {
                            sharedPraferanceForSavingColors.saveFileSizeColor("#A4C639");
                            colorSettingActivity.setFileSizeImageColor("#A4C639");
                            break;
                        }
                        case 7:
                        {
                            sharedPraferanceForSavingColors.saveFileDateTimeInfoColor("#A4C639");
                            colorSettingActivity.setFileDateTimeImageColor("#A4C639");
                            break;
                        }
                    }
                    Toast.makeText(getContext(), "Color is Set", Toast.LENGTH_SHORT).show();
                    alertDialogForAllColors.dismiss();
                    break;
                }
                case R.id.color23:
                {
                    switch (positionNumber)
                    {
                        case 0:
                        {
                            sharedPraferanceForSavingColors.saveFolderIconColor("#FFC0CB");
                            colorSettingActivity.setFolderIconImageColor("#FFC0CB");
                            break;
                        }

                        case 1:
                        {
                            sharedPraferanceForSavingColors.saveFolderPathColor("#FFC0CB");
                            colorSettingActivity.setFolderPathImageColor("#FFC0CB");
                            break;
                        }
                        case 2:
                        {
                            sharedPraferanceForSavingColors.saveFolderItemColor("#FFC0CB");
                            colorSettingActivity.setFolderItemImageColor("#FFC0CB");
                            break;
                        }
                        case 3:
                        {
                            sharedPraferanceForSavingColors.saveFolderDateTimeInfoColor("#FFC0CB");
                            colorSettingActivity.setFolderDateTimeImageColor("#FFC0CB");
                            break;
                        }
                        case 4:
                        {
                            sharedPraferanceForSavingColors.saveFolderTitleColor("#FFC0CB");
                            colorSettingActivity.setFolderTitleImageColor("#FFC0CB");
                            break;
                        }
                        case 5:
                        {
                            sharedPraferanceForSavingColors.saveFileTitleColor("#FFC0CB");
                            colorSettingActivity.setFileTitleImageColor("#FFC0CB");
                            break;
                        }
                        case 6:
                        {
                            sharedPraferanceForSavingColors.saveFileSizeColor("#FFC0CB");
                            colorSettingActivity.setFileSizeImageColor("#FFC0CB");
                            break;
                        }
                        case 7:
                        {
                            sharedPraferanceForSavingColors.saveFileDateTimeInfoColor("#FFC0CB");
                            colorSettingActivity.setFileDateTimeImageColor("#FFC0CB");
                            break;
                        }
                    }
                    Toast.makeText(getContext(), "Color is Set", Toast.LENGTH_SHORT).show();
                    alertDialogForAllColors.dismiss();
                    break;
                }
                case R.id.color24:
                {
                    switch (positionNumber)
                    {
                        case 0:
                        {
                            sharedPraferanceForSavingColors.saveFolderIconColor("#6D4C41");
                            colorSettingActivity.setFolderIconImageColor("#6D4C41");
                            break;
                        }

                        case 1:
                        {
                            sharedPraferanceForSavingColors.saveFolderPathColor("#6D4C41");
                            colorSettingActivity.setFolderPathImageColor("#6D4C41");
                            break;
                        }
                        case 2:
                        {
                            sharedPraferanceForSavingColors.saveFolderItemColor("#6D4C41");
                            colorSettingActivity.setFolderItemImageColor("#6D4C41");
                            break;
                        }
                        case 3:
                        {
                            sharedPraferanceForSavingColors.saveFolderDateTimeInfoColor("#6D4C41");
                            colorSettingActivity.setFolderDateTimeImageColor("#6D4C41");
                            break;
                        }
                        case 4:
                        {
                            sharedPraferanceForSavingColors.saveFolderTitleColor("#6D4C41");
                            colorSettingActivity.setFolderTitleImageColor("#6D4C41");
                            break;
                        }
                        case 5:
                        {
                            sharedPraferanceForSavingColors.saveFileTitleColor("#6D4C41");
                            colorSettingActivity.setFileTitleImageColor("#6D4C41");
                            break;
                        }
                        case 6:
                        {
                            sharedPraferanceForSavingColors.saveFileSizeColor("#6D4C41");
                            colorSettingActivity.setFileSizeImageColor("#6D4C41");
                            break;
                        }
                        case 7:
                        {
                            sharedPraferanceForSavingColors.saveFileDateTimeInfoColor("#6D4C41");
                            colorSettingActivity.setFileDateTimeImageColor("#6D4C41");
                            break;
                        }
                    }
                    Toast.makeText(getContext(), "Color is Set", Toast.LENGTH_SHORT).show();
                    alertDialogForAllColors.dismiss();
                    break;
                }
                case R.id.color25:
                {
                    switch (positionNumber)
                    {
                        case 0:
                        {
                            sharedPraferanceForSavingColors.saveFolderIconColor("#546E7A");
                            colorSettingActivity.setFolderIconImageColor("#546E7A");
                            break;
                        }

                        case 1:
                        {
                            sharedPraferanceForSavingColors.saveFolderPathColor("#546E7A");
                            colorSettingActivity.setFolderPathImageColor("#546E7A");
                            break;
                        }
                        case 2:
                        {
                            sharedPraferanceForSavingColors.saveFolderItemColor("#546E7A");
                            colorSettingActivity.setFolderItemImageColor("#546E7A");
                            break;
                        }
                        case 3:
                        {
                            sharedPraferanceForSavingColors.saveFolderDateTimeInfoColor("#546E7A");
                            colorSettingActivity.setFolderDateTimeImageColor("#546E7A");
                            break;
                        }
                        case 4:
                        {
                            sharedPraferanceForSavingColors.saveFolderTitleColor("#546E7A");
                            colorSettingActivity.setFolderTitleImageColor("#546E7A");
                            break;
                        }
                        case 5:
                        {
                            sharedPraferanceForSavingColors.saveFileTitleColor("#546E7A");
                            colorSettingActivity.setFileTitleImageColor("#546E7A");
                            break;
                        }
                        case 6:
                        {
                            sharedPraferanceForSavingColors.saveFileSizeColor("#546E7A");
                            colorSettingActivity.setFileSizeImageColor("#546E7A");
                            break;
                        }
                        case 7:
                        {
                            sharedPraferanceForSavingColors.saveFileDateTimeInfoColor("#546E7A");
                            colorSettingActivity.setFileDateTimeImageColor("#546E7A");
                            break;
                        }
                    }
                    Toast.makeText(getContext(), "Color is Set", Toast.LENGTH_SHORT).show();
                    alertDialogForAllColors.dismiss();
                    break;
                }
                case R.id.color26:
                {
                    switch (positionNumber)
                    {
                        case 0:
                        {
                            sharedPraferanceForSavingColors.saveFolderIconColor("#000000");
                            colorSettingActivity.setFolderIconImageColor("#000000");
                            break;
                        }

                        case 1:
                        {
                            sharedPraferanceForSavingColors.saveFolderPathColor("#000000");
                            colorSettingActivity.setFolderPathImageColor("#000000");
                            break;
                        }
                        case 2:
                        {
                            sharedPraferanceForSavingColors.saveFolderItemColor("#000000");
                            colorSettingActivity.setFolderItemImageColor("#000000");
                            break;
                        }
                        case 3:
                        {
                            sharedPraferanceForSavingColors.saveFolderDateTimeInfoColor("#000000");
                            colorSettingActivity.setFolderDateTimeImageColor("#000000");
                            break;
                        }
                        case 4:
                        {
                            sharedPraferanceForSavingColors.saveFolderTitleColor("#000000");
                            colorSettingActivity.setFolderTitleImageColor("#000000");
                            break;
                        }
                        case 5:
                        {
                            sharedPraferanceForSavingColors.saveFileTitleColor("#000000");
                            colorSettingActivity.setFileTitleImageColor("#000000");
                            break;
                        }
                        case 6:
                        {
                            sharedPraferanceForSavingColors.saveFileSizeColor("#000000");
                            colorSettingActivity.setFileSizeImageColor("#000000");
                            break;
                        }
                        case 7:
                        {
                            sharedPraferanceForSavingColors.saveFileDateTimeInfoColor("#000000");
                            colorSettingActivity.setFileDateTimeImageColor("#000000");
                            break;
                        }
                    }
                    Toast.makeText(getContext(), "Color is Set", Toast.LENGTH_SHORT).show();
                    alertDialogForAllColors.dismiss();
                    break;
                }
                case R.id.color27:
                {
                    switch (positionNumber)
                    {
                        case 0:
                        {
                            sharedPraferanceForSavingColors.saveFolderIconColor("#424242");
                            colorSettingActivity.setFolderIconImageColor("#424242");
                            break;
                        }

                        case 1:
                        {
                            sharedPraferanceForSavingColors.saveFolderPathColor("#424242");
                            colorSettingActivity.setFolderPathImageColor("#424242");
                            break;
                        }
                        case 2:
                        {
                            sharedPraferanceForSavingColors.saveFolderItemColor("#424242");
                            colorSettingActivity.setFolderItemImageColor("#424242");
                            break;
                        }
                        case 3:
                        {
                            sharedPraferanceForSavingColors.saveFolderDateTimeInfoColor("#424242");
                            colorSettingActivity.setFolderDateTimeImageColor("#424242");
                            break;
                        }
                        case 4:
                        {
                            sharedPraferanceForSavingColors.saveFolderTitleColor("#424242");
                            colorSettingActivity.setFolderTitleImageColor("#424242");
                            break;
                        }
                        case 5:
                        {
                            sharedPraferanceForSavingColors.saveFileTitleColor("#424242");
                            colorSettingActivity.setFileTitleImageColor("#424242");
                            break;
                        }
                        case 6:
                        {
                            sharedPraferanceForSavingColors.saveFileSizeColor("#424242");
                            colorSettingActivity.setFileSizeImageColor("#424242");
                            break;
                        }
                        case 7:
                        {
                            sharedPraferanceForSavingColors.saveFileDateTimeInfoColor("#424242");
                            colorSettingActivity.setFileDateTimeImageColor("#424242");
                            break;
                        }
                    }
                    Toast.makeText(getContext(), "Color is Set", Toast.LENGTH_SHORT).show();
                    alertDialogForAllColors.dismiss();
                    break;
                }
                case R.id.color28:
                {
                    switch (positionNumber)
                    {
                        case 0:
                        {
                            sharedPraferanceForSavingColors.saveFolderIconColor("#757575");
                            colorSettingActivity.setFolderIconImageColor("#757575");
                            break;
                        }

                        case 1:
                        {
                            sharedPraferanceForSavingColors.saveFolderPathColor("#757575");
                            colorSettingActivity.setFolderPathImageColor("#757575");
                            break;
                        }
                        case 2:
                        {
                            sharedPraferanceForSavingColors.saveFolderItemColor("#757575");
                            colorSettingActivity.setFolderItemImageColor("#757575");
                            break;
                        }
                        case 3:
                        {
                            sharedPraferanceForSavingColors.saveFolderDateTimeInfoColor("#757575");
                            colorSettingActivity.setFolderDateTimeImageColor("#757575");
                            break;
                        }
                        case 4:
                        {
                            sharedPraferanceForSavingColors.saveFolderTitleColor("#757575");
                            colorSettingActivity.setFolderTitleImageColor("#757575");
                            break;
                        }
                        case 5:
                        {
                            sharedPraferanceForSavingColors.saveFileTitleColor("#757575");
                            colorSettingActivity.setFileTitleImageColor("#757575");
                            break;
                        }
                        case 6:
                        {
                            sharedPraferanceForSavingColors.saveFileSizeColor("#757575");
                            colorSettingActivity.setFileSizeImageColor("#757575");
                            break;
                        }
                        case 7:
                        {
                            sharedPraferanceForSavingColors.saveFileDateTimeInfoColor("#757575");
                            colorSettingActivity.setFileDateTimeImageColor("#757575");
                            break;
                        }
                    }
                    Toast.makeText(getContext(), "Color is Set", Toast.LENGTH_SHORT).show();
                    alertDialogForAllColors.dismiss();
                    break;
                }
                case R.id.color29:
                {
                    switch (positionNumber)
                    {
                        case 0:
                        {
                            sharedPraferanceForSavingColors.saveFolderIconColor("#BDBDBD");
                            colorSettingActivity.setFolderIconImageColor("#BDBDBD");
                            break;
                        }

                        case 1:
                        {
                            sharedPraferanceForSavingColors.saveFolderPathColor("#BDBDBD");
                            colorSettingActivity.setFolderPathImageColor("#BDBDBD");
                            break;
                        }
                        case 2:
                        {
                            sharedPraferanceForSavingColors.saveFolderItemColor("#BDBDBD");
                            colorSettingActivity.setFolderItemImageColor("#BDBDBD");
                            break;
                        }
                        case 3:
                        {
                            sharedPraferanceForSavingColors.saveFolderDateTimeInfoColor("#BDBDBD");
                            colorSettingActivity.setFolderDateTimeImageColor("#BDBDBD");
                            break;
                        }
                        case 4:
                        {
                            sharedPraferanceForSavingColors.saveFolderTitleColor("#BDBDBD");
                            colorSettingActivity.setFolderTitleImageColor("#BDBDBD");
                            break;
                        }
                        case 5:
                        {
                            sharedPraferanceForSavingColors.saveFileTitleColor("#BDBDBD");
                            colorSettingActivity.setFileTitleImageColor("#BDBDBD");
                            break;
                        }
                        case 6:
                        {
                            sharedPraferanceForSavingColors.saveFileSizeColor("#BDBDBD");
                            colorSettingActivity.setFileSizeImageColor("#BDBDBD");
                            break;
                        }
                        case 7:
                        {
                            sharedPraferanceForSavingColors.saveFileDateTimeInfoColor("#BDBDBD");
                            colorSettingActivity.setFileDateTimeImageColor("#BDBDBD");
                            break;
                        }
                    }
                    Toast.makeText(getContext(), "Color is Set", Toast.LENGTH_SHORT).show();
                    alertDialogForAllColors.dismiss();
                    break;
                }
                case R.id.color30:
                {
                    switch (positionNumber)
                    {
                        case 0:
                        {
                            sharedPraferanceForSavingColors.saveFolderIconColor("#E0E0E0");
                            colorSettingActivity.setFolderIconImageColor("#E0E0E0");
                            break;
                        }

                        case 1:
                        {
                            sharedPraferanceForSavingColors.saveFolderPathColor("#E0E0E0");
                            colorSettingActivity.setFolderPathImageColor("#E0E0E0");
                            break;
                        }
                        case 2:
                        {
                            sharedPraferanceForSavingColors.saveFolderItemColor("#E0E0E0");
                            colorSettingActivity.setFolderItemImageColor("#E0E0E0");
                            break;
                        }
                        case 3:
                        {
                            sharedPraferanceForSavingColors.saveFolderDateTimeInfoColor("#E0E0E0");
                            colorSettingActivity.setFolderDateTimeImageColor("#E0E0E0");
                            break;
                        }
                        case 4:
                        {
                            sharedPraferanceForSavingColors.saveFolderTitleColor("#E0E0E0");
                            colorSettingActivity.setFolderTitleImageColor("#E0E0E0");
                            break;
                        }
                        case 5:
                        {
                            sharedPraferanceForSavingColors.saveFileTitleColor("#E0E0E0");
                            colorSettingActivity.setFileTitleImageColor("#E0E0E0");
                            break;
                        }
                        case 6:
                        {
                            sharedPraferanceForSavingColors.saveFileSizeColor("#E0E0E0");
                            colorSettingActivity.setFileSizeImageColor("#E0E0E0");
                            break;
                        }
                        case 7:
                        {
                            sharedPraferanceForSavingColors.saveFileDateTimeInfoColor("#E0E0E0");
                            colorSettingActivity.setFileDateTimeImageColor("#E0E0E0");
                            break;
                        }
                    }
                    Toast.makeText(getContext(), "Color is Set", Toast.LENGTH_SHORT).show();
                    alertDialogForAllColors.dismiss();
                    break;
                }
                case R.id.color31:
                {
                    switch (positionNumber)
                    {
                        case 0:
                        {
                            sharedPraferanceForSavingColors.saveFolderIconColor("#663399");
                            colorSettingActivity.setFolderIconImageColor("#663399");
                            break;
                        }

                        case 1:
                        {
                            sharedPraferanceForSavingColors.saveFolderPathColor("#663399");
                            colorSettingActivity.setFolderPathImageColor("#663399");
                            break;
                        }
                        case 2:
                        {
                            sharedPraferanceForSavingColors.saveFolderItemColor("#663399");
                            colorSettingActivity.setFolderItemImageColor("#663399");
                            break;
                        }
                        case 3:
                        {
                            sharedPraferanceForSavingColors.saveFolderDateTimeInfoColor("#663399");
                            colorSettingActivity.setFolderDateTimeImageColor("#663399");
                            break;
                        }
                        case 4:
                        {
                            sharedPraferanceForSavingColors.saveFolderTitleColor("#663399");
                            colorSettingActivity.setFolderTitleImageColor("#663399");
                            break;
                        }
                        case 5:
                        {
                            sharedPraferanceForSavingColors.saveFileTitleColor("#663399");
                            colorSettingActivity.setFileTitleImageColor("#663399");
                            break;
                        }
                        case 6:
                        {
                            sharedPraferanceForSavingColors.saveFileSizeColor("#663399");
                            colorSettingActivity.setFileSizeImageColor("#663399");
                            break;
                        }
                        case 7:
                        {
                            sharedPraferanceForSavingColors.saveFileDateTimeInfoColor("#663399");
                            colorSettingActivity.setFileDateTimeImageColor("#663399");
                            break;
                        }
                    }
                    Toast.makeText(getContext(), "Color is Set", Toast.LENGTH_SHORT).show();
                    alertDialogForAllColors.dismiss();
                    break;
                }

                case R.id.color32:
                {
                    switch (positionNumber)
                    {
                        case 0:
                        {
                            sharedPraferanceForSavingColors.saveFolderIconColor("#F57F17");
                            colorSettingActivity.setFolderIconImageColor("#F57F17");
                            break;
                        }

                        case 1:
                        {
                            sharedPraferanceForSavingColors.saveFolderPathColor("#F57F17");
                            colorSettingActivity.setFolderPathImageColor("#F57F17");
                            break;
                        }
                        case 2:
                        {
                            sharedPraferanceForSavingColors.saveFolderItemColor("#F57F17");
                            colorSettingActivity.setFolderItemImageColor("#F57F17");
                            break;
                        }
                        case 3:
                        {
                            sharedPraferanceForSavingColors.saveFolderDateTimeInfoColor("#F57F17");
                            colorSettingActivity.setFolderDateTimeImageColor("#F57F17");
                            break;
                        }
                        case 4:
                        {
                            sharedPraferanceForSavingColors.saveFolderTitleColor("#F57F17");
                            colorSettingActivity.setFolderTitleImageColor("#F57F17");
                            break;
                        }
                        case 5:
                        {
                            sharedPraferanceForSavingColors.saveFileTitleColor("#F57F17");
                            colorSettingActivity.setFileTitleImageColor("#F57F17");
                            break;
                        }
                        case 6:
                        {
                            sharedPraferanceForSavingColors.saveFileSizeColor("#F57F17");
                            colorSettingActivity.setFileSizeImageColor("#F57F17");
                            break;
                        }
                        case 7:
                        {
                            sharedPraferanceForSavingColors.saveFileDateTimeInfoColor("#F57F17");
                            colorSettingActivity.setFileDateTimeImageColor("#F57F17");
                            break;
                        }
                    }
                    Toast.makeText(getContext(), "Color is Set", Toast.LENGTH_SHORT).show();
                    alertDialogForAllColors.dismiss();
                    break;
                }
                case R.id.color33:
                {
                    switch (positionNumber)
                    {
                        case 0:
                        {
                            sharedPraferanceForSavingColors.saveFolderIconColor("#98DF8A");
                            colorSettingActivity.setFolderIconImageColor("#98DF8A");
                            break;
                        }

                        case 1:
                        {
                            sharedPraferanceForSavingColors.saveFolderPathColor("#98DF8A");
                            colorSettingActivity.setFolderPathImageColor("#98DF8A");
                            break;
                        }
                        case 2:
                        {
                            sharedPraferanceForSavingColors.saveFolderItemColor("#98DF8A");
                            colorSettingActivity.setFolderItemImageColor("#98DF8A");
                            break;
                        }
                        case 3:
                        {
                            sharedPraferanceForSavingColors.saveFolderDateTimeInfoColor("#98DF8A");
                            colorSettingActivity.setFolderDateTimeImageColor("#98DF8A");
                            break;
                        }
                        case 4:
                        {
                            sharedPraferanceForSavingColors.saveFolderTitleColor("#98DF8A");
                            colorSettingActivity.setFolderTitleImageColor("#98DF8A");
                            break;
                        }
                        case 5:
                        {
                            sharedPraferanceForSavingColors.saveFileTitleColor("#98DF8A");
                            colorSettingActivity.setFileTitleImageColor("#98DF8A");
                            break;
                        }
                        case 6:
                        {
                            sharedPraferanceForSavingColors.saveFileSizeColor("#98DF8A");
                            colorSettingActivity.setFileSizeImageColor("#98DF8A");
                            break;
                        }
                        case 7:
                        {
                            sharedPraferanceForSavingColors.saveFileDateTimeInfoColor("#98DF8A");
                            colorSettingActivity.setFileDateTimeImageColor("#98DF8A");
                            break;
                        }
                    }
                    Toast.makeText(getContext(), "Color is Set", Toast.LENGTH_SHORT).show();
                    alertDialogForAllColors.dismiss();
                    break;
                }
                case R.id.color34:
                {
                    switch (positionNumber)
                    {
                        case 0:
                        {
                            sharedPraferanceForSavingColors.saveFolderIconColor("#957A81");
                            colorSettingActivity.setFolderIconImageColor("#957A81");
                            break;
                        }

                        case 1:
                        {
                            sharedPraferanceForSavingColors.saveFolderPathColor("#957A81");
                            colorSettingActivity.setFolderPathImageColor("#957A81");
                            break;
                        }
                        case 2:
                        {
                            sharedPraferanceForSavingColors.saveFolderItemColor("#957A81");
                            colorSettingActivity.setFolderItemImageColor("#957A81");
                            break;
                        }
                        case 3:
                        {
                            sharedPraferanceForSavingColors.saveFolderDateTimeInfoColor("#957A81");
                            colorSettingActivity.setFolderDateTimeImageColor("#957A81");
                            break;
                        }
                        case 4:
                        {
                            sharedPraferanceForSavingColors.saveFolderTitleColor("#957A81");
                            colorSettingActivity.setFolderTitleImageColor("#957A81");
                            break;
                        }
                        case 5:
                        {
                            sharedPraferanceForSavingColors.saveFileTitleColor("#957A81");
                            colorSettingActivity.setFileTitleImageColor("#957A81");
                            break;
                        }
                        case 6:
                        {
                            sharedPraferanceForSavingColors.saveFileSizeColor("#957A81");
                            colorSettingActivity.setFileSizeImageColor("#957A81");
                            break;
                        }
                        case 7:
                        {
                            sharedPraferanceForSavingColors.saveFileDateTimeInfoColor("#957A81");
                            colorSettingActivity.setFileDateTimeImageColor("#957A81");
                            break;
                        }
                    }
                    Toast.makeText(getContext(), "Color is Set", Toast.LENGTH_SHORT).show();
                    alertDialogForAllColors.dismiss();
                    break;
                }

                case R.id.color35:
                {
                    switch (positionNumber)
                    {
                        case 0:
                        {
                            sharedPraferanceForSavingColors.saveFolderIconColor("#32CD32");
                            colorSettingActivity.setFolderIconImageColor("#32CD32");
                            break;
                        }

                        case 1:
                        {
                            sharedPraferanceForSavingColors.saveFolderPathColor("#32CD32");
                            colorSettingActivity.setFolderPathImageColor("#32CD32");
                            break;
                        }
                        case 2:
                        {
                            sharedPraferanceForSavingColors.saveFolderItemColor("#32CD32");
                            colorSettingActivity.setFolderItemImageColor("#32CD32");
                            break;
                        }
                        case 3:
                        {
                            sharedPraferanceForSavingColors.saveFolderDateTimeInfoColor("#32CD32");
                            colorSettingActivity.setFolderDateTimeImageColor("#32CD32");
                            break;
                        }
                        case 4:
                        {
                            sharedPraferanceForSavingColors.saveFolderTitleColor("#32CD32");
                            colorSettingActivity.setFolderTitleImageColor("#32CD32");
                            break;
                        }
                        case 5:
                        {
                            sharedPraferanceForSavingColors.saveFileTitleColor("#32CD32");
                            colorSettingActivity.setFileTitleImageColor("#32CD32");
                            break;
                        }
                        case 6:
                        {
                            sharedPraferanceForSavingColors.saveFileSizeColor("#32CD32");
                            colorSettingActivity.setFileSizeImageColor("#32CD32");
                            break;
                        }
                        case 7:
                        {
                            sharedPraferanceForSavingColors.saveFileDateTimeInfoColor("#32CD32");
                            colorSettingActivity.setFileDateTimeImageColor("#32CD32");
                            break;
                        }
                    }
                    Toast.makeText(getContext(), "Color is Set", Toast.LENGTH_SHORT).show();
                    alertDialogForAllColors.dismiss();
                    break;
                }
            }
        }
    }








    public void setAlertDialogForAllColorsObject(AlertDialogForAllColors alertDialogForAllColorsObject)
    {
        this.alertDialogForAllColors=alertDialogForAllColorsObject;
    }
}
