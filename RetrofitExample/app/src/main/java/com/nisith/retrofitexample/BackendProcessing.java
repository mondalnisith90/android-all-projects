package com.nisith.retrofitexample;

import androidx.appcompat.widget.RecyclerView;

import android.view.View;
import android.widget.ProgressBar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BackendProcessing {

    private MainActivity mainActivity;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    public BackendProcessing(MainActivity mainActivity, RecyclerView recyclerView, ProgressBar progressBar){
        this.mainActivity = mainActivity;
        this.recyclerView = recyclerView;
        this.progressBar = progressBar;
    }


    public void executeBackendProcess(){



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WebServiceApi webServiceApi = retrofit.create(WebServiceApi.class);
        Call<List<Photo>> call = webServiceApi.getImageInfo();
        progressBar.setVisibility(View.VISIBLE);
        call.enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                if (response.isSuccessful()){
                   List<Photo>  photoList = response.body();
                   if (photoList!=null){
                       progressBar.setVisibility(View.GONE);
                       recyclerView.setAdapter(new MyRecyclerViewAdapter(photoList,mainActivity));
                   }
                }
            }
            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
            }
        });

    }
}
