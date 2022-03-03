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
public class AlertDialogForAvailableClassesOfTrain extends AppCompatDialogFragment {

    private ArrayList<Train.TrainClasses> trainClassesInfoArrayList;

    @SuppressLint("ValidFragment")
    public AlertDialogForAvailableClassesOfTrain(ArrayList<Train.TrainClasses> trainClassesInfoArrayList){
        this.trainClassesInfoArrayList = trainClassesInfoArrayList;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.alert_dialog_layout_for_available_classes_info,null);
        TextView classesTV,availableTV,textViewClasses1,textViewClasses2,textViewClasses3,textViewClasses4,textViewClasses5,textViewClasses6,
                textViewClasses7,textViewClasses8,textViewAvailable1,textViewAvailable2,textViewAvailable3,textViewAvailable4,
                textViewAvailable5,textViewAvailable6,textViewAvailable7,textViewAvailable8;
        classesTV = view.findViewById(R.id.classes_tag);
        availableTV = view.findViewById(R.id.available_tag);
        textViewClasses1 = view.findViewById(R.id.text_view_class1);
        textViewClasses2 = view.findViewById(R.id.text_view_class2);
        textViewClasses3 = view.findViewById(R.id.text_view_class3);
        textViewClasses4 = view.findViewById(R.id.text_view_class4);
        textViewClasses5 = view.findViewById(R.id.text_view_class5);
        textViewClasses6 = view.findViewById(R.id.text_view_class6);
        textViewClasses7 = view.findViewById(R.id.text_view_class7);
        textViewClasses8 = view.findViewById(R.id.text_view_class8);
        textViewAvailable1 = view.findViewById(R.id.text_view_available1);
        textViewAvailable2 = view.findViewById(R.id.text_view_available2);
        textViewAvailable3 = view.findViewById(R.id.text_view_available3);
        textViewAvailable4 = view.findViewById(R.id.text_view_available4);
        textViewAvailable5 = view.findViewById(R.id.text_view_available5);
        textViewAvailable6 = view.findViewById(R.id.text_view_available6);
        textViewAvailable7 = view.findViewById(R.id.text_view_available7);
        textViewAvailable8 = view.findViewById(R.id.text_view_available8);
        String temp = trainClassesInfoArrayList.get(0).getIsClassAvailable();
        if (temp.equalsIgnoreCase("YES") || temp.equalsIgnoreCase("NO")) {
            /***** if temp value is "YES" or "NO" means the train is an Express train and in Express train all classes are present
               but for a local train temp value is dash symbol "-"... this represent in local train that classes are not present  *****/
            textViewClasses1.setText(trainClassesInfoArrayList.get(0).getClassName());
            textViewAvailable1.setText(trainClassesInfoArrayList.get(0).getIsClassAvailable());
            textViewClasses2.setText(trainClassesInfoArrayList.get(1).getClassName());
            textViewAvailable2.setText(trainClassesInfoArrayList.get(1).getIsClassAvailable());
            textViewClasses3.setText(trainClassesInfoArrayList.get(2).getClassName());
            textViewAvailable3.setText(trainClassesInfoArrayList.get(2).getIsClassAvailable());
            textViewClasses4.setText(trainClassesInfoArrayList.get(3).getClassName());
            textViewAvailable4.setText(trainClassesInfoArrayList.get(3).getIsClassAvailable());
            textViewClasses5.setText(trainClassesInfoArrayList.get(4).getClassName());
            textViewAvailable5.setText(trainClassesInfoArrayList.get(4).getIsClassAvailable());
            textViewClasses6.setText(trainClassesInfoArrayList.get(5).getClassName());
            textViewAvailable6.setText(trainClassesInfoArrayList.get(5).getIsClassAvailable());
            textViewClasses7.setText(trainClassesInfoArrayList.get(6).getClassName());
            textViewAvailable7.setText(trainClassesInfoArrayList.get(6).getIsClassAvailable());
            textViewClasses8.setText(trainClassesInfoArrayList.get(7).getClassName());
            textViewAvailable8.setText(trainClassesInfoArrayList.get(7).getIsClassAvailable());
        }else {

            //temp value is "-"

            textViewClasses1.setText("This is a Local Train");
            classesTV.setVisibility(View.GONE);
            availableTV.setVisibility(View.GONE);
            textViewClasses2.setVisibility(View.GONE);
            textViewClasses3.setVisibility(View.GONE);
            textViewClasses4.setVisibility(View.GONE);
            textViewClasses5.setVisibility(View.GONE);
            textViewClasses6.setVisibility(View.GONE);
            textViewClasses7.setVisibility(View.GONE);
            textViewClasses8.setVisibility(View.GONE);
            textViewAvailable1.setVisibility(View.GONE);
            textViewAvailable2.setVisibility(View.GONE);
            textViewAvailable3.setVisibility(View.GONE);
            textViewAvailable4.setVisibility(View.GONE);
            textViewAvailable5.setVisibility(View.GONE);
            textViewAvailable6.setVisibility(View.GONE);
            textViewAvailable7.setVisibility(View.GONE);
            textViewAvailable8.setVisibility(View.GONE);

        }

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity())
                .setView(view)
                .setTitle("AVAILABLE CLASSES INFORMATION")
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setCancelable(true);
        return dialogBuilder.create();
    }
}
