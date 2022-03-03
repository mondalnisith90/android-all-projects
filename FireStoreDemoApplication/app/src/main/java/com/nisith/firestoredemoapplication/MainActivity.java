package com.nisith.firestoredemoapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private FirebaseFirestore firebaseFirestoreDB;
    private static final String KEY_TITLE = "title";
    private static final String KEY_DESCRIPTION = "description";
    private EditText editTextTitle,editTextDescription;
    private Button saveNoteButton,loadNotesButton;
    private TextView resultNotes;
    private CollectionReference noteCollectionRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTitle = findViewById(R.id.edit_text_title);
        editTextDescription = findViewById(R.id.edit_text_description);
        saveNoteButton = findViewById(R.id.save_note_button);
        loadNotesButton = findViewById(R.id.load_notes_button);
        resultNotes = findViewById(R.id.result_notes);
        firebaseFirestoreDB = FirebaseFirestore.getInstance();
        noteCollectionRef = firebaseFirestoreDB.collection("note book");
        saveNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNoteInFireStore();
            }
        });
        loadNotesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadNotesFromFireStore();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        noteCollectionRef.addSnapshotListener(this,new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                if (e != null){
                    return;
                }

                if (queryDocumentSnapshots != null){

                    String allNotes = "";
                    for (DocumentSnapshot documentNote : queryDocumentSnapshots){
                        Note note = documentNote.toObject(Note.class);
                        String title = note.getTitles();
                        String description = note.getDescriptions();
                        String keyId = documentNote.getId();
                        allNotes = allNotes + "Title: "+title +"\n"+ "Description: "+description + "\n" + "Note Id: " + keyId + "\n\n";
                    }
                    resultNotes.setText(allNotes);
                }else {
                    resultNotes.setText("");
                }
            }
        });

    }

    private void saveNoteInFireStore(){
       String title = editTextTitle.getText().toString();
       String description = editTextDescription.getText().toString();
//       Map<String,Object> note = new HashMap<>();
//       note.put(KEY_TITLE,title);
//       note.put(KEY_DESCRIPTION,description);
        Note note = new Note(title,description);
       noteCollectionRef.document().set(note)
                  .addOnSuccessListener(new OnSuccessListener<Void>() {
                      @Override
                      public void onSuccess(Void aVoid) {
                          Toast.makeText(MainActivity.this, "Note Save Successfully", Toast.LENGTH_SHORT).show();
                      }
                  })
                  .addOnFailureListener(new OnFailureListener() {
                      @Override
                      public void onFailure(@NonNull Exception e) {
                          Toast.makeText(MainActivity.this, "Note Not Save, Error "+e.getMessage(), Toast.LENGTH_SHORT).show();
                      }
                  });

    }

    private void loadNotesFromFireStore(){

        noteCollectionRef.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                 String allNotes = "";
                for (DocumentSnapshot documentNote : queryDocumentSnapshots){
                    Note note = documentNote.toObject(Note.class);
                    String title = note.getTitles();
                    String description = note.getDescriptions();
                    String keyId = documentNote.getId();
                    allNotes = allNotes + "Title: "+title +"\n"+ "Description: "+description + "\n" + "Note Id: " + keyId + "\n\n";
                }
                resultNotes.setText(allNotes);
            }
        });
    }
}
