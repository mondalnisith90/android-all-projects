package com.nisith.restapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.nisith.restapi.json_model.CountriesInfoModel;
import com.nisith.restapi.json_model.AllEffectedCountriesModel;
import com.nisith.restapi.json_model.CountryInfoSearchHistoryModel;
import com.nisith.restapi.json_model.EffectedCountriesSearchHistoryModel;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements FeatchEffectedCountriesDataFromServer.OnServerResponseListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Address eaddress = new Address("Haldia","India");
        Employee e1 = new Employee(1,"Nisith",24,eaddress);
        final Gson gson = new Gson();










//        String jsonString = gson.toJson(e1);
//        Log.d("ABCD",jsonString);

        String jsonString = "[{\"age\":24,\"eAddress\":{\"cityName\":\"Haldia\",\"country\":\"India\"},\"id\":1,\"name\":\"Nisith\"},{\"age\":24,\"eAddress\":{\"cityName\":\"Haldia\",\"country\":\"India\"},\"id\":1,\"name\":\"Nisith\"}" +
                ",{\"age\":24,\"eAddress\":{\"cityName\":\"Haldia\",\"country\":\"India\"},\"id\":1,\"name\":\"Nisith\"},{\"age\":24,\"eAddress\":{\"cityName\":\"Haldia\",\"country\":\"India\"},\"id\":1,\"name\":\"Nisith\"}" +
                "]";
        Employee[] e2 = gson.fromJson(jsonString,Employee[].class);

//
//       FeatchEffectedCountriesDataFromServer server = new FeatchEffectedCountriesDataFromServer(this);
//       server.getAllEffectedCountriesDataFromServer();




        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://coronavirus-map.p.rapidapi.com/v1/spots/week?date=10-04-2020&region=INDIA")
                .get()
                .addHeader("x-rapidapi-host", "coronavirus-map.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "4cb9c3992cmsh8959d21ec207e07p1940fdjsnb047353be7d3")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("VIP","Error: "+e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String jsonString = response.body().string();
                Log.d("VIP","Json String = " +jsonString);
                EffectedCountriesSearchHistoryModel effectedCountriesSearchHistoryModel = gson.fromJson(jsonString, EffectedCountriesSearchHistoryModel.class);
                List<CountryInfoSearchHistoryModel> reportList = effectedCountriesSearchHistoryModel.getReportList();
                for (CountryInfoSearchHistoryModel reportModel : reportList){
                    Log.d("VIP","Total Deaths: "+reportModel.getDeaths());
                }
            }
        });


    }

    @Override
    public void onServerResponse(String responseStatus, AllEffectedCountriesModel allEffectedCountriesModel) {
        if (responseStatus.equalsIgnoreCase("success") && allEffectedCountriesModel != null){

            Log.d("ABCD","Date and Time: "+allEffectedCountriesModel.getUpdatedDate());
            List<CountriesInfoModel> list = allEffectedCountriesModel.getAllEffectedCountriesDetaildList();
            for (int i = 0; i<list.size();i++){

                Log.d("ABCD","index= "+i+" name: " +list.get(i).getCountryName());

            }


        }else {
            Log.d("ABCD","Some Error");
        }
    }
}
