package com.example.jaredboese.travelplan;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static com.example.jaredboese.travelplan.CoreActivity.TAG;

/**
 * Created by Jared Boese on 10/17/2017.
 */


public class Newtrip extends Activity {
    private EditText StartDate, EndDate;
    private Button Addbutton;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> arrayList;
    private DatabaseReference mDatabase;

    //  public static final String TAG = "Mytravels";
    public class TripInfo{
        public String StartDate;
        public String EndDate;

        public TripInfo() {

        }
        public TripInfo(String StartDate, String EndDate){
            this.StartDate = StartDate;
            this.EndDate = EndDate;
        }

    }

    private void WriteToFB(String TripID,String StartDate, String EndDate){
        TripInfo tripinfo = new TripInfo(StartDate, EndDate);



        mDatabase.child("StartDate").child(TripID).setValue(StartDate);
        mDatabase.child("EndDate").child(TripID).setValue(EndDate);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.tripscreen);
        StartDate = (EditText) findViewById(R.id.EnterDate);
        EndDate = (EditText)findViewById(R.id.enddate);
        StartDate.setText("mm/dd/yyyy");
        EndDate.setText("mm/dd/yyyy");
        //new DateInput(StartDate);
        Addbutton = (Button)findViewById(R.id.button2);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
       final String strDate = dateFormat.format(date).toString();
       // final String string = new DateInput(StartDate).toString();
       // Tester.setText(sutring);




        Addbutton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String startdate = StartDate.getText().toString();
                String enddate = EndDate.getText().toString();
                WriteToFB("Placeholder",startdate,enddate);

                //ester.setText(strDate);
            }
        });



    }




}


 /*       editTxt = (EditText) findViewById(R.id.EditText);
        button = (Button) findViewById(R.id.button);
        rbutton = (Button) findViewById(R.id.Rbutton);
        listview = (ListView) findViewById(R.id.ListView);
        arrayList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item, arrayList);

        listview.setAdapter(adapter);
        Object o = new Object();

        button.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View v) {
                arrayList.add(editTxt.getText().toString());

                adapter.notifyDataSetChanged();
                Log.d(TAG, "onClick: Size is" + arrayList.size());
            }
        });


        rbutton.setOnClickListener(new OnClickListener()
        {


            @Override
            public void onClick(View v) {
                int size = arrayList.size();
                String Toremove = new String();
                for(int i = 0;i<size;i++){
                    Toremove = Integer.toString(i);
                }
                adapter.remove(Toremove);
                adapter.notifyDataSetChanged();
            }
        });


        FBDatabase mDB = new FBDatabase();
        FBDatabase.testread();
    }

*/

