package com.example.firebaseauth;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private EditText email,password;
    private Button button,submit,button2;
    private FirebaseAuth firebaseAuth;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        button=findViewById(R.id.button);
        submit=findViewById(R.id.submit);
        button2=findViewById(R.id.button2);
        progressBar=findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.INVISIBLE);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                Intent intent=new Intent(MainActivity.this,new_registration.class);
                startActivity(intent);
            }
        });
        firebaseAuth=FirebaseAuth.getInstance();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String uemail=email.getText().toString();
                String upassword=password.getText().toString();
                if (uemail.length()==0)
                {
                    email.setError("Enter Email Address");
                    return;
                }
                else if (password.length()==0)
                {
                    password.setError("Enter Password");
                    return;
                }
                if (password.length()<6)
                {
                    password.setError("Password must be atleast 6 character");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                 Task task=firebaseAuth.signInWithEmailAndPassword(uemail,upassword);
                task.addOnCompleteListener(new OnCompleteListener() {
                    @Override
                    public void onComplete(@NonNull Task task) {
                        progressBar.setVisibility(View.INVISIBLE);
                        if (task.isSuccessful())
                        {

                            Intent intent=new Intent(MainActivity.this,HomeActivity.class);
                            startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}
