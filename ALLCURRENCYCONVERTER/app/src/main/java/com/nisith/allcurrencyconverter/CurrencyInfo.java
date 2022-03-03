package com.nisith.allcurrencyconverter;

public class CurrencyInfo {
    private String currencyName;
    private String currencyRate;

    public CurrencyInfo(String currencyName, String currencyRate) {
        this.currencyName = currencyName;
        this.currencyRate = currencyRate;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public String getCurrencyRate() {
        return currencyRate;
    }
}
