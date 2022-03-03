package com.nisith.keypaddesign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    private FrameLayout frameLayout;
    private EditText editText;
    private Button buttonOne,buttonZero,buttonCross,buttonPoint;

//    private AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.binary_number_keypad_layout);
        frameLayout = findViewById(R.id.frame_layout);
        buttonOne = findViewById(R.id.button_one);
        buttonZero = findViewById(R.id.button_zero);
        buttonCross = findViewById(R.id.button_cross);
        buttonPoint = findViewById(R.id.button_point);
        editText = findViewById(R.id.edit_text);

        ////adMob///
//        MobileAds.initialize(this,"ca-app-pub-3940256099942544~3347511713");
//        adView = findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        adView.loadAd(adRequest);
















        ////adMob/////



















//        editText.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                editText.getText().insert(editText.getSelectionStart()," x ");
//                Log.d("ABCDE","getSelectionStart = "+editText.getSelectionStart());
//                Log.d("ABCDE","getSelectionEnd = "+editText.getSelectionEnd());
//            }
//        });

        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.getText().insert(editText.getSelectionStart(),"1");
            }
        });

        buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.getText().insert(editText.getSelectionStart(),"0");
            }
        });

        buttonCross.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Toast.makeText(MainActivity.this, "Cross Button Click", Toast.LENGTH_SHORT).show();
//                String text = editText.getText().toString();
                int currentCurserPosition = editText.getSelectionStart();
                if (currentCurserPosition > 0){
                    Toast.makeText(MainActivity.this, "Condition is true", Toast.LENGTH_SHORT).show();
                    editText.getText().replace(editText.getSelectionStart()-1,editText.getSelectionStart(),"");
                }

            }

        });

        buttonPoint.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                String text = editText.getText().toString();
                if (!text.contains(".")){
                    editText.getText().insert(editText.getSelectionStart(),".");
                }
            }

        });

    }
}
