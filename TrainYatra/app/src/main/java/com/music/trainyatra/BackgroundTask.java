package com.music.trainyatra;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;


public class BackgroundTask extends AsyncTask<Void,Void,String> {

    @SuppressLint("StaticFieldLeak")
    private SecondActivity secondActivity;
    private String string_url;
    private Train trainInfoObject;
    private ArrayList<Station> allStationInfoArrayList;

    public BackgroundTask(SecondActivity secondActivity,String string_url){
        this.secondActivity = secondActivity;
        this.string_url = string_url;
        allStationInfoArrayList = new ArrayList<>();
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        secondActivity.progressBar.setVisibility(View.VISIBLE);
        secondActivity.searchButton.setEnabled(false);
        secondActivity.input_train_number.setEnabled(false);
    }

    @Override
    protected String doInBackground(Void... voids) {
        String result="";
        HttpURLConnection httpURLConnection=null;
        try {
            URL url = new URL(string_url);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String json_string = bufferedReader.readLine();
            JSONObject parent_jsonObject = new JSONObject(json_string);
            ServerResponseInfo serverResponseInfo = onServerResponseInfo(parent_jsonObject);
            switch (serverResponseInfo.getResponseCode())
            {
                case 200:
                    // ALL OK
                    storeAllStationInfoInArraylist(allStationInfoArrayList, parent_jsonObject);  //Insalize allStationInfoArrayList here by storeAllStationInfoInArraylist() method
                    trainInfoObject = getTrainInfoObject(parent_jsonObject);
                    break;
                case 404:
                    //Input Train Number by the user is not exist
                    AlertDialogForGeneralPurpase dialog = new AlertDialogForGeneralPurpase("Invalid Train Number","You Enter an Invalid Train Number");
                    dialog.show(secondActivity.getSupportFragmentManager(),"NISITH");
                    break;
                case 500:
                    //Invalid API KEY
                    AlertDialogForGeneralPurpase dialog1 = new AlertDialogForGeneralPurpase("Invalid API KEY","Your API Key is Invalid. Please Change it...");
                    dialog1.show(secondActivity.getSupportFragmentManager(),"NISITH");
                    break;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            AlertDialogForGeneralPurpase alertDialog = new AlertDialogForGeneralPurpase("INTERNET CONNECTION","Poor Internet Speed");
            alertDialog.show(secondActivity.getSupportFragmentManager(),"NISITH");
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            if (httpURLConnection!=null)
                httpURLConnection.disconnect();
        }
        return result;
    }




    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        secondActivity.progressBar.setVisibility(View.GONE);
        secondActivity.searchButton.setEnabled(true);
        secondActivity.input_train_number.setEnabled(true);
        secondActivity.searchButton.setText("SEARCH");
        if (trainInfoObject != null){
                displayTrainInfo(trainInfoObject, allStationInfoArrayList);
                displayAllStationsInfoInRecyccelView(allStationInfoArrayList);
                secondActivity.searchButton.setVisibility(View.GONE);
                secondActivity.input_train_number.setVisibility(View.GONE);
                secondActivity.resultWindow.setVisibility(View.VISIBLE);
                secondActivity.hide_result.setVisible(true);

            }



    }







    private ServerResponseInfo onServerResponseInfo(JSONObject jsonObject){
        /* this method return ServerResponseInfo class object which contains
          response_code,train_number and train_name about a Server Response
        */
        int response_code = 0;
        String train_name=null,train_number=null;
        try {
            response_code= jsonObject.getInt("response_code");
            JSONObject train = jsonObject.getJSONObject("train");
            train_name = train.getString("name");
            train_number = train.getString("number");
        }catch (Exception e){

        }
        return new ServerResponseInfo(train_name,train_number,response_code);
    }


    public ArrayList<Station> getAllStationInfoArrayList(){
        return allStationInfoArrayList;
    }


    private void storeAllStationInfoInArraylist(ArrayList<Station> allStationInfoArrayList,JSONObject parent_jsonObject) {
        /* This method store all the stations information in  allStationInfoArrayList ArrayList.
           Each Field in that array list contains a Station class Object which Object contains information about  a single station */

        Station station;
        String station_name,arriavle_time,departure_time;
        int halt,station_number,running_day,distance;

        try {
            JSONArray station_array = parent_jsonObject.getJSONArray("route");
            for(int index = 0; index<station_array.length(); index++){

                JSONObject single_station_jsonObject = station_array.getJSONObject(index);
                arriavle_time = single_station_jsonObject.getString("scharr");
                departure_time = single_station_jsonObject.getString("schdep");
                halt = single_station_jsonObject.getInt("halt");
                running_day = single_station_jsonObject.getInt("day");
                distance = single_station_jsonObject.getInt("distance");
                station_number = single_station_jsonObject.getInt("no");
                station_name = single_station_jsonObject.getJSONObject("station").getString("name");
                station = new Station(station_name,arriavle_time,departure_time,halt,distance,running_day,station_number);
                allStationInfoArrayList.add(station);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public Train getTrainInfoObject(){
        return trainInfoObject;
    }

    public ArrayList<Train.TrainClasses> getTrainClassesInfoArrayList(){
        return trainInfoObject.getTrainClassesInfoArrayList();
    }


    private Train getTrainInfoObject(JSONObject parent_jsonObject){
        String train_name,train_number;
        ArrayList<Train.TrainClasses> train_classes_info_ArrayList;
        ArrayList<Train.TrainRunningDaysInfo> trainRunningDaysInfoArrayList;
        Train trainInfoObject = new Train() ;
        Train.TrainClasses trainClasses ;
        Train.TrainRunningDaysInfo trainRunningDaysInfo;
        String class_name,is_availabe;
        String each_day,isTrain_run;

        try {
            JSONObject train_jsonObject = parent_jsonObject.getJSONObject("train");
            train_name = train_jsonObject.getString("name");
            train_number = train_jsonObject.getString("number");
            JSONArray train_classes_jsonArray = train_jsonObject.getJSONArray("classes");
            train_classes_info_ArrayList = new ArrayList<>();
            for (int index=0; index<train_classes_jsonArray.length(); index++){
                JSONObject single_class_jsonObject = train_classes_jsonArray.getJSONObject(index);
                class_name = single_class_jsonObject.getString("name");
                is_availabe = single_class_jsonObject.getString("available");
                if (is_availabe.equalsIgnoreCase("Y")){
                    is_availabe = "YES";
                }else if (is_availabe.equalsIgnoreCase("N")){
                    is_availabe = "NO";
                }
                trainClasses = trainInfoObject.new TrainClasses(class_name,is_availabe);
                train_classes_info_ArrayList.add(trainClasses);
            }
            JSONArray train_runningDays_jsonArray = train_jsonObject.getJSONArray("days");
            trainRunningDaysInfoArrayList = new ArrayList<>();
            for (int index =0;index<train_runningDays_jsonArray.length(); index++){
                JSONObject single_day_jsonObject = train_runningDays_jsonArray.getJSONObject(index);
                each_day = single_day_jsonObject.getString("code");
                isTrain_run = single_day_jsonObject.getString("runs");
                if (isTrain_run.equalsIgnoreCase("Y")){
                    isTrain_run = "YES";
                }else if (isTrain_run.equalsIgnoreCase("N")){
                    isTrain_run = "NO";
                }
                trainRunningDaysInfo = trainInfoObject.new TrainRunningDaysInfo(each_day,isTrain_run);
                trainRunningDaysInfoArrayList.add(trainRunningDaysInfo);
            }
            trainInfoObject.setTrainInfoObject(train_name,train_number,train_classes_info_ArrayList,trainRunningDaysInfoArrayList);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return  trainInfoObject;

    }

    private void displayTrainInfo(Train trainInfoObject,ArrayList<Station> allStationInfoArrayList){
        /*This Method is responsible to display Train Name , Source Station Name and
          destination Station Name in Display
        */

        secondActivity.trainNameTextView.setText(trainInfoObject.getTrainName());
        String sourceStationName = allStationInfoArrayList.get(0).getStationName(); //As in allStationInfoArrayList arraylist 0 index station object contains source station Information
        String destinationStationName = allStationInfoArrayList.get(allStationInfoArrayList.size()-1).getStationName();  //As in allStationInfoArrayList arraylist last index station object contains Destination station Information
        secondActivity.sourceStationNameTextView.setText(sourceStationName);
        secondActivity.destinationStationNameTextView.setText(destinationStationName);
    }


    private void displayAllStationsInfoInRecyccelView(ArrayList<Station> allStationInfoArrayList){

        /*This Method is responsible to display all information about stations in recycler view  */

        secondActivity.recyclerView.setAdapter(new MyRecyclerViewAdapter(allStationInfoArrayList,secondActivity));

    }



}



















