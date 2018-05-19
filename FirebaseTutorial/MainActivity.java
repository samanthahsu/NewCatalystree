package com.example.newcatalystree;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    EditText KeyValue, KeyName;
    Button ApplyButton;
    String myStringData, myKeyValueData;

    Firebase myFirebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        KeyValue = findViewById(R.id.editText);
        KeyName = findViewById(R.id.editText2);
        ApplyButton = findViewById(R.id.button);

        Firebase.setAndroidContext(this);

//        todo: change to instance ID
        // get the device ID of the user's phone
        String DeviceID = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);

//        gives root for new branches in firebase
//        will create subcategory of device ID - and under that its values
        myFirebase = new Firebase("https://new-catalystree.firebaseio.com/Users" + DeviceID);

        ApplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myStringData = KeyValue.getText().toString();
                myKeyValueData = KeyName.getText().toString();
//                KeyName is set as the name of the child
                Firebase myNewChild = myFirebase.child(myKeyValueData);
                myNewChild.setValue(myStringData);
                Toast.makeText(MainActivity.this, myStringData + " is updated with " + myKeyValueData, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
