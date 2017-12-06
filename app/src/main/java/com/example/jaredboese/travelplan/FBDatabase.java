package com.example.jaredboese.travelplan;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Jared Boese on 11/9/2017.
 */

public class FBDatabase extends Newtrip{




    public static void testread(){
        DatabaseReference mDatabase;
        mDatabase = FirebaseDatabase.getInstance().getReference();
        DatabaseReference users = mDatabase.child("messages");
        mDatabase.setValue("Hello World");

    }

}
