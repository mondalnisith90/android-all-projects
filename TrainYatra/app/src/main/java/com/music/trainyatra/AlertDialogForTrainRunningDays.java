package com.music.trainyatra;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

@SuppressLint("ValidFragment")
public class AlertDialogForTrainRunningDays extends AppCompatDialogFragment {

    private ArrayList<Train.TrainRunningDaysInfo> trainRunningDaysInfosArrayList;

    public AlertDialogForTrainRunningDays(ArrayList<Train.TrainRunningDaysInfo> trainRunningDaysInfosArrayList){
        this.trainRunningDaysInfosArrayList = trainRunningDaysInfosArrayList;

    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
         View view = layoutInflater.inflate(R.layout.running_day_layout,null);
        TextView mondayTV,tuesdayTV,wednesdayTV,thursdayTV,fridayTV,saturdayTV,sundayTV;
        mondayTV = view.findViewById(R.id.monday);
        tuesdayTV = view.findViewById(R.id.tuesday);
        wednesdayTV = view.findViewById(R.id.wednesday);
        thursdayTV = view.findViewById(R.id.thursday);
        fridayTV = view.findViewById(R.id.friday);
        saturdayTV = view.findViewById(R.id.saturday);
        sundayTV = view.findViewById(R.id.sunday);
        if (trainRunningDaysInfosArrayList != null) {
            mondayTV.setText(trainRunningDaysInfosArrayList.get(0).getIsTrainRun());
            tuesdayTV.setText(trainRunningDaysInfosArrayList.get(1).getIsTrainRun());
            wednesdayTV.setText(trainRunningDaysInfosArrayList.get(2).getIsTrainRun());
            thursdayTV.setText(trainRunningDaysInfosArrayList.get(3).getIsTrainRun());
            fridayTV.setText(trainRunningDaysInfosArrayList.get(4).getIsTrainRun());
            saturdayTV.setText(trainRunningDaysInfosArrayList.get(5).getIsTrainRun());
            sundayTV.setText(trainRunningDaysInfosArrayList.get(6).getIsTrainRun());
        }

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity())
                .setView(view)
                .setTitle("Running Days of This Train")
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setCancelable(true);




        return dialogBuilder.create();
    }
}
