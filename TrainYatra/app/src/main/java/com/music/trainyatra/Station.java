package com.music.trainyatra;

public class Station {
    private String station_name,arriavle_time,departure_time;
    private int halt,station_number,running_day,distance;


    // This class object stores all information about a Station......

    public Station(String station_name, String arriavle_time, String departure_time, int halt, int distance, int running_day,int station_number) {
        this.station_name = station_name;
        this.arriavle_time = arriavle_time;
        this.departure_time = departure_time;
        this.halt = halt;
        this.distance = distance;
        this.running_day = running_day;
        this.station_number = station_number;
    }
  //set Values in Class Attributs
    public void setArriavleTime(String arriavle_time) {
        this.arriavle_time = arriavle_time;
    }

    public void setDepartureTime(String departure_time){
        this.departure_time = departure_time;
    }

    public void setStationName(String station_name){
        this.station_name = station_name;
    }

    public void setHalt(int haltTime){
        this.halt = haltTime;
    }

    public void setRunningDay(int runningDay){
        this.running_day = runningDay;
    }

    public void setDistance(int distance){
        this.distance = distance;
    }

    public void setStationNumber(int station_number) {
        this.station_number = station_number;
    }



 //Get Values about Stations

    public String getStationName() {
        return station_name;
    }

    public int getStationNumber() {
        return station_number;
    }


    public String getArriavleTime() {
        return arriavle_time;
    }

    public String getDepartureTime() {
        return departure_time;
    }

    public int getHalt() {
        return halt;
    }

    public int getDistance() {
        return distance;
    }

    public int getRunningDay() {
        return running_day;
    }
}
