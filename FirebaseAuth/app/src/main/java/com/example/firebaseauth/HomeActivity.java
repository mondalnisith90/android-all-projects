package com.example.firebaseauth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeActivity extends AppCompatActivity {
    private TextView textView2,textView3;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        textView2=findViewById(R.id.text_view2);
        textView3=findViewById(R.id.text_view3);
        firebaseAuth=FirebaseAuth.getInstance();
        user=firebaseAuth.getCurrentUser();
        if (user!=null)
        {
            textView2.setText(user.getEmail());
            textView3.setText(user.getUid());
        }
        else
        {
            Toast.makeText(this, "user is NULL", Toast.LENGTH_LONG).show();
        }

    }
}
