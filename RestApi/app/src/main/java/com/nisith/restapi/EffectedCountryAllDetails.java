package com.nisith.restapi;

public class EffectedCountryAllDetails {

    private String id;
    private String country_name;
    private String total_cases;
    private String new_cases;
    private String active_cases;
    private String total_deaths;
    private String new_deaths;
    private String total_recovered;
    private String serious_critical;
    private String region;
    private String total_cases_per1m;
    private String record_date;
    private String deaths_per1m;
    private String total_tests;
    private String total_tests_per1m;
    private String record_date_pure;

    public EffectedCountryAllDetails(){}

    public EffectedCountryAllDetails(String id, String country_name, String total_cases, String new_cases, String active_cases, String total_deaths, String new_deaths, String total_recovered, String serious_critical, String region, String total_cases_per1m, String record_date, String deaths_per1m, String total_tests, String total_tests_per1m, String record_date_pure) {
        this.id = id;
        this.country_name = country_name;
        this.total_cases = total_cases;
        this.new_cases = new_cases;
        this.active_cases = active_cases;
        this.total_deaths = total_deaths;
        this.new_deaths = new_deaths;
        this.total_recovered = total_recovered;
        this.serious_critical = serious_critical;
        this.region = region;
        this.total_cases_per1m = total_cases_per1m;
        this.record_date = record_date;
        this.deaths_per1m = deaths_per1m;
        this.total_tests = total_tests;
        this.total_tests_per1m = total_tests_per1m;
        this.record_date_pure = record_date_pure;
    }

    public String getCountry_name(){
        return country_name;
    }

    public String getTotal_cases(){
        return total_cases;
    }

}
