package com.nisith.retrofitexample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WebServiceApi {

    @GET("photos")
     Call<List<Photo>> getImageInfo();

}
