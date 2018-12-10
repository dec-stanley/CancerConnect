package com.example.decstanley.cancerconnect.UI;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.decstanley.cancerconnect.Objects.EventListAdapter;
import com.example.decstanley.cancerconnect.Objects.Event;
import com.example.decstanley.cancerconnect.Objects.Events;

import com.example.decstanley.cancerconnect.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.core.Tag;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Calendar;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;


public class EventsActivity extends AppCompatActivity {

    Events events;
    String email;
    // private static final String TAG = "Events";


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.events_screen);
        email = getIntent().getStringExtra("EMAIL");
        ActivityCompat.requestPermissions(EventsActivity.this, new String[]{ACCESS_FINE_LOCATION}, 1);
        if (ActivityCompat.checkSelfPermission(EventsActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(EventsActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        final Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        // Initialize contacts
        Calendar testDateTime = null;

        events = new Events();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Events")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        double currLat, currLong;
                        try {
                            currLat = location.getLatitude();
                            currLong = location.getLongitude();}
                        catch (Exception e) {
                            currLat = 54.176629;
                            currLong = -2.021484;

                        }

                        Event ev;
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            ev = new Event(document);
                            events.addEvent(ev);
                        }

                        events.sortEventsDistance(currLat, currLong);

                        RecyclerView rvEvents = (RecyclerView) findViewById(R.id.eventList);

                        EventListAdapter adapter = new EventListAdapter(events.getEvents());
                        rvEvents.setAdapter(adapter);
                        rvEvents.setLayoutManager(new LinearLayoutManager(EventsActivity.this));

                        }
                        });



        // Create adapter passing in the sample user data
        //Toast.makeText(EventsActivity.this, String.valueOf(events.getEvents().size()), Toast.LENGTH_LONG * 10).show();

        // Attach the adapter to the recyclerview to populate items
        // Set layout manager to position the items
        // That's all!

        setUpButtonListeners(); // sets up the button listeners

    }

    private void setUpButtonListeners(){

        Button addButton = findViewById(R.id.createBtn);
        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(EventsActivity.this , AddEventActivity.class);
                i.putExtra("EMAIL", email);
                startActivity(i);
            }
        });
        /*< /Back button Listener > */

        ImageButton backButton = findViewById(R.id.backButton3);
        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(EventsActivity.this , LoginActivity.class);
                startActivity(i);
            }
        });

        ImageButton refreshButton = findViewById(R.id.refreshButton);
        refreshButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(EventsActivity.this , EventsActivity.class);
                startActivity(i);
            }
        });
    }
}
