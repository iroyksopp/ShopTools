package com.example.toolsshop;

import androidx.annotation.NonNull;

public class Drill {
    private String title;
    private String description;
    private int imageResourceId;


    public Drill(String title, String description, int imageResourceId) {
        this.title = title;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {  return description;}

    public int getImageResourceId() {return imageResourceId;}

    @NonNull
    @Override
    public String toString() {
        return title;
    }
}
