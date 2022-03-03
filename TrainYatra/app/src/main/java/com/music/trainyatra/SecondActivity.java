package com.music.trainyatra;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.icu.text.IDNA;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity implements MyRecyclerViewAdapter.OnCardViewClickListener {


    protected  TextView trainNameTextView,sourceStationNameTextView,destinationStationNameTextView;
    protected  RecyclerView recyclerView;
    protected Button searchButton;
    protected RelativeLayout resultWindow;
    protected MenuItem hide_result;
    protected EditText input_train_number;
    private MySharedPraferance mySharedPraferance;
    protected ProgressBar progressBar;
    private BackgroundTask backgroundTask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar appToolbar = findViewById(R.id.app_toolbar);
        setSupportActionBar(appToolbar);
        setTitle("TRAIN YATRA");
        recyclerView = findViewById(R.id.recycler_view);
        searchButton = findViewById(R.id.search_button);
        input_train_number = findViewById(R.id.train_no_edit_text);
        progressBar = findViewById(R.id.progress_bar);
        trainNameTextView = findViewById(R.id.train_name);
        sourceStationNameTextView = findViewById(R.id.station_name);
        destinationStationNameTextView = findViewById(R.id.destination_station);
        resultWindow = findViewById(R.id.result_window);
        Button runningDaysButton = findViewById(R.id.running_day_button);
        Button availableClassesButton = findViewById(R.id.available_class_button);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        searchButton.setOnClickListener(new MySearchButtonClick());
        runningDaysButton.setOnClickListener(new MyRunningDayButtonClick());
        availableClassesButton.setOnClickListener(new MyAvailableClassesButtonClick());
        mySharedPraferance = new MySharedPraferance( this,"API_KEY_FILE");

    }


    @Override
    public void onBackPressed() {
        /* if result Window is Visible then on back press the result window will gone and Edit text and search button will display
            But if the user is already see edit text and search button then on back press the current activity will destroyed */
        if (resultWindow.getVisibility()==View.VISIBLE){
            //result window disappear
            resultWindow.setVisibility(View.GONE);
            hide_result.setVisible(false);
            searchButton.setVisibility(View.VISIBLE);
            input_train_number.setVisibility(View.VISIBLE);
        }else {
            //activity will destroyed
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.app_menu,menu);
        hide_result = menu.findItem(R.id.hide_result);
        hide_result.setVisible(false);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.hide_result:
                searchButton.setVisibility(View.VISIBLE);
                input_train_number.setVisibility(View.VISIBLE);
                resultWindow.setVisibility(View.GONE);
                hide_result.setVisible(false); // hide The Cross mark in toolbar


                break;

            case R.id.change_api_key:
                showDialog(mySharedPraferance);//class method to display alert Dialog
                break;

            case R.id.about_us:
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    public void onCardViewClick(int position) {

        /* This method is called when cardView is Clicked .This method is belongs to OnCardViewClickListener interface */

        ArrayList<Station> allStationInfoArrayList = backgroundTask.getAllStationInfoArrayList();
        if (allStationInfoArrayList != null){
            Intent intent = new Intent(SecondActivity.this,CardViewResultActivity.class);
            Station stationObject = allStationInfoArrayList.get(position);
            intent.putExtra("station_name",stationObject.getStationName());
            intent.putExtra("arriavle_time",stationObject.getArriavleTime());
            intent.putExtra("departure_time",stationObject.getDepartureTime());
            intent.putExtra("distance",""+stationObject.getDistance());
            intent.putExtra("day",""+stationObject.getRunningDay());
            intent.putExtra("halt_time",""+stationObject.getHalt());
            intent.putExtra("source_station",""+allStationInfoArrayList.get(0).getStationName());
            startActivity(intent);
        }

    }


    private class MySearchButtonClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {   //this method will call when search button is Clicked
            String user_input = input_train_number.getText().toString();//user input from edit text
            String api_key =mySharedPraferance.getData("api_key");
            boolean checkValue = checkUserInput(user_input);
            if (checkValue) {
                if (api_key.length() < 1) {
                    showDialog(mySharedPraferance);  //class method to display alert Dialog
                } else {  //if checkValue is true means User Enter Valid input in Edit Text
                    String string_url = "https://api.railwayapi.com/v2/route/train/" + user_input + "/apikey/" + api_key + "/";
                    if (isInternetAvailable()){
                        //internate is available
                         backgroundTask= new BackgroundTask(SecondActivity.this, string_url);
                        backgroundTask.execute();
                    }else {
                        //internate is not available
                        AlertDialogForInternateConnectionFaild alertDialogForInternateConnectionFaild = new AlertDialogForInternateConnectionFaild();
                        alertDialogForInternateConnectionFaild.show(getSupportFragmentManager(),"NISITH");
                    }
                }
            }




        }









        private boolean checkUserInput(String user_input){
            boolean cheakValue = false;
            if(input_train_number.getText().toString().length()>0){

                try {
                    Long.parseLong(user_input);// if user enter any alphabates then it can not parse into int .i.e. it throws an Exception
                    //if user enter number then it's OK and Excption Not Generated
                    // input is Ok . Now
                    cheakValue = true;


                }catch (Exception error){
                    Toast.makeText(SecondActivity.this, "Input Must be  Numbers", Toast.LENGTH_SHORT).show();
                }

            }else {
                Toast.makeText(SecondActivity.this, "Enter Train Number", Toast.LENGTH_SHORT).show();
            }

            return cheakValue;

        }
    }



    private class MyRunningDayButtonClick implements View.OnClickListener{

        //this method will trigger when any one press Running Days button of Display
        @Override
        public void onClick(View v) {
            Train trainInfoObject = backgroundTask.getTrainInfoObject();
            if (trainInfoObject != null){
                AlertDialogForTrainRunningDays alertDialog = new AlertDialogForTrainRunningDays(trainInfoObject.getTrainRunningDaysInfoArrayList());
                alertDialog.show(getSupportFragmentManager(),"NISITH");
            }

        }
    }



    private class MyAvailableClassesButtonClick implements View.OnClickListener{
        //this method will trigger when any one press Available Classes button of Display
        @Override
        public void onClick(View v) {
           ArrayList<Train.TrainClasses> trainClassesInfoArrayList = backgroundTask.getTrainClassesInfoArrayList();
           if (trainClassesInfoArrayList != null) {
               AlertDialogForAvailableClassesOfTrain alertDialog = new AlertDialogForAvailableClassesOfTrain(trainClassesInfoArrayList);
               alertDialog.show(getSupportFragmentManager(), "NISITH");
           }

        }
    }

    private void showDialog(MySharedPraferance mySharedPraferance){
        AlertDialogForApiKey alertDialogForApiKey = new AlertDialogForApiKey(mySharedPraferance);
        alertDialogForApiKey.show(getSupportFragmentManager(),"NISITH");
    }


    private boolean isInternetAvailable() {
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


//ov9glyjqbi
