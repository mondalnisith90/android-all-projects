package com.nisith.allcurrencyconverter;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements CurrencyNetworkOperation.OnFinishServerOperationIListener {

    EditText editText1,editText2;
    TextView result;
    ArrayList<CurrencyInfo> currencyInfoArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.result);
//        String url = "https://community-neutrino-currency-conversion.p.rapidapi.com/convert";
//
//        OkHttpClient okHttpClient = new OkHttpClient();
//        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
//        RequestBody requestBody = RequestBody.create(mediaType,"from-type=USD&to-type=INR&from-value=3");
//        Request request = new Request.Builder()
//                .url(url)
//                .post(requestBody)
//                .addHeader("x-rapidapi-host", "community-neutrino-currency-conversion.p.rapidapi.com")
//                .addHeader("x-rapidapi-key", "4cb9c3992cmsh8959d21ec207e07p1940fdjsnb047353be7d3")
//                .addHeader("content-type", "application/x-www-form-urlencoded")
//                .build();


//
//
//        final OkHttpClient okHttpClient = new OkHttpClient();
//
//        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
//        RequestBody body = RequestBody.create(mediaType, "from-type=USD&to-type=INR&from-value=1");
//        final Request request = new Request.Builder()
//                .url("https://community-neutrino-currency-conversion.p.rapidapi.com/convert")
//                .post(body)
//                .addHeader("x-rapidapi-host", "community-neutrino-currency-conversion.p.rapidapi.com")
//                .addHeader("x-rapidapi-key", "4cb9c3992cmsh8959d21ec207e07p1940fdjsnb047353be7d3")
//                .addHeader("content-type", "application/x-www-form-urlencoded")
//                .build();




//        final OkHttpClient okHttpClient = new OkHttpClient();
//
//        final Request request = new Request.Builder()
//                .url("https://currency-converter5.p.rapidapi.com/currency/convert?format=json&from=USD&to=INR&amount=1")
//                .get()
//                .addHeader("x-rapidapi-host", "currency-converter5.p.rapidapi.com")
//                .addHeader("x-rapidapi-key", "4cb9c3992cmsh8959d21ec207e07p1940fdjsnb047353be7d3")
//                .build();



////Currently give wrong Result
        /*

        OkHttpClient okHttpClient = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://currency-exchange.p.rapidapi.com/exchange?q=1.0&from=USD&to=BDT")
                .get()
                .addHeader("x-rapidapi-host", "currency-exchange.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "4cb9c3992cmsh8959d21ec207e07p1940fdjsnb047353be7d3")
                .build();


        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(MainActivity.this, "onFailure() is called", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()){
                    Log.d("ABCD", "" + response.body().string());
                }else {
                    Log.d("ABCD", "Not Successfull "+response.body().string());
                }
            }
        });

*/

//                .addHeader("content-type", "application/x-www-form-urlencoded")


        //demo

        OkHttpClient okHttpClient = new OkHttpClient();


//        final Request request = new Request.Builder()
//                .url("https://currencyscoop.p.rapidapi.com/latest")
//                .get()
//                .addHeader("x-rapidapi-host", "currencyscoop.p.rapidapi.com")
//                .addHeader("x-rapidapi-key", "4cb9c3992cmsh8959d21ec207e07p1940fdjsnb047353be7d3")
//                .build();
////        okHttpClient.newCall(request).enqueue(new Callback() {
////            @Override
////            public void onFailure(Call call, IOException e) {
////                Toast.makeText(MainActivity.this, "onFailure() is called", Toast.LENGTH_SHORT).show();
////            }
////
////            @Override
////            public void onResponse(Call call, Response response) throws IOException {
////                if (response.isSuccessful()){
////
////                    String jsonString = response.body().string();
////
////                    try {
////                        JSONObject jsonObject = new JSONObject(jsonString);
////                        JSONObject response1 = jsonObject.getJSONObject("response");
////                        JSONObject rates = response1.getJSONObject("rates");
////                        Log.d("ABCD", "Internet "+isInternetAvailable()+" "+rates);
////                        JSONArray jsonArray = rates.names();
////                        int index;
////                       currencyInfoArrayList = new ArrayList<>();
////                        for (index = 0;index<jsonArray.length();index++){
////                            String currencyName =  jsonArray.getString(index);
////                            String currencyRate = rates.getString(currencyName);
////                            currencyInfoArrayList.add(new CurrencyInfo(currencyName,currencyRate));
////
////
////                        }
////
//////                        for(CurrencyInfo currencyInfo : currencyInfoArrayList){
//////                            Log.d("ABCD",currencyInfo.getCurrencyName()+" "+currencyInfo.getCurrencyRate());
//////                        }
//////                        Gson gson = new Gson();
////
//////                        performCurrencyConvertion();
////
////                    } catch (JSONException e) {
////                        e.printStackTrace();
////                        Log.d("ABCD", "error "+e);
////                    }
////
////
////                }else {
////                    Log.d("ABCD", "Not Successfull "+response.body().string());
////                }
////            }
////        });
//



//
        CurrencyNetworkOperation currencyNetworkOperation = new CurrencyNetworkOperation(this);
       currencyNetworkOperation.performServerOperation();
//        if (allCurrencyInfoArrayList != null){
//            performCurrencyConvertion(allCurrencyInfoArrayList);
//        }




    }

    private boolean isInternetAvailable() {
        //This method check if the internet is available or not
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        } else {
            return false;
        }
    }


    private void performCurrencyConvertion(ArrayList<CurrencyInfo> allCurrencyInfoArrayList){
        float sourceCurrencyValue = Float.parseFloat(allCurrencyInfoArrayList.get(0).getCurrencyRate());
        float destCurrencyValue = Float.parseFloat(allCurrencyInfoArrayList.get(3).getCurrencyRate());
        float result = destCurrencyValue/sourceCurrencyValue;
        Log.d("ABCD","Result="+result);


    }

    @Override
    public void onFinishServerOperation(ArrayList<CurrencyInfo> allcurrencyInfoArrayList, String resultStatus) {
        Log.d("ABCD",resultStatus);
        if (resultStatus.equalsIgnoreCase("ok") && allcurrencyInfoArrayList!= null){
            performCurrencyConvertion(allcurrencyInfoArrayList);
        }
    }
}
