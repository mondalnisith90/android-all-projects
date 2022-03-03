package com.nisith.firestoreexample;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;

public class MainActivity extends AppCompatActivity {

    FirebaseFirestore firebaseFirestoreDB;
    private static final String title = "title";
    private static final String description = "description";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseFirestoreDB = FirebaseFirestore.getInstance();



    }

    public void save(View view){
        Map<String,Object> note = new HashMap<>();
        note.put(description,"description 1");
        firebaseFirestoreDB.collection("note book").document("my document").set(note)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        if (task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "note Saved Successfully", Toast.LENGTH_SHORT).show();
                            Log.d("ABC","Successfully");
                        }
                    }
                })

                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "note not Saved", Toast.LENGTH_SHORT).show();
                        Log.d("ABC","Not Successfully");
                    }
                });
    }
}
