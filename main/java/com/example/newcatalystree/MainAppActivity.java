package com.example.newcatalystree;
import android.arch.persistence.room.Room;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.example.newcatalystree.LocalDatabase.MyAppDatabase;


/** Last updated: 6/13
 * Main container of the whole app, holds navigation buttons and all app fragments except sign up stuff **/

public class MainAppActivity extends AppCompatActivity implements MapFragment.OnFragmentInteractionListener, ChallengeFragment.OnFragmentInteractionListener,
ArchiveFragment.OnFragmentInteractionListener, SettingsFragment.OnFragmentInteractionListener, ChallengeTaskFractal.OnFragmentInteractionListener{
    public static FragmentManager fragmentManager;
    public static MyAppDatabase myAppDatabase;

    private ImageButton btMap, btChallenges, btArchive, btSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_app);

        fragmentManager = getSupportFragmentManager();
//        myAppDatabase = Room.databaseBuilder(getApplicationContext(), MyAppDatabase.class, "userdb").build();
        myAppDatabase = Room.databaseBuilder(getApplicationContext(), MyAppDatabase.class, "map_tile").allowMainThreadQueries().build();

        if(findViewById(R.id.fragment_container)!=null) {
            if(savedInstanceState!=null) {
                return;
            }
            fragmentManager.beginTransaction().add(R.id.fragment_container, new MapFragment()).commit();
        }

        btMap = findViewById(R.id.btMap);
        btMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMapFragment();
            }
        });

        btChallenges = findViewById(R.id.btChallenges);
        btChallenges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openChallengesFragment();
            }
        });

        btArchive = findViewById(R.id.btArchive);
        btArchive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openArchiveFragment();
            }
        });

        btSettings = findViewById(R.id.btSettings);
        btSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSettingsFragment();
            }
        });
    }

    private void openMapFragment() {
        MapFragment fragment = MapFragment.newInstance(); // calling method inside fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.addToBackStack(null); // allows < to close only this frag not whole activity
        transaction.replace(R.id.fragment_container, fragment).commit(); //.commit() executes line
    }

    private void openChallengesFragment() {
        ChallengeFragment fragment = ChallengeFragment.newInstance(); // calling method inside fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.addToBackStack(null); // allows < to close only this frag not whole activity
        transaction.replace(R.id.fragment_container, fragment).commit(); //.commit() executes line
    }

    private void openArchiveFragment() {
        ArchiveFragment fragment = ArchiveFragment.newInstance(); // calling method inside fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.addToBackStack(null); // allows < to close only this frag not whole activity
        transaction.replace(R.id.fragment_container, fragment).commit(); //.commit() executes line
    }

    private void openSettingsFragment() {
        SettingsFragment fragment = SettingsFragment.newInstance(); // calling method inside fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.addToBackStack(null); // allows < to close only this frag not whole activity
        transaction.replace(R.id.fragment_container, fragment).commit(); //.commit() executes line
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
    }
}

