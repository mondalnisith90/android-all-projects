package com.nisith.nodemcu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.dynamic.IFragmentWrapper;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Button greenLedControlButton, blueLedControlButton, discoLedControlButton;
    private ImageView greenLedImageView, blueLedImageView, discoGreenLedImageView, discoBlueLedImageView;
    private DatabaseReference rootDatabaseRef;
    private ChildEventListener childEventListener;
    private static boolean stopThread;
    private final int lightDelay = 800; //in milliSecond

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        greenLedControlButton = findViewById(R.id.green_led_button);
        blueLedControlButton = findViewById(R.id.blue_led_button);
        greenLedImageView = findViewById(R.id.green_led_image_view);
        blueLedImageView = findViewById(R.id.blue_led_image_view);
        discoLedControlButton = findViewById(R.id.disco_led_button);
        discoGreenLedImageView = findViewById(R.id.disco_green_led_image_view);
        discoBlueLedImageView = findViewById(R.id.disco_blue_led_image_view);
        greenLedControlButton.setOnClickListener(new MyButtonClickListener());
        blueLedControlButton.setOnClickListener(new MyButtonClickListener());
        discoLedControlButton.setOnClickListener(new MyButtonClickListener());
        rootDatabaseRef = FirebaseDatabase.getInstance().getReference().child("led-blink");
    }


    @Override
    protected void onStart() {
        super.onStart();
        if (rootDatabaseRef != null) {
          childEventListener =  rootDatabaseRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    setViewsStatus(snapshot);
                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    setViewsStatus(snapshot);
                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot snapshot) {

                }

                @Override
                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

        }
    }



    private void setViewsStatus(DataSnapshot snapshot){
        if (snapshot.exists()){
            String key = snapshot.getKey();
            if (key.equalsIgnoreCase("green_led")){
                long ledState = (long) snapshot.getValue();
                if (ledState == 1){
                    greenLedControlButton.setText("Turn Off Green Led");
                    greenLedImageView.setImageResource(R.drawable.ic_green_bulb);
                }else {
                    greenLedControlButton.setText("Turn On Green Led");
                    greenLedImageView.setImageResource(R.drawable.ic_black_bulb);
                }
            }
            if (key.equalsIgnoreCase("blue_led")){
                long ledState = (long) snapshot.getValue();
                if (ledState == 1){
                    blueLedControlButton.setText("Turn Off Blue Led");
                    blueLedImageView.setImageResource(R.drawable.ic_blue_bulb);
                }else {
                    blueLedControlButton.setText("Turn On Blue Led");
                    blueLedImageView.setImageResource(R.drawable.ic_black_bulb);
                }
            }

            if (key.equalsIgnoreCase("disco_light")){
                long ledState = (long) snapshot.getValue();
                if (ledState == 1){
                    discoLedControlButton.setText("Turn Off Disco Light");
                    startDiscoLight();
                    greenLedControlButton.setEnabled(false);
                    blueLedControlButton.setEnabled(false);

                }else {
                    stopThread = true;
                    discoLedControlButton.setText("Turn On Disco Light");
                    discoGreenLedImageView.setImageResource(R.drawable.ic_whiteblack_bulb);
                    discoBlueLedImageView.setImageResource(R.drawable.ic_whiteblack_bulb);
                    greenLedControlButton.setEnabled(true);
                    blueLedControlButton.setEnabled(true);
                }
            }

        }
    }

    private void startDiscoLight(){
        stopThread = false;
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!stopThread){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            discoGreenLedImageView.setImageResource(R.drawable.ic_green_bulb);
                            discoBlueLedImageView.setImageResource(R.drawable.ic_whiteblack_bulb);
                        }
                    });
                    SystemClock.sleep(lightDelay);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            discoGreenLedImageView.setImageResource(R.drawable.ic_whiteblack_bulb);
                            discoBlueLedImageView.setImageResource(R.drawable.ic_blue_bulb);
                        }
                    });
                    SystemClock.sleep(lightDelay);
                }
            }
        });
        thread.start();
    }

    private class MyButtonClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.green_led_button:
                    greenLedControlButtonClick();
                    break;

                case R.id.blue_led_button:
                    blueLedControlButtonClick();
                    break;

                case R.id.disco_led_button:
                    discoLedControlButtonClick();
                    break;

            }
        }
    }

    private void greenLedControlButtonClick(){
        Map<String, Object> map = new HashMap<>();
        if (greenLedControlButton.getText().toString().equalsIgnoreCase("Turn On Green Led")){
            //set green_led node to '1'
            if (rootDatabaseRef != null){
                map.put("green_led", 1);
                rootDatabaseRef.updateChildren(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            //green led turn on successfully
                            greenLedControlButton.setText("Turn Off Green Led");
                            greenLedImageView.setImageResource(R.drawable.ic_green_bulb);
                        }else {
                            //green led not turn on successfully
                            Toast.makeText(MainActivity.this, "Failed to Turn On Green Led", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

        }else {
            //set green_led node to '0'
            if (rootDatabaseRef != null){
                map.put("green_led", 0);
                rootDatabaseRef.updateChildren(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            //green led turn on successfully
                            greenLedControlButton.setText("Turn On Green Led");
                            greenLedImageView.setImageResource(R.drawable.ic_black_bulb);
                        }else {
                            //green led not turn on successfully
                            Toast.makeText(MainActivity.this, "Failed to Turn Off Green Led", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }

    }


    private void blueLedControlButtonClick(){
        Map<String, Object> map = new HashMap<>();
        if (blueLedControlButton.getText().equals("Turn On Blue Led")){
            //set blue_led node to '1'
            if (rootDatabaseRef != null){
                map.put("blue_led", 1);
                rootDatabaseRef.updateChildren(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            //Blue led turn on successfully
                            blueLedControlButton.setText("Turn Off Blue Led");
                            blueLedImageView.setImageResource(R.drawable.ic_blue_bulb);
                        }else {
                            //green led not turn on successfully
                            Toast.makeText(MainActivity.this, "Failed to Turn On Blue Led", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

        }else {
            //set blue_led node to '0'
            if (rootDatabaseRef != null){
                map.put("blue_led", 0);
                rootDatabaseRef.updateChildren(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            //green led turn on successfully
                            blueLedControlButton.setText("Turn On Blue Led");
                            blueLedImageView.setImageResource(R.drawable.ic_black_bulb);
                        }else {
                            //green led not turn on successfully
                            Toast.makeText(MainActivity.this, "Failed to Turn Off Blue Led", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

        }
    }


    private void discoLedControlButtonClick(){
        Map<String, Object> map = new HashMap<>();
        if (discoLedControlButton.getText().toString().equalsIgnoreCase("Turn On Disco Light")){
            if (rootDatabaseRef != null){
                map.put("disco_light", 1);
                rootDatabaseRef.updateChildren(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            //Blue led turn on successfully
                            discoLedControlButton.setText("Turn Off Disco Light");
                            greenLedControlButton.setEnabled(false);
                            blueLedControlButton.setEnabled(false);
                            startDiscoLight();
                        }else {
                            //green led not turn on successfully
                            Toast.makeText(MainActivity.this, "Failed to Turn On Disco Light", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }


        }else {
            if (rootDatabaseRef != null){
                map.put("disco_light", 0);
                rootDatabaseRef.updateChildren(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            //green led turn on successfully
                            discoLedControlButton.setText("Turn On Disco Light");
                            stopThread = true;
                            discoGreenLedImageView.setImageResource(R.drawable.ic_whiteblack_bulb);
                            discoBlueLedImageView.setImageResource(R.drawable.ic_whiteblack_bulb);
                            greenLedControlButton.setEnabled(true);
                            blueLedControlButton.setEnabled(true);
                        }else {
                            //green led not turn on successfully
                            Toast.makeText(MainActivity.this, "Failed to Turn Off Disco Light", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        if (rootDatabaseRef != null && childEventListener != null){
            rootDatabaseRef.removeEventListener(childEventListener);
        }
    }
}