package com.nisith.retrofitexample;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

public class ImageDisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_display);
        Toolbar toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        String imageUrl = intent.getStringExtra("image_url");
        ImageView imageView = findViewById(R.id.image_view);
        LinearLayout offlineWindowView = findViewById(R.id.offline_window_view);
        Button retryButton = findViewById(R.id.retry_button);
        if (isInternateAvailable()) {
            imageView.setVisibility(View.VISIBLE);
            offlineWindowView.setVisibility(View.GONE);
            Picasso.get().load(imageUrl).into(imageView);
        } else {
            imageView.setVisibility(View.GONE);
            offlineWindowView.setVisibility(View.VISIBLE);
            AlertDialogForNetworkError alertDialog = new AlertDialogForNetworkError();
            alertDialog.show(getSupportFragmentManager(),"NISITH");
        }

        retryButton.setOnClickListener(new MyRetryButtonClickListener(imageUrl));

    }
    private boolean isInternateAvailable() {
        //This method check if the internate is availabe or not

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        } else {
            return false;
        }
    }

    private class MyRetryButtonClickListener implements View.OnClickListener{
        private String imageUrl;

        public MyRetryButtonClickListener(String imageUrl){
            this.imageUrl = imageUrl;
        }

        @Override
        public void onClick(View v) {
            if (isInternateAvailable()){
                finish();
                Intent intent = new Intent(ImageDisplayActivity.this,ImageDisplayActivity.class);
                intent.putExtra("image_url",imageUrl);
                startActivity(intent);
            } else {
                AlertDialogForNetworkError alertDialog = new AlertDialogForNetworkError();
                alertDialog.show(getSupportFragmentManager(),"NISITH");
            }
        }
    }
}
