package com.music.trainyatra;

public class ServerResponseInfo {

    private String trainName,trainNumber;
    private int responseCode;
//This Class inform us what is the surver response when we request for JSON from Server . If train number is correct then we get correct response. But
    // if the train number or API KEY is wrong then we get Differnt Response. This Class Contains All proper Information about server Response.....
    public ServerResponseInfo(String trainName, String trainNumber, int responseCode) {
        this.trainName = trainName;
        this.trainNumber = trainNumber;
        this.responseCode = responseCode;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }
}
