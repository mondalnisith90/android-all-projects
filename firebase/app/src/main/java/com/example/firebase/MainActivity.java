package com.example.firebase;

import android.app.Activity;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;

public class MainActivity extends Activity {


    private FirebaseDatabase database;
    private DatabaseReference childref;
    private EditText editText;
    private Button sendButton;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.edit_text);
        sendButton=findViewById(R.id.send_button);
        textView=findViewById(R.id.text_view);
        database=FirebaseDatabase.getInstance();
        childref=database.getReference("tapas");

        childref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String message=(String) dataSnapshot.getValue();
                textView.setText(message);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),"Data Read is Faild",Toast.LENGTH_LONG).show();
            }
        });

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message=editText.getText().toString();
                if (message.length()>0)
                {
                    childref.setValue(message);
                }
            }
        });

    }
}
