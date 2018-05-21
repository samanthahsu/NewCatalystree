package com.example.newcatalystree;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements SignUp.OnFragmentInteractionListener {

    private Button btLogIn;
    private Fragment mLogIn;
    FrameLayout fragContainer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btSignUp = findViewById(R.id.btSignUpMain);
        fragContainer = findViewById(R.id.flFragContainer);

//        sign up button opens sign up fragment when clicked
        btSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignUpFragment();
            }
        });


/*
//        login button opens login fragment when clicked
        btLogIn = findViewById(R.id.btLogIn);
        btSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                mLogIn = new LogIn();
                transaction.replace(R.id.flFragContainer, mLogIn);
                transaction.commit();
            }
        }); // todo: create proper login fragment after making sure the signup works
*/
    }

    private void openSignUpFragment() {
        SignUp fragment = SignUp.newInstance(); // calling method inside fragment
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
