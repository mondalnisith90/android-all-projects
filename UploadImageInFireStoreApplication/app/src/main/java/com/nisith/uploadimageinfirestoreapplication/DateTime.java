package com.nisith.uploadimageinfirestoreapplication;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTime {
    private String currentDate;
    private String currentTime;

    public DateTime(){
        Calendar calendar = Calendar.getInstance();
        currentDate = DateFormat.getDateInstance(DateFormat.LONG).format(calendar.getTime());
        SimpleDateFormat format = new SimpleDateFormat("hh:mm aa");
        Date date = new Date();
        currentTime = format.format(date);
    }

    public String getDate() {
        return currentDate;
    }

    public String getCurrentTime() {
        return currentTime;
    }
    public String getCurrentDateTime(){
        return currentDate + "  " +currentTime;
    }
}
