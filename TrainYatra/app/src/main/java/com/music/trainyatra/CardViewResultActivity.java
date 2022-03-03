package com.music.trainyatra;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Objects;

public class CardViewResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view_result);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar !=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        TextView merqueTextView,stationNameTV,arriavleTimeTV,depertureTimeTV,distanceTV,haltTV,runningDayTV,sourceStationTV,
        arriavleTimeTagTV,departureTimeTagTV,haltTagTV,runningDayTagTV1,runningDayTagTV2;
        merqueTextView = findViewById(R.id.marque_text);
        stationNameTV = findViewById(R.id.station_name);
        arriavleTimeTV = findViewById(R.id.arriaval_time);
        depertureTimeTV = findViewById(R.id.departure_time);
        distanceTV = findViewById(R.id.distance);
        haltTV = findViewById(R.id.halt_time);
        runningDayTV = findViewById(R.id.running_day);
        sourceStationTV = findViewById(R.id.source_train_name);
        arriavleTimeTagTV = findViewById(R.id.arriaval_time_tag);
        departureTimeTagTV = findViewById(R.id.departure_time_tag);
        haltTagTV = findViewById(R.id.halt_time_tag);
        runningDayTagTV1 = findViewById(R.id.running_day_tag1);
        runningDayTagTV2 = findViewById(R.id.running_day_tag2);
        merqueTextView.setSelected(true);

        Intent intent = getIntent();
        String stationName = intent.getStringExtra("station_name");
        String arriavleTime = intent.getStringExtra("arriavle_time");
        String departureTime = intent.getStringExtra("departure_time");
        String distance = intent.getStringExtra("distance");
        String haltTime = intent.getStringExtra("halt_time");
        String runningDay = intent.getStringExtra("day");
        String sourceStationName = intent.getStringExtra("source_station");
        stationNameTV.setText(stationName);
        arriavleTimeTV.setText(arriavleTime);
        depertureTimeTV.setText(departureTime);
        distanceTV.setText(distance+ " KM");
        haltTV.setText(haltTime+"  Minute");
        runningDayTV.setText("DAY "+runningDay);
        sourceStationTV.setText(sourceStationName);
        if (stationName.equalsIgnoreCase(sourceStationName)){
            //Means current station naem and source station name Both are same
            arriavleTimeTagTV.setVisibility(View.GONE);
            arriavleTimeTV.setVisibility(View.GONE);
            runningDayTagTV1.setVisibility(View.GONE);
            runningDayTagTV2.setVisibility(View.GONE);
            runningDayTV.setVisibility(View.GONE);
            haltTV.setVisibility(View.GONE);
            haltTagTV.setVisibility(View.GONE);
        }



    }
}
