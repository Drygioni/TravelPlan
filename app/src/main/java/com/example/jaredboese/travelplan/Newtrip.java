package com.example.jaredboese.travelplan;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Jared Boese on 10/17/2017.
 */


public class Newtrip extends CoreActivity {
    private EditText StartDate, EndDate, DepartTime, ArriveTime,DepartLocation,ArriveLocation ;
    private Button Addbutton;
   // private DatabaseReference mDatabase;


    private void WriteToFB(String TripID,String StartDate, String EndDate, String DepartTime, String ArriveTime,
                           String DepartLocation, String ArriveLocation){
        FBDatabase.TripInfo tripinfo = new FBDatabase.TripInfo(StartDate, EndDate,DepartTime, ArriveTime,
                DepartLocation, ArriveLocation);

        mRef.child(TripID).child("StartDate").setValue(StartDate);
        mRef.child(TripID).child("EndDate").setValue(EndDate);
        mRef.child(TripID).child("DepartTime").setValue(DepartTime);
        mRef.child(TripID).child("ArriveTime").setValue(ArriveTime);
        mRef.child(TripID).child("DepartLocation").setValue(DepartLocation);
        mRef.child(TripID).child("ArriveLocation").setValue(ArriveLocation);


    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //views
        setContentView(R.layout.tripscreen);
        StartDate = (EditText) findViewById(R.id.EnterDate);
        EndDate = (EditText)findViewById(R.id.enddate);
        DepartTime = (EditText)findViewById(R.id.departtime);
        ArriveTime = (EditText) findViewById(R.id.arrivaltime);
        DepartLocation = (EditText) findViewById(R.id.departlocation);
        ArriveLocation = (EditText)findViewById(R.id.arrivelocation);

        Addbutton = (Button)findViewById(R.id.button2);


        new DateInput(StartDate);
        new DateInput(EndDate);

        //init Database
      //  mRef = FirebaseDatabase.getInstance().getReference();



        Addbutton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String startdate = StartDate.getText().toString();
                String enddate = EndDate.getText().toString();
                String departtime = DepartTime.getText().toString();
                String arrivetime = ArriveTime.getText().toString();
                String departlocation = DepartLocation.getText().toString();
                String arrivelocation = ArriveLocation.getText().toString();

                //format data
                startdate = "Start Date: " + startdate;
                enddate = "End Date: " + enddate;
                departtime = "Departure Time: " + departtime;
                arrivetime = "Arrival Time: " + arrivetime;
                departlocation = "Depart From : " + departlocation;
                arrivelocation = "Arrive at :" + arrivelocation;

                WriteToFB("TripID",startdate,enddate,departtime,arrivetime,
                        departlocation,arrivelocation);
                finish();

            }
        });



    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}

