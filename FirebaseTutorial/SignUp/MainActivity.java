package com.example.newcatalystree;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    EditText etEmail, etPass;
    Button btSignUp;
    FirebaseAuth myFirebaseAuth;
    String myEmail, myPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myFirebaseAuth = FirebaseAuth.getInstance();

//        if there is already an existing logged in user
        if (myFirebaseAuth.getCurrentUser() != null) {
            Intent homeIntent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(homeIntent);
            finish();
        } // todo: put this code inside the splash/loading screen

        etEmail = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etPassword);
        btSignUp = findViewById(R.id.btSignUp);


        btSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myEmail = etEmail.getText().toString().trim();
                myPassword = etPass.getText().toString().trim();

                CreateNewUser();
            }
        });

    }

    private void CreateNewUser() {
        myFirebaseAuth.createUserWithEmailAndPassword(myEmail, myPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    Intent homeIntent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(homeIntent);
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "Registration Failed!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
