package com.example.jaredboese.travelplan;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends CoreActivity {
    private static final int LOGIN_REQUEST = 1;
   // public static final String TAG = "MainActivity";
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //views
        Button newtrip = (Button) findViewById(R.id.NTbutton);
        Button signowt = (Button) findViewById(R.id.signoutbtn);
        Button viewbutn = (Button) findViewById(R.id.Viewbtn);

       mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // Message is signed in
                    login();
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    logout();
                    // Message is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };

        signowt.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                logout();
            }
        });
        viewbutn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ViewTrip.class);
                MainActivity.this.startActivity(intent);
            }
        });
        newtrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent("com.example.jaredboese.travelplan.tripscreen"));
            }

        });
    }

    @Override
    public void onResume() {
        super.onResume();
        if( FirebaseAuth.getInstance().getCurrentUser() == null) { login(); }

    }


    void logout()
    {
        FirebaseAuth.getInstance().signOut();

    }


    void login() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivityForResult(intent, LOGIN_REQUEST);
    }

}
