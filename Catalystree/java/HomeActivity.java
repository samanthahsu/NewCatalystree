package com.example.newcatalystree;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;


public class HomeActivity extends AppCompatActivity implements ChallengeFragment.OnFragmentInteractionListener, MapFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


//        todo: open map frag automatically
//        generate this grid of elements based on information in the firebase/database
//        i have no idea.
//        ok, so we start with a square of land, its takes up 50x50 pixels of space on the screen. so the database store the type of land
//        the upgrade level of that land, and randomly generates appearances of hints on that land based on how many we have in the database to dispense.
//        there is a button to turn into editing mode, where buttons are made visible on and around the upgradable areas based on this algorithm
//        that detects which squares are ready to be ugraded, and if adding another square is possible.
//        by clicking the button, it creates a pop up that asks for confirmation and also displays the price for the action.
//
//

        Button btHome = findViewById(R.id.btMap);
        btHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMapActivity();
            }
        });

        Button btChallenges = findViewById(R.id.btChallenges);
        btChallenges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openChallengesFragment();
            }
        });

        Button btArchive = findViewById(R.id.btArchive);
        btArchive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openArchiveFragment();
            }
        });

        Button btSettings = findViewById(R.id.btSettings);
        btSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSettingsFragment();
            }
        });

//        todo: does logout actually logout
        Button btOut = findViewById(R.id.btOut);
        btOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity();
            }
        });
    }

    private void openMainActivity() {
        FirebaseAuth.getInstance().signOut(); // signs out user
        Intent homeIntent = new Intent(HomeActivity.this, MainActivity.class);
        startActivity(homeIntent);
        finish();
    }

    private void openMapActivity() {
        Toast.makeText(this, "map is opened!", Toast.LENGTH_SHORT).show();
        MapFragment fragment = MapFragment.newInstance(); // calling method inside fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.addToBackStack(null); // allows < to close only this frag not whole activity
        transaction.replace(R.id.flApp, fragment).commit(); //.commit() executes line        }
    }

    private void openChallengesFragment() {
        ChallengeFragment fragment = ChallengeFragment.newInstance(); // calling method inside fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.addToBackStack(null); // allows < to close only this frag not whole activity
        transaction.replace(R.id.flApp, fragment).commit(); //.commit() executes line
    }

    private void openArchiveFragment() {
        ChallengeFragment fragment = ChallengeFragment.newInstance(); // calling method inside fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.addToBackStack(null); // allows < to close only this frag not whole activity
        transaction.replace(R.id.flApp, fragment).commit(); //.commit() executes line
    }

    private void openSettingsFragment() {
        ChallengeFragment fragment = ChallengeFragment.newInstance(); // calling method inside fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.addToBackStack(null); // allows < to close only this frag not whole activity
        transaction.replace(R.id.flApp, fragment).commit(); //.commit() executes line
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}


