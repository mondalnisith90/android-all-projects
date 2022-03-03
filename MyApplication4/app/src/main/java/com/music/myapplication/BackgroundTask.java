package com.music.myapplication;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class BackgroundTask extends AsyncTask<Void,Void,String> {

    @SuppressLint("StaticFieldLeak")
    private MainActivity mainActivity;

    public BackgroundTask(MainActivity mainActivity){
        this.mainActivity = mainActivity;
    }



    @Override
    protected String doInBackground(Void... voids) {
        String result="";
        HttpURLConnection httpURLConnection=null;


        try {
            String url_name = "https://api.railwayapi.com/v2/route/train/12345/apikey/9co23pcfdj";

            URL url = new URL(url_name);
            Log.d("ABCD","after url");
            httpURLConnection = (HttpURLConnection) url.openConnection();
            Log.d("ABCD","after httpURLConnection");

            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);

            httpURLConnection.connect();
            Log.d("ABCD","after connect");
            InputStream inputStream = httpURLConnection.getInputStream();
            Log.d("ABCD","after inputStream");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            Log.d("ABCD","after bufferedReader");
            String json_string = bufferedReader.readLine();
//            JSONObject parent_json_obj = new JSONObject(json_string);
            Log.d("ABCD",""+json_string);








        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            Log.d("ABCD",""+e.getMessage());
            e.printStackTrace();

            e.printStackTrace();

        }

        finally {
            if (httpURLConnection!=null)
                httpURLConnection.disconnect();
        }

        return result;
    }


    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
    }


}
