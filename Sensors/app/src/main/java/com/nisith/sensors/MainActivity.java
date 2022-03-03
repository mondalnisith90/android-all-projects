package com.nisith.sensors;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SensorManager sensorManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        TextView textView = findViewById(R.id.text_view);
        List<Sensor> sensorList = getAllSensorInfo();
        String result = "";
        if (sensorList != null && sensorList.size()>0){
            for (Sensor sensor : sensorList){
                result = result + "Name: "+ sensor.getName() + "  Builder Name: "+sensor.getVendor() + "\n";
            }
            textView.setText(result);
        }
    }

    private List<Sensor> getAllSensorInfo(){
        List<Sensor> sensorList;
        sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);
        return sensorList;
    }

}