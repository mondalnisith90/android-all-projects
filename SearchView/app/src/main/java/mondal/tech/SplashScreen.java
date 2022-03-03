package mondal.tech;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class SplashScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Thread thread=new Thread(new Runnable() {
           @Override
           public void run() {
               SystemClock.sleep(3000);
               Intent intent=new Intent(SplashScreen.this,MainActivity.class);
               startActivity(intent);
               finish();
           }
       });


       thread.start();



    }



}
