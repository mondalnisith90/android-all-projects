package com.example.edittextapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tapadoo.alerter.Alerter;
import com.tapadoo.alerter.OnHideAlertListener;
import com.tapadoo.alerter.OnShowAlertListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText et1=(EditText)findViewById(R.id.edtitext1);
        EditText et2=(EditText)findViewById(R.id.edtitext2);
        Button button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Alerter alert=Alerter.create(MainActivity.this);
                alert.setIcon(R.drawable.ic_android_black_24dp);
                alert.setText("This is Alert");
                alert.setTitle("Alert Message");
                alert.setBackgroundColorRes(R.color.colorAccent);
                alert.setDuration(5000);
                alert.enableSwipeToDismiss();
                alert.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this,"You are click on Alert Massege",Toast.LENGTH_LONG).show();
                    }
                });
                alert.setOnShowListener(new OnShowAlertListener() {
                    @Override
                    public void onShow() {
                        Toast.makeText(MainActivity.this,"Your Alert Massege is Showing",Toast.LENGTH_LONG).show();
                    }
                });
                alert.setOnHideListener(new OnHideAlertListener() {
                    @Override
                    public void onHide() {
                        Toast.makeText(MainActivity.this,"Your Alert Massege is Hide",Toast.LENGTH_LONG).show();
                    }
                });
                alert.show();
            }
        });
    }
}
