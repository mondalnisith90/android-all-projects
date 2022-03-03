package com.example.demo;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
    public ArrayList<File> arrayList;

    public Student()
    {
        arrayList=new ArrayList<>();
        arrayList.add(new File("/0"));
        arrayList.add(new File("/1"));
        arrayList.add(new File("/2"));
    }


}
