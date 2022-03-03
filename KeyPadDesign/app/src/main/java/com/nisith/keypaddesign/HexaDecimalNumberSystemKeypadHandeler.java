package com.nisith.keypaddesign;

import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;


public class HexaDecimalNumberSystemKeypadHandeler {
    private Button buttonOne,buttonTwo,buttonThree,buttonFour,buttonFive,buttonSix,buttonSeven,buttonEight,buttonNine,
                   buttonZero,buttonA,buttonB,buttonC,buttonD,buttonE,buttonF,buttonPoint,buttonCross,buttonDone;
    private RelativeLayout buttonKeyPadLayout;
    private View view;
    public HexaDecimalNumberSystemKeypadHandeler(AppCompatActivity appCompatActivity){
        LayoutInflater layoutInflater = appCompatActivity.getLayoutInflater();
        view = layoutInflater.inflate(R.layout.octal_number_keypad_layout,null,false);
        buttonOne = view.findViewById(R.id.button_one);
        buttonTwo = view.findViewById(R.id.button_two);
        buttonThree = view.findViewById(R.id.button_three);
        buttonFour = view.findViewById(R.id.button_four);
        buttonFive = view.findViewById(R.id.button_five);
        buttonSix = view.findViewById(R.id.button_six);
        buttonSeven = view.findViewById(R.id.button_seven);
        buttonEight = view.findViewById(R.id.button_eight);
        buttonNine = view.findViewById(R.id.button_nine);
        buttonZero = view.findViewById(R.id.button_zero);
        buttonA = view.findViewById(R.id.button_a);
        buttonB = view.findViewById(R.id.button_b);
        buttonC = view.findViewById(R.id.button_c);
        buttonD = view.findViewById(R.id.button_d);
        buttonE = view.findViewById(R.id.button_e);
        buttonF = view.findViewById(R.id.button_f);
        buttonPoint = view.findViewById(R.id.button_point);
        buttonCross = view.findViewById(R.id.button_cross);
        buttonDone = view.findViewById(R.id.button_done);
        buttonKeyPadLayout = view.findViewById(R.id.keypad_layout);
        buttonOne.setOnClickListener(new MyKeypadButtonsClick());
        buttonTwo.setOnClickListener(new MyKeypadButtonsClick());
        buttonThree.setOnClickListener(new MyKeypadButtonsClick());
        buttonFour.setOnClickListener(new MyKeypadButtonsClick());
        buttonFive.setOnClickListener(new MyKeypadButtonsClick());
        buttonSix.setOnClickListener(new MyKeypadButtonsClick());
        buttonSeven.setOnClickListener(new MyKeypadButtonsClick());
        buttonEight.setOnClickListener(new MyKeypadButtonsClick());
        buttonNine.setOnClickListener(new MyKeypadButtonsClick());
        buttonZero.setOnClickListener(new MyKeypadButtonsClick());
        buttonA.setOnClickListener(new MyKeypadButtonsClick());
        buttonB.setOnClickListener(new MyKeypadButtonsClick());
        buttonC.setOnClickListener(new MyKeypadButtonsClick());
        buttonD.setOnClickListener(new MyKeypadButtonsClick());
        buttonE.setOnClickListener(new MyKeypadButtonsClick());
        buttonF.setOnClickListener(new MyKeypadButtonsClick());
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
                case R.id.button_two:
//                    Toast.makeText(context, "2", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.button_three:
//                    Toast.makeText(context, "3", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.button_four:
//                    Toast.makeText(context, "4", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.button_five:
//                    Toast.makeText(context, "5", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.button_six:
//                    Toast.makeText(context, "6", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.button_seven:
//                    Toast.makeText(context, "7", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.button_eight:
//                    Toast.makeText(context, "6", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.button_nine:
//                    Toast.makeText(context, "7", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.button_zero:
//                    Toast.makeText(context, "0", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.button_a:
//                    Toast.makeText(context, "5", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.button_b:
//                    Toast.makeText(context, "6", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.button_c:
//                    Toast.makeText(context, "7", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.button_d:
//                    Toast.makeText(context, "5", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.button_e:
//                    Toast.makeText(context, "6", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.button_f:
//                    Toast.makeText(context, "7", Toast.LENGTH_SHORT).show();
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
