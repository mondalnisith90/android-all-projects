package com.music.example_app;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        toolbar  = findViewById(R.id.toolbar);

        setTitle("Example App");
        setSupportActionBar(toolbar);
        setContentView(R.layout.activity_main);
        setTitle("");
        imageView=findViewById(R.id.image_view);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    public void display(View view){
        switch (view.getId())
        {
            case R.id.b1:{
                imageView.setBackgroundColor(Color.RED);
                break;
            }
            case R.id.b2:{
                imageView.setBackgroundColor(Color.GREEN);
                break;
            }
            case R.id.b3:{
                imageView.setBackgroundColor(Color.BLUE);
                break;
            }
            case R.id.b4:{
                imageView.setBackgroundColor(Color.GRAY);
                break;
            }
            case R.id.b5:{
                imageView.setBackgroundColor(Color.WHITE);
                break;
            }
            case R.id.b6:{
                imageView.setBackgroundColor(Color.YELLOW);
                break;
            }
            case R.id.b7:{
                imageView.setBackgroundColor(Color.CYAN);
                break;
            }
            case R.id.b8:{
                imageView.setBackgroundColor(Color.TRANSPARENT);
                break;
            }
            case R.id.b9:{
//                Toast.makeText(getApplicationContext(),"Button 9 is Clicked",Toast.LENGTH_SHORT).show();
                CreateDialog createDialog = new CreateDialog(this);
                createDialog.getDialog().show();
                break;
            }
            case R.id.b10:{
                CreateDialog createDialog = new CreateDialog(this);
                createDialog.getDialog().show();
                break;
            }
            case R.id.b11:{
                CreateDialog createDialog = new CreateDialog(this);
                createDialog.getDialog().show();
                break;
            }
            case R.id.b12:{
                imageView.setBackgroundColor(Color.BLACK);
                break;
            }
        }
    }
}
