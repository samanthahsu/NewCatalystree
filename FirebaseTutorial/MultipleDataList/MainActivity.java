package com.example.newcatalystree;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    ArrayList<String> myArrayList = new ArrayList<>();
    ListView myListView;
    Firebase myFirebase;
//    DatabaseReference myDatabaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myFirebase = new Firebase("https://new-catalystree.firebaseio.com/"); // is replaced by:
//        myDatabaseRef = FirebaseDatabase.getInstance().getReference();
//        myDatabaseRef = FirebaseDatabase.getInstance().getReference().child("User"); // for additional pathing

        final ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, myArrayList);

        myListView = findViewById(R.id.ListView);
        myListView.setAdapter(myArrayAdapter);

//        diff from prev listener
        myFirebase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                puts the data taken from firebase into the string
                String myChildValues = dataSnapshot.getValue(String.class);
//                adds the string to the array
                myArrayList.add(myChildValues);
                myArrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                myArrayAdapter.notifyDataSetChanged();

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                String myChildValues = dataSnapshot.getValue(String.class);
                myArrayList.remove(myChildValues);
                myArrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
