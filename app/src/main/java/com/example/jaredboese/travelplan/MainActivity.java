package com.example.jaredboese.travelplan;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.google.firebase.auth.FirebaseAuth;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
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
        Button newtrip = (Button) findViewById(R.id.NTbutton);
        Button signowt = (Button) findViewById(R.id.signoutbtn);
       // login();
        signowt.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                logout();
            }
        });
        newtrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent("com.example.jaredboese.travelplan.tripscreen"));
            }

        });
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        // Check which request we're responding to
//        Log.i(TAG,"request = " + requestCode + " result = " + resultCode + " (ok=" + RESULT_OK + ")");
//        switch(requestCode) {
//            case LOGIN_REQUEST:
//                // Make sure the request was successful
//                if (resultCode == RESULT_OK) {
//                    Log.i(TAG, "user is " + mAuth.getCurrentUser());
//
//
//                    // The user picked a contact.
//                    // The Intent's data Uri identifies which contact was selected.
//
//                    // Do something with the contact here (bigger example below)
//                } else {
//                    login();
//                }
//                break;
//            default:
//                Log.i(TAG, "no result handler");
//        }
//    }
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
