package com.example.newcatalystree;

import android.app.Application;

import com.firebase.client.Firebase;
import com.google.firebase.database.FirebaseDatabase;

// class added to manifest

public class GlobalActivity extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

//        spreads firebase throughout app so we dont have to write this line in every class
        Firebase.setAndroidContext(this);
        FirebaseDatabase.getInstance().setPersistenceEnabled(true); // store offline data
    }
}
