package com.example.decstanley.cancerconnect.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.decstanley.cancerconnect.Objects.EventListAdapter;
import com.example.decstanley.cancerconnect.Objects.Event;
import com.example.decstanley.cancerconnect.R;

import java.util.ArrayList;
import java.util.Calendar;


public class EventsActivity extends AppCompatActivity{

    ArrayList<Event> events;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.events_screen);
        RecyclerView rvEvents = (RecyclerView) findViewById(R.id.eventList);
        email = getIntent().getStringExtra("EMAIL");

        // Initialize contacts
        Calendar testDateTime = null;

        events = new ArrayList<Event>();

        for (int i = 1; i <= 10; i++) {
            events.add(new Event("TEST" + i, "USER1","TEST EVENT", testDateTime, 20, 30, "First test event for recyclerview"));
        }



        // Create adapter passing in the sample user data
        EventListAdapter adapter = new EventListAdapter(events);
        // Attach the adapter to the recyclerview to populate items
        rvEvents.setAdapter(adapter);
        // Set layout manager to position the items
        rvEvents.setLayoutManager(new LinearLayoutManager(this));
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
    }
}
