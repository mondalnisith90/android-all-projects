package com.nisith.restapi;

import java.util.List;

public class CountryInfo {
    private String country;
    private List<EffectedCountryAllDetails> latest_stat_by_country;

    public CountryInfo(String country, List<EffectedCountryAllDetails> latest_stat_by_country) {
        this.country = country;
        this.latest_stat_by_country = latest_stat_by_country;
    }

    public String getCountry() {
        return country;
    }

    public List<EffectedCountryAllDetails> getLatest_stat_by_country() {
        return latest_stat_by_country;
    }
}
