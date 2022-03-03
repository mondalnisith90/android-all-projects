package com.example.implacitintentmain;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button b1;
    private EditText et1;
    String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button1);
        et1=(EditText)findViewById(R.id.edittext1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phone=et1.getText().toString();
                Uri webpage=Uri.parse("tel:"+phone);
                Intent intent=new Intent(Intent.ACTION_DIAL,webpage);
                Intent chooser=Intent.createChooser(intent,"choose Your Favourite Browser");
                startActivity(chooser);
            }
        });






    }
}
