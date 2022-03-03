package com.nisith.retrofitexample;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.LinearLayoutManager;
import androidx.appcompat.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements MyRecyclerViewAdapter.OnCardViewClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
//         recyclerView = findViewById(R.id.recycler_view);
        ProgressBar progressBar = findViewById(R.id.progress_bar);
        LinearLayout offlineWindowView = findViewById(R.id.offline_window_view);
        Button retryButton = findViewById(R.id.retry_button);
        progressBar.setVisibility(View.GONE);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setHasFixedSize(true);
        if (isInternateAvailable()) {
            BackendProcessing backendProcessing = new BackendProcessing(this, recyclerView, progressBar);
            offlineWindowView.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            backendProcessing.executeBackendProcess();
        } else{
            recyclerView.setVisibility(View.GONE);
            offlineWindowView.setVisibility(View.VISIBLE);
            AlertDialogForNetworkError alertDialog = new AlertDialogForNetworkError();
            alertDialog.show(getSupportFragmentManager(),"NISITH");
        }

        retryButton.setOnClickListener(new MyRetryButtonClickListener());
    }

    @Override
    public void onCardViewClick(String imageUrl) {
        Intent intent = new Intent(MainActivity.this,ImageDisplayActivity.class);
        intent.putExtra("image_url",imageUrl);
        startActivity(intent);

    }


    private class MyRetryButtonClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            if (isInternateAvailable()){
                finish();
                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                startActivity(intent);
            } else {
                AlertDialogForNetworkError alertDialog = new AlertDialogForNetworkError();
                alertDialog.show(getSupportFragmentManager(),"NISITH");
            }
        }
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

}
