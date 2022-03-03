package com.music.audioplayer;

import android.annotation.SuppressLint;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.goodiebag.protractorview.ProtractorView;

public class EqualizerActivity extends AppCompatActivity  {

    private TextView spinnerText;
    private Spinner spinner;
    private ImageView destroyActivity;
    private Switch switch1;
    private SeekBar seekBar1,seekBar2,seekBar3,seekBar4,seekBar5;
    private ProtractorView bassBoost,virtualizer;
    private String equalizer[]={"Custom","Normal","Classical","Dance","Flat","Flok","Jazz","Pop","Rock"};

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equalizer);


        spinnerText=findViewById(R.id._equalizer_spinner_text);
        spinner=findViewById(R.id.equalizer_spinner);
        destroyActivity=findViewById(R.id.image_view);
        switch1=findViewById(R.id.equalizer_switch);
        seekBar1=findViewById(R.id.seekbar1);
        seekBar2=findViewById(R.id.seekbar2);
        seekBar3=findViewById(R.id.seekbar3);
        seekBar4=findViewById(R.id.seekbar4);
        seekBar5=findViewById(R.id.seekbar5);
        bassBoost=findViewById(R.id.bass_boost);
        virtualizer=findViewById(R.id.virtualizer);


        destroyActivity.setOnClickListener(new MyOnClickListener());
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this,R.layout.spinner_layout,R.id.spinner_text_view,equalizer);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView textView=view.findViewById(R.id.spinner_text_view);
                spinnerText.setText(textView.getText());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });






        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    switch1.setText("ON");
                }else {
                    switch1.setText("OFF");
                }

            }
        });

    }

    private class MyOnClickListener implements View.OnClickListener
    {
        @Override
        public void onClick(View v) {
            switch (v.getId())
            {



                case R.id.image_view:
                {
                    finish();
                    break;
                }
            }
        }
    }

}
















