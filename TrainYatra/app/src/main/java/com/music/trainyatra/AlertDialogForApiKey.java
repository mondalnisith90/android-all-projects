package com.music.trainyatra;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AlertDialogForApiKey extends AppCompatDialogFragment {

    private MySharedPraferance mySharedPraferance;
    public AlertDialogForApiKey(){}

    @SuppressLint("ValidFragment")
    public AlertDialogForApiKey(MySharedPraferance mySharedPraferance) {
        this.mySharedPraferance = mySharedPraferance;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.alert_dialog_for_api_key_layout,null);
        final EditText editText = view.findViewById(R.id.alert_dialog_text_view);
        if (mySharedPraferance.getData("api_key").length()>0){
            editText.setText(mySharedPraferance.getData("api_key"));
        }

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
        dialogBuilder.setView(view)
                .setTitle("Set API KEY")
                .setPositiveButton("SAVE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                     String editTextValue = editText.getText().toString();
                     if (editTextValue.length()>0) {
                         mySharedPraferance.saveData("api_key", editTextValue);
                         Toast.makeText(getContext(), "Save", Toast.LENGTH_SHORT).show();
                     }
                    }
                })
                .setNegativeButton("CALCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        return dialogBuilder.create();
    }
}
