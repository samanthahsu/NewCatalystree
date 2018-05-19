package com.example.newcatalystree;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        check for internet connection first, otherwise all is moot
        GetMyPermission();

    }

    private void GetMyPermission() {
        Firebase MyFirebase = new Firebase("https://new-catalystree.firebaseio.com/permission");
        MyFirebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String myString = dataSnapshot.getValue(String.class);

                if (myString.equals("allow")) {
                    Toast.makeText(MainActivity.this, "GOOD", Toast.LENGTH_SHORT).show();
                } else if (myString.equals("temp")) {
                    Toast.makeText(MainActivity.this, "Hi Guest", Toast.LENGTH_SHORT).show();
                }
                else {
                    finish();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        GetMyPermission();
    }

    @Override
    protected void onStart() {
        super.onStart();
        GetMyPermission();
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
