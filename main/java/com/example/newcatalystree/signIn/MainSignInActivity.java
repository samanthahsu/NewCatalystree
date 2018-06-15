package com.example.newcatalystree.signIn;

import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.newcatalystree.R;

public class MainSignInActivity extends AppCompatActivity implements SignUpFragment.OnFragmentInteractionListener, LogInFragment.OnFragmentInteractionListener {

    FrameLayout fragContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sign_in);

        Button btSignUp = findViewById(R.id.btSignUpMain);
        fragContainer = findViewById(R.id.flFragContainer);

//        sign up button opens sign up fragment when clicked
        btSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignUpFragment();
            }
        });

//        login button opens login fragment when clicked
        Button btLogIn = findViewById(R.id.btLogInMain);
        btLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLogInFragment();
            }
        });
    }

    private void openSignUpFragment() {
        SignUpFragment fragment = SignUpFragment.newInstance(); // calling method inside fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.addToBackStack(null); // allows < to close only this frag not whole activity
        transaction.replace(R.id.flFragContainer, fragment).commit(); //.commit() executes line
    }

    private void openLogInFragment() {
        LogInFragment fragment = LogInFragment.newInstance(); // calling method inside fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.addToBackStack(null); // allows < to close only this frag not whole activity
        transaction.replace(R.id.flFragContainer, fragment).commit(); //.commit() executes line
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}