package com.nisith.sqlitedatabaseexample;

public class UserInfo {

    private String userName;
    private String password;
    private String date;

    public UserInfo(String userName, String password,String date) {
        this.userName = userName;
        this.password = password;
        this.date = date;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getDate(){
        return date;
    }
}
