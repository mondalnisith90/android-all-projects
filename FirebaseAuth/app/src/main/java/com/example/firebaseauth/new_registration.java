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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class new_registration extends AppCompatActivity {

    private EditText email,password;
    private Button submit;
    private FirebaseAuth firebaseAuth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_registration);
        email=findViewById(R.id.email1);
        password=findViewById(R.id.password1);
        submit=findViewById(R.id.submit1);
        progressBar=findViewById(R.id.progress_bar1);
        progressBar.setVisibility(View.INVISIBLE);
        firebaseAuth=FirebaseAuth.getInstance();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                progressBar.setVisibility(View.VISIBLE);
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
                Task task=firebaseAuth.createUserWithEmailAndPassword(uemail,upassword);
                task.addOnCompleteListener(new OnCompleteListener() {
                    @Override
                    public void onComplete(@NonNull Task task) {
                        if(task.isSuccessful())
                        {
                            progressBar.setVisibility(View.INVISIBLE);
                            Toast.makeText(new_registration.this, "User Registered Successfully", Toast.LENGTH_LONG).show();
                            Intent intent=new Intent(new_registration.this,HomeActivity.class);
                            startActivity(intent);

                        }
                        else
                        {
                            if (task.getException() instanceof FirebaseAuthUserCollisionException)
                            {
                                progressBar.setVisibility(View.INVISIBLE);
                                Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_LONG).show();
                            }
                            else
                            {
                                progressBar.setVisibility(View.INVISIBLE);
                                Toast.makeText(new_registration.this, "Account Registration Failed", Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                });



            }
        });

    }
}
