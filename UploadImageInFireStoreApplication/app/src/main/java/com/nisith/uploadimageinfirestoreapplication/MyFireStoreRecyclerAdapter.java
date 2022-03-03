package com.nisith.uploadimageinfirestoreapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyFireStoreRecyclerAdapter extends FirestoreRecyclerAdapter<Note, MyFireStoreRecyclerAdapter.MyViewHolder> {

    private OnCardViewItemClickListener cardViewItemClickListener;


    public MyFireStoreRecyclerAdapter(@NonNull FirestoreRecyclerOptions<Note> options, OnCardViewItemClickListener cardViewItemClickListener) {
        super(options);
        this.cardViewItemClickListener = cardViewItemClickListener;
    }


    public interface OnCardViewItemClickListener{
        void onCardItemClick(int position, DocumentSnapshot documentSnapshot);
    }

    @Override
    protected void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i, @NonNull Note note) {
        myViewHolder.titleTextView.setText(note.getTitle());
        myViewHolder.descriptionTextView.setText(note.getDescription());
        Picasso.get().load(note.getPhotoUrl()).placeholder(R.drawable.ic_photo_icon).fit().centerCrop().into(myViewHolder.thumbnailImageView);

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_appreance,parent,false);
        return new MyViewHolder(view);
    }

    public void deletePhotoFromFireStore(final int position){
        final DocumentSnapshot documentSnapshot =  getSnapshots().getSnapshot(position);
        documentSnapshot.getReference().delete().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
              String photoUrl = documentSnapshot.get("photoUrl").toString();
                FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();
                StorageReference storageReference = firebaseStorage.getReferenceFromUrl(photoUrl);
                storageReference.delete();
            }
        });
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView thumbnailImageView;
        TextView titleTextView;
        TextView descriptionTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            thumbnailImageView = itemView.findViewById(R.id.thumbnail_image_view);
            titleTextView = itemView.findViewById(R.id.title_text_view);
            descriptionTextView = itemView.findViewById(R.id.description_text_view);
            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    DocumentSnapshot documentSnapshot = getSnapshots().getSnapshot(position);
                    cardViewItemClickListener.onCardItemClick(position,documentSnapshot);
                }
            });

        }
    }

}
