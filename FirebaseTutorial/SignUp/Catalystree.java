package com.example.newcatalystree;

import android.app.Application;

import com.firebase.client.Firebase;

// class added to manifest

public class Catalystree extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

//        spreads firebase throughout app so we dont have to write this line in every class
        Firebase.setAndroidContext(this);
    }
}
