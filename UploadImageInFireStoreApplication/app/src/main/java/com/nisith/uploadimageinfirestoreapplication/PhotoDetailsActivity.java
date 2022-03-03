package com.nisith.uploadimageinfirestoreapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

public class PhotoDetailsActivity extends AppCompatActivity {
    private CollectionReference fireStroeCollectionRef;
    private TextView titleTextView, descriptionTextView, lastModifiedDateTextView;
    private ImageView imageView;
    private ImageView editDetailsImageView;
    private String photoId, photoTitle, photoDescription, photoUrl, photoLastModifiedDate;
    private EditText photoTitleEditText, photoDescriptionEditText;
    private Button updateButton;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_details);
        titleTextView = findViewById(R.id.title_text_view);
        descriptionTextView = findViewById(R.id.description_text_view);
        imageView = findViewById(R.id.image_view);
        editDetailsImageView = findViewById(R.id.edit_details_image_view);
        photoTitleEditText = findViewById(R.id.photo_title_edit_text);
        photoDescriptionEditText = findViewById(R.id.photo_description_edit_text);
        updateButton = findViewById(R.id.update_button);
        progressBar = findViewById(R.id.progress_bar);
        lastModifiedDateTextView = findViewById(R.id.last_modified_date_text_view);
        Toolbar toolbar = findViewById(R.id.app_toolbar);
        setSupportActionBar(toolbar);
        setTitle("");
        toolbar.setNavigationIcon(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent intent = getIntent();
        photoId = intent.getStringExtra("PHOTO_ID");
        photoTitle = intent.getStringExtra("PHOTO_TITLE");
        photoDescription = intent.getStringExtra("PHOTO_DESCRIPTION");
        photoUrl = intent.getStringExtra("PHOTO_URL");
        photoLastModifiedDate = intent.getStringExtra("PHOTO_LAST_MODIFIED_DATE");
        fireStroeCollectionRef = FirebaseFirestore.getInstance().collection("uploaded photo details");
        displayPhotoDetails();
        photoTitleEditText.setVisibility(View.GONE);
        photoDescriptionEditText.setVisibility(View.GONE);
        updateButton.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);
        editDetailsImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (photoTitleEditText.getVisibility() == View.GONE) {
                    photoTitleEditText.setVisibility(View.VISIBLE);
                    photoDescriptionEditText.setVisibility(View.VISIBLE);
                    updateButton.setVisibility(View.VISIBLE);
                    photoTitleEditText.setText(photoTitle);
                    photoDescriptionEditText.setText(photoDescription);
                }else {
                    photoTitleEditText.setVisibility(View.GONE);
                    photoDescriptionEditText.setVisibility(View.GONE);
                    updateButton.setVisibility(View.GONE);
                }
            }
        });

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updatePhotoInfo();
            }
        });

    }


    private void updatePhotoInfo(){
        DateTime dateTime = new DateTime();
        final String currentdateTime = dateTime.getCurrentDateTime();
        final String title = photoTitleEditText.getText().toString();
        final String description = photoDescriptionEditText.getText().toString();
        if (title.trim().isEmpty() || description.trim().isEmpty()){
            Toast.makeText(this, "Please Enter Title and Description", Toast.LENGTH_SHORT).show();
            return;
        }
        DocumentReference documentReference = FirebaseFirestore.getInstance().collection("uploaded photo details").document(photoId);

        Map<String,Object> newNote = new HashMap<>();
        newNote.put("title",title);
        newNote.put("description",description);
        newNote.put("lastModified",currentdateTime);
        progressBar.setVisibility(View.VISIBLE);
        photoTitleEditText.setEnabled(false);
        photoDescriptionEditText.setEnabled(false);
        documentReference.update(newNote).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(PhotoDetailsActivity.this, "Update Successfully", Toast.LENGTH_SHORT).show();
                titleTextView.setText(title);
                descriptionTextView.setText(description);
                lastModifiedDateTextView.setText(currentdateTime);
                photoTitleEditText.setVisibility(View.GONE);
                photoDescriptionEditText.setVisibility(View.GONE);
                updateButton.setVisibility(View.GONE);
                progressBar.setVisibility(View.GONE);
                photoTitleEditText.setEnabled(true);
                photoDescriptionEditText.setEnabled(true);

            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(PhotoDetailsActivity.this, "Not Update", Toast.LENGTH_SHORT).show();
                        photoTitleEditText.setVisibility(View.GONE);
                        photoDescriptionEditText.setVisibility(View.GONE);
                        updateButton.setVisibility(View.GONE);
                        progressBar.setVisibility(View.GONE);
                        photoTitleEditText.setEnabled(true);
                        photoDescriptionEditText.setEnabled(true);
                    }
                });

    }


    private void displayPhotoDetails(){
        if (photoUrl != null){
            Picasso.get().load(photoUrl).placeholder(R.drawable.ic_photo_icon).fit().centerCrop().into(imageView);
            titleTextView.setText(photoTitle);
            descriptionTextView.setText(photoDescription);
            lastModifiedDateTextView.setText("Last Modified   " + photoLastModifiedDate);


        }else {
            Toast.makeText(this, "Photo Not Load. Some Error arise", Toast.LENGTH_SHORT).show();
        }
    }

}
