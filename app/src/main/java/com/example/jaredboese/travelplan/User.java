package com.example.jaredboese.travelplan;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Jared Boese on 11/30/2017.
 */

public class User {

    FirebaseUser fbUser = FirebaseAuth.getInstance().getCurrentUser();

    String name() { return fbUser.getDisplayName(); }

    boolean exists(String user) {
// valid messages must be readable as an unathenticated user for this to work (firebase->db console->database [rules tab]
        DatabaseReference mDatabase;
// Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");
        return false;
    }

}

