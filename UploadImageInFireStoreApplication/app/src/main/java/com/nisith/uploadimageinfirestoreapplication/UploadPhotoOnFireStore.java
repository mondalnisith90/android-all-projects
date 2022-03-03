package com.nisith.uploadimageinfirestoreapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class UploadPhotoOnFireStore extends AppCompatActivity {

    private TextView pickPhotoTextView;
    private EditText photoTitleEditText,photoDescriptionEditText;
    private Button uploadPhotoButton;
    private ImageView galleryPickImageView;
    private ProgressBar progressBar;
    private static final int PICK_IMAGE_REQUEST_CODE = 123;
    private Uri imageUri,storageFileUri;
    private CollectionReference collectionRef;
    private StorageReference firebaseStorageRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_photo_on_fire_store);
        convertToJavaObject();
        FirebaseFirestore firebaseFirestoreDB = FirebaseFirestore.getInstance();
        collectionRef = firebaseFirestoreDB.collection("uploaded photo details");
        firebaseStorageRef = FirebaseStorage.getInstance().getReference("uploaded photos");

        pickPhotoTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickPhotoFromGallery();

            }
        });

        uploadPhotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadPhotoOnFireStoreDataBase();


            }
        });

    }


    private void convertToJavaObject(){
        Toolbar toolbar = findViewById(R.id.app_toolbar);
        TextView toolbarTextView = toolbar.findViewById(R.id.toolbar_text_view);
        setSupportActionBar(toolbar);
        setTitle("");
        toolbarTextView.setText("Upload Photo");
        toolbar.setNavigationIcon(R.drawable.ic_cross);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        pickPhotoTextView = findViewById(R.id.pick_photo_text_view);
        photoTitleEditText = findViewById(R.id.photo_title_edit_text);
        photoDescriptionEditText = findViewById(R.id.photo_description_edit_text);
        uploadPhotoButton = findViewById(R.id.upload_photo_button);
        galleryPickImageView = findViewById(R.id.gallery_pick_image_view);
        progressBar = findViewById(R.id.progressbar);


    }

    private void pickPhotoFromGallery(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST_CODE && resultCode == RESULT_OK && data != null && data.getData() != null){
            imageUri = data.getData();
            Picasso.get().load(imageUri).fit().centerCrop().into(galleryPickImageView);
        }
    }

    private void uploadPhotoOnFireStoreDataBase(){
        String title = photoTitleEditText.getText().toString();
        String description = photoDescriptionEditText.getText().toString();
        if (imageUri != null){
            if (title.trim().isEmpty() || description.trim().isEmpty()){
                Toast.makeText(this, "Enter Photo Title and Description", Toast.LENGTH_SHORT).show();
            }else {
                uploadPhoto(title,description);
                progressBar.setVisibility(View.VISIBLE);
                uploadPhotoButton.setEnabled(false);
                photoTitleEditText.setEnabled(false);
                photoDescriptionEditText.setEnabled(false);
                pickPhotoTextView.setEnabled(false);

            }

        }else {
            Toast.makeText(this, "Please Pick Photo From Gallery", Toast.LENGTH_SHORT).show();
        }
    }

    private void uploadPhoto(final String title, final String description){
        final StorageReference storageReference = firebaseStorageRef.child(String.valueOf(System.currentTimeMillis())+".jpg");
        storageReference.putFile(imageUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Task<Uri> task = taskSnapshot.getStorage().getDownloadUrl();
                        task.addOnCompleteListener(new OnCompleteListener<Uri>() {
                            @Override
                            public void onComplete(@NonNull Task<Uri> task) {
                                storageFileUri = null;
                                storageFileUri = task.getResult();
                                if (storageFileUri != null){
                                    savePhotoDetailsOnFireStore(title,description,storageFileUri.toString());
                                }else {
                                    progressBar.setVisibility(View.GONE);
                                    uploadPhotoButton.setEnabled(true);
                                    pickPhotoTextView.setEnabled(true);
                                    photoTitleEditText.setEnabled(true);
                                    photoDescriptionEditText.setEnabled(true);
                                }
                            }
                        });


                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressBar.setVisibility(View.GONE);
                        uploadPhotoButton.setEnabled(true);
                        pickPhotoTextView.setEnabled(true);
                        photoTitleEditText.setEnabled(true);
                        photoDescriptionEditText.setEnabled(true);
                        Toast.makeText(UploadPhotoOnFireStore.this, "Photo Not Upload", Toast.LENGTH_SHORT).show();
                    }
                });
    }


    private void savePhotoDetailsOnFireStore(String title, String description, String photoUrl){
        if (collectionRef != null){
            DateTime dateTime = new DateTime();
            String currentDateTime = dateTime.getCurrentDateTime();

            Note note = new Note(title,description,photoUrl,currentDateTime);
            collectionRef.document().set(note)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            progressBar.setVisibility(View.GONE);
                            uploadPhotoButton.setEnabled(true);
                            pickPhotoTextView.setEnabled(true);
                            photoTitleEditText.setEnabled(true);
                            photoDescriptionEditText.setEnabled(true);
                            Toast.makeText(UploadPhotoOnFireStore.this, "Photo Uploaded Successfully", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            progressBar.setVisibility(View.GONE);
                            uploadPhotoButton.setEnabled(true);
                            pickPhotoTextView.setEnabled(true);
                            photoTitleEditText.setEnabled(true);
                            photoDescriptionEditText.setEnabled(true);
                            Toast.makeText(UploadPhotoOnFireStore.this, "Photo Not Upload", Toast.LENGTH_SHORT).show();
                        }
                    });
        }


    }


}
