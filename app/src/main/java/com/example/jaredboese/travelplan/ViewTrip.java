package com.example.jaredboese.travelplan;

import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

public class ViewTrip extends CoreActivity {
    private ListView mListview;
    private FirebaseDatabase mDatabase;
    private DatabaseReference mRef2;
    private ArrayList mArray;
    private String mKey;

    public static final String EXTRA_POST_KEY = "post_key";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_trip);
        //  mDatabase = FirebaseDatabase.getInstance();
     //   mRef = FirebaseDatabase.getInstance().getReference();
        mRef2 = FirebaseDatabase.getInstance().getReference().child("TripID");

        mListview = (ListView) findViewById(R.id.listview);
        mArray = new ArrayList();

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, mArray);

        mListview.setAdapter(arrayAdapter);


        mRef2.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String value = dataSnapshot.getValue(String.class);
               // String sdate = dataSnapshot.getValue()
                mArray.add(value);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }
}
/*
        mKey = getIntent().getStringExtra(EXTRA_POST_KEY);
        if (mKey == null) {
            throw new IllegalArgumentException("Must pass EXTRA_POST_KEY");
        }

        mRef = FirebaseDatabase.getInstance().getReference().child("Placeholder").child(mKey);
        mEndRef = FirebaseDatabase.getInstance().getReference().child("Placeholder").child(mKey);


    }*/

  /*      ChildEventListener childeventlistener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String startdate = dataSnapshot.getValue(String.class);
                Startdate.setText(startdate);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                String newdate = dataSnapshot.getValue(String.class);
                String datekey = dataSnapshot.getKey();
                Startdate.setText(newdate);

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        mRef.addChildEventListener(childeventlistener);
        */

/*        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String string = dataSnapshot.getValue(String.class);
                Startdate.setText(string);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Startdate.setText("Failed");

            }
        });*/

  //  @Override
/*    protected void onStart() {
        super.onStart();
        ValueEventListener datelistener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Newtrip.TripInfo tripinfo = dataSnapshot.getValue(Newtrip.TripInfo.class);
               // String string = dataSnapshot.getValue(String.class);
                Startdate.setText(tripinfo.StartDate);
                Enddate.setText(tripinfo.EndDate);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("TAG", "loadPost:onCancelled", databaseError.toException());
                Toast.makeText(ViewTrip.this, "Failed to load viewtrip.",
                        Toast.LENGTH_SHORT).show();
            }
        };*/
   // }
