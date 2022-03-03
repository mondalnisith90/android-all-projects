package com.music.audioplayer;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

@SuppressLint("ValidFragment")
public class AlertDialogForTextStyle extends AppCompatDialogFragment {
    private RadioButton italic,bold,normal;
    private RadioGroup radioGroup;
    private SettingActivity settingActivity;
    private SharedPraferenceForTextStyle sharedPraferenceForTextStyle;

    public AlertDialogForTextStyle(SettingActivity settingActivity)
    {
        this.settingActivity=settingActivity;
        this.sharedPraferenceForTextStyle=new SharedPraferenceForTextStyle(settingActivity);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater layoutInflater=getActivity().getLayoutInflater();
        View view=layoutInflater.inflate(R.layout.layout_for_text_style_dialog,null);
        radioGroup=view.findViewById(R.id.radio_group1);
        italic=view.findViewById(R.id.italic);
        bold=view.findViewById(R.id.bold);
        normal=view.findViewById(R.id.normal);
        String textStyleValue=sharedPraferenceForTextStyle.getSavedTextStyleValue();
        if (textStyleValue==null) {
            normal.setChecked(true);

        }else{
            if (textStyleValue.equals("italic"))
            {
                italic.setChecked(true);
            }else if (textStyleValue.equals("bold")){
                bold.setChecked(true);
            }else if (textStyleValue.equals("normal")){
                normal.setChecked(true);
            }
        }
        AlertDialog.Builder dialogBilder=new AlertDialog.Builder(getActivity());
        dialogBilder
                .setView(view)
                .setTitle("Text Style")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int checkedRadioButtonId=radioGroup.getCheckedRadioButtonId();
                        switch (checkedRadioButtonId)
                        {
                            case R.id.italic:
                                sharedPraferenceForTextStyle.saveTextStyleValue("italic");
                                break;
                            case R.id.bold:
                                sharedPraferenceForTextStyle.saveTextStyleValue("bold");
                                break;
                            case R.id.normal:
                                sharedPraferenceForTextStyle.saveTextStyleValue("normal");
                                break;
                        }
                    }
                })
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });



        return dialogBilder.create();
    }
}
