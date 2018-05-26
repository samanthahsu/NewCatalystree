package com.example.newcatalystree;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;


public class HomeActivity extends AppCompatActivity implements ChallengeFragment.OnFragmentInteractionListener,
        MapFragment.OnFragmentInteractionListener, ArchiveFragment.OnFragmentInteractionListener,
        SettingsFragment.OnFragmentInteractionListener{


    //    declare int for board site
    final static int maxN = 25;
    Context context;
    //    declare for imageView (Cells) array
    private ImageView[][] ivCell = new ImageView[maxN][maxN];
    private Drawable[] drawCell = new Drawable[4]; // 0 is empty, 1 is player, 2 is bot, 3 is bg



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
        context = this;
        loadResources();
        designBoardGame();
        updateMap();

        ImageButton btHome = findViewById(R.id.btMap);
        btHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMapActivity();
            }
        });

        ImageButton btChallenges = findViewById(R.id.btChallenges);
        btChallenges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openChallengesFragment();
            }
        });

        ImageButton btArchive = findViewById(R.id.btArchive);
        btArchive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openArchiveFragment();
            }
        });

        ImageButton btSettings = findViewById(R.id.btSettings);
        btSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSettingsFragment();
            }
        });

    }


    private void openMapActivity() {
        MapFragment fragment = MapFragment.newInstance(); // calling method inside fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.addToBackStack(null); // allows < to close only this frag not whole activity
        transaction.replace(R.id.flApp, fragment).commit(); //.commit() executes line        }
    }

    private void openChallengesFragment() {
        ChallengeFragment fragment = ChallengeFragment.newInstance(); // calling method inside fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.addToBackStack(null); // allows < to close only this frag not whole activity
        transaction.replace(R.id.flApp, fragment).commit(); //.commit() executes line
    }

    private void openArchiveFragment() {
        ArchiveFragment fragment = ArchiveFragment.newInstance(); // calling method inside fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.addToBackStack(null); // allows < to close only this frag not whole activity
        transaction.replace(R.id.flApp, fragment).commit(); //.commit() executes line
    }

    private void openSettingsFragment() {
        SettingsFragment fragment = SettingsFragment.newInstance(); // calling method inside fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.addToBackStack(null); // allows < to close only this frag not whole activity
        transaction.replace(R.id.flApp, fragment).commit(); //.commit() executes line
    }

    private void updateMap() {
        ivCell[13][13].setImageDrawable(drawCell[1]); // todo doesnt seem to be able to change the tile...

    }


    private void loadResources() {
        drawCell[3] = context.getResources().getDrawable(R.drawable.cell_bg); // background
        drawCell[0] = null;
        drawCell[1] = context.getResources().getDrawable(R.drawable.sample_tile);
        drawCell[2] = context.getResources().getDrawable(R.drawable.sample_tile_1);
//        copy 2 image for 2 drawable player and bot
//        edit it
    }

    @SuppressLint("NewApi")
    private void designBoardGame() {
//        create layout params to optimize
//        create a horizontal linear layout for a row which contains maxN image view
//        need to find outsize of cell first

        int sizeofCell = Math.round(ScreenWidth() / maxN); // resizes cell according to screen size
        LinearLayout.LayoutParams lpRow = new LinearLayout.LayoutParams(sizeofCell*maxN, sizeofCell);
        LinearLayout.LayoutParams lpCell = new LinearLayout.LayoutParams(sizeofCell, sizeofCell);

        LinearLayout linBoardGame = findViewById(R.id.linBoardGame);

//        create cells
        for(int i = 0; i < maxN; i++) {
            LinearLayout linRow = new LinearLayout(context);

//            make a row
            for (int j = 0; j < maxN; j++) {
//                make a cell
                ivCell[i][j] = new ImageView(context);
//                need to get background default for cell
//                cell has 3 status, empty(default, player, bot
                ivCell[i][j].setBackground(drawCell[2]);
                linRow.addView(ivCell[i][j], lpCell);
            } // for
            linBoardGame.addView(linRow, lpRow);
        } // for
//        ImageView ivX;
//        RelativeLayout rlMapElements = new RelativeLayout();
//        rlMapElements.inflate(ivX);
//
//        onclick of editing button
//        put add button to the top, right, bottom, left, of ivX
//        check if the block is at the extremities of the earth todo: howwwww????
//        put add buttons to all the areas at the extremeties not yet occupied by a block

//        if add button onclick listener, it adds a block at that spot


//        Resources from the R.xx.xx portion of your app, are given an Integer constant as an identifier.
// If you wanted to then make an array of R.drawable.image you could just make it an int[]
//        eg: int[]   mArray = new int[10];
        //    mArray[0] = R.drawable.image1;
        //    mArray[1] = R.drawable.image2;
    }

    private float ScreenWidth() {
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return displayMetrics.widthPixels;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}


