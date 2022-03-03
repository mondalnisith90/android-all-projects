package com.music.audioplayer;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MyFolderDialog extends AppCompatDialogFragment {
    private RadioButton radioButton1,radioButton2;
    private RadioGroup radioGroup;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.folder_setting_radio_button,null);
        radioGroup=view.findViewById(R.id.radio_group);
        radioButton1=view.findViewById(R.id.radio_button1);
        radioButton2=view.findViewById(R.id.radio_button2);
        sharedPreferences=getActivity().getSharedPreferences("folder_view_setting", Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
        if (sharedPreferences.getBoolean("radio1_isChecked",true))
        {
            radioButton1.setChecked(true);
            radioButton2.setChecked(false);
        }
        else
        {
            radioButton1.setChecked(false);
            radioButton2.setChecked(true);
        }

        builder.setTitle("Folder View Setting")
                .setView(view)
                 .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {

                     }
                 })
                 .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {
                         int checkedRadioButtonId=radioGroup.getCheckedRadioButtonId();
                         switch (checkedRadioButtonId)
                         {
                             case R.id.radio_button1:
                             {
                                 editor.putBoolean("radio1_isChecked",true);
                                 editor.putBoolean("radio2_isChecked",false);
                                 editor.commit();
//                                 Log.d("AVB","radio_button1");
                                 break;
                             }
                             case R.id.radio_button2:
                             {
                                 editor.putBoolean("radio2_isChecked",true);
                                 editor.putBoolean("radio1_isChecked",false);
//                                 Log.d("AVB","radio_button2");
                                 editor.commit();
                                 break;
                             }



                         }

                     }
                 });
        return builder.create();
    }
}
