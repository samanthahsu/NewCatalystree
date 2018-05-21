package com.example.newcatalystree;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;

public class LoadingActivity extends AppCompatActivity {

    private FirebaseAuth myFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//       todo: idk what thread does but it works so whatever
        Thread welcomeThread = new Thread() {

            @Override
            public void run() {
        //        if there is already an existing logged in user
                myFirebaseAuth = FirebaseAuth.getInstance();

                if (myFirebaseAuth.getCurrentUser() != null) {
                    Intent homeIntent = new Intent(LoadingActivity.this, HomeActivity.class);
                    startActivity(homeIntent);
                    finish();

                } else {
                    Intent homeIntent = new Intent(LoadingActivity.this, MainActivity.class);
                    startActivity(homeIntent);
                    finish();
                }
            }
        };
        welcomeThread.start();
    }
}
