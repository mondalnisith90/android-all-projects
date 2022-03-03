package com.nisith.restapi;

public class Address {

    private String cityName;
    private String country;

    public Address(String cityName,String country){
        this.cityName = cityName;
        this.country = country;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCityName() {
        return cityName;
    }

    public String getCountry() {
        return country;
    }
}
