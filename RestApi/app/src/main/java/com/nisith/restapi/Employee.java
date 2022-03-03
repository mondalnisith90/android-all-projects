package com.nisith.restapi;

import com.google.gson.annotations.SerializedName;

public class Employee {

    private String name;
    private int age;
    private int id;
    private Address eAddress;

    public Employee(int id,String name,int age,Address eAddress) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.eAddress = eAddress;
    }
}
