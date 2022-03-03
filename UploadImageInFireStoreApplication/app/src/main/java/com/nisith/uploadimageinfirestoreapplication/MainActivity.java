package com.nisith.uploadimageinfirestoreapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.storage.FirebaseStorage;
import com.squareup.picasso.Picasso;


public class MainActivity extends AppCompatActivity implements MyFireStoreRecyclerAdapter.OnCardViewItemClickListener {


    private FloatingActionButton floatingActionButton;
    private RecyclerView recyclerView;
    private MyFireStoreRecyclerAdapter myFireStoreRecyclerAdapter;
    private FirebaseFirestore firebaseFirestoreDB;
    private CollectionReference fireStoreCollectionRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        convertToJavaObject();
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,UploadPhotoOnFireStore.class));
            }
        });
        firebaseFirestoreDB = FirebaseFirestore.getInstance();
        fireStoreCollectionRef = firebaseFirestoreDB.collection("uploaded photo details");
        setRecyclerViewWithAdapter();

    }




    private void convertToJavaObject(){
        Toolbar toolbar = findViewById(R.id.app_toolbar);
        TextView toolbarTextView = toolbar.findViewById(R.id.toolbar_text_view);
        recyclerView = findViewById(R.id.recycler_view);
        floatingActionButton = findViewById(R.id.floating_action_button);
        setSupportActionBar(toolbar);
        setTitle("");
        toolbarTextView.setText("All Uploaded Photos");

    }


    private void setRecyclerViewWithAdapter(){
        Query query = fireStoreCollectionRef.orderBy("title", Query.Direction.ASCENDING);

        FirestoreRecyclerOptions<Note> fireStoreRecyclerOptions = new FirestoreRecyclerOptions.Builder<Note>()
                .setQuery(query,Note.class)
                .build();
        myFireStoreRecyclerAdapter = new MyFireStoreRecyclerAdapter(fireStoreRecyclerOptions,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(myFireStoreRecyclerAdapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                myFireStoreRecyclerAdapter.deletePhotoFromFireStore(viewHolder.getAdapterPosition());
            }
        });

        itemTouchHelper.attachToRecyclerView(recyclerView);

    }


    @Override
    public void onCardItemClick(int position, DocumentSnapshot documentSnapshot) {
        //When Card items is Clicked
        String photoId = documentSnapshot.getId();
        Note note = documentSnapshot.toObject(Note.class);
        String photoTitle = note.getTitle();
        String photoDescription = note.getDescription();
        String photoUrl = note.getPhotoUrl();
        String lastModifiedDate = note.getLastModified();
        Intent intent = new Intent(MainActivity.this,PhotoDetailsActivity.class);
        intent.putExtra("PHOTO_ID",photoId);
        intent.putExtra("PHOTO_TITLE",photoTitle);
        intent.putExtra("PHOTO_DESCRIPTION",photoDescription);
        intent.putExtra("PHOTO_URL",photoUrl);
        intent.putExtra("PHOTO_LAST_MODIFIED_DATE",lastModifiedDate);
        startActivity(intent);


    }



    @Override
    protected void onStart() {
        super.onStart();
        if (myFireStoreRecyclerAdapter != null){
            myFireStoreRecyclerAdapter.startListening();
        }
    }


    @Override
    protected void onStop() {
        super.onStop();
        if (myFireStoreRecyclerAdapter != null){
            myFireStoreRecyclerAdapter.stopListening();
        }
    }


}
