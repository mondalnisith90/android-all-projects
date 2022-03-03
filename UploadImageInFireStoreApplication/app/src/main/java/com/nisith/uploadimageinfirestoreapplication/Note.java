package com.nisith.uploadimageinfirestoreapplication;

public class Note {
    private String title;
    private String description;
    private String photoUrl;
    private String lastModified;
    public Note(){
        //Empty Constructor is Needed for FireBase
    }
    public Note(String title, String description, String photoUrl, String lastModified){
        this.title = title;
        this.description = description;
        this.photoUrl = photoUrl;
        this.lastModified = lastModified;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public String getLastModified() {
        return lastModified;
    }
}
