package com.nisith.firestoredemoapplication;

public class Note {
    private String title;
    private String description;
    public Note(){}
    public Note(String title, String description){
        this.title = title;
        this.description = description;
    }

    public String getTitles() {
        return title;
    }

    public String getDescriptions() {
        return description;
    }
}
