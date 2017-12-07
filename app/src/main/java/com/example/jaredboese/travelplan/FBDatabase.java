package com.example.jaredboese.travelplan;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Jared Boese on 11/9/2017.
 */

public class FBDatabase extends Newtrip{


    public static class TripInfo{
        public String StartDate;
        public String EndDate;
        public String ArriveTime;
        public String DepartTime;
        public String ArriveLocation;
        public String DepartLocation;

        public TripInfo() {

        }
        public TripInfo(String StartDate, String EndDate, String DepartTime, String ArriveTime,
                        String DepartLocation, String ArriveLocation){
            this.StartDate = StartDate;
            this.EndDate = EndDate;
            this.DepartTime = DepartTime;
            this.ArriveTime = ArriveTime;
            this.DepartLocation = DepartLocation;
            this.ArriveLocation = ArriveLocation;



        }

    }




}
