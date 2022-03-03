package com.nisith.keypaddesign;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class BinaryNumberSystemKeypadHandeler {
    private Button buttonOne,buttonZero,buttonPoint,buttonCross,buttonDone;
    private RelativeLayout buttonKeyPadLayout;
    private View view;
    public BinaryNumberSystemKeypadHandeler(AppCompatActivity appCompatActivity){
        LayoutInflater layoutInflater = appCompatActivity.getLayoutInflater();
        view = layoutInflater.inflate(R.layout.octal_number_keypad_layout,null,false);
        buttonOne = view.findViewById(R.id.button_one);
        buttonZero = view.findViewById(R.id.button_zero);
        buttonPoint = view.findViewById(R.id.button_point);
        buttonCross = view.findViewById(R.id.button_cross);
        buttonDone = view.findViewById(R.id.button_done);
        buttonKeyPadLayout = view.findViewById(R.id.keypad_layout);
        buttonOne.setOnClickListener(new MyKeypadButtonsClick());
        buttonZero.setOnClickListener(new MyKeypadButtonsClick());
        buttonPoint.setOnClickListener(new MyKeypadButtonsClick());
        buttonCross.setOnClickListener(new MyKeypadButtonsClick());
        buttonDone.setOnClickListener(new MyKeypadButtonsClick());

    }


    private class MyKeypadButtonsClick implements View.OnClickListener{

        public void onClick(View view){
            switch (view.getId()){

                case R.id.button_one:
//                    Toast.makeText(context, "1", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.button_zero:
//                    Toast.makeText(context, "0", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.button_point:
//                    Toast.makeText(context, ".", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.button_cross:
                    break;
                case R.id.button_done:
                    buttonKeyPadLayout.setVisibility(View.GONE);
                    break;

            }


        }

    }

    public View getView(){
        return view;
    }


    public void closeKeypad(){
        if (buttonKeyPadLayout.getVisibility() == View.VISIBLE){
            buttonKeyPadLayout.setVisibility(View.GONE);
        }
    }

    public void showKeypad(){
            buttonKeyPadLayout.setVisibility(View.VISIBLE);


    }

}
