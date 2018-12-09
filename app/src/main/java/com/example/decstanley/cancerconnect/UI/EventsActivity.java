package com.example.decstanley.cancerconnect.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.decstanley.cancerconnect.Objects.Contact;
import com.example.decstanley.cancerconnect.Objects.ContactsAdapter;
import com.example.decstanley.cancerconnect.Objects.EventListAdapter;
import com.example.decstanley.cancerconnect.Objects.Event;
import com.example.decstanley.cancerconnect.R;

import java.util.ArrayList;
import java.util.Date;


public class EventsActivity extends AppCompatActivity{

    ArrayList<Event> events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // ...
        // Lookup the recyclerview in activity layout

        /*super.onCreate(savedInstanceState);
        setContentView(R.layout.events_screen);
        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.eventList);

        // Initialize contacts
        contacts = Contact.createContactsList(20);
        // Create adapter passing in the sample user data
        EventListAdapter adapter = new EventListAdapter(contacts);
        // Attach the adapter to the recyclerview to populate items
        rvContacts.setAdapter(adapter);
        // Set layout manager to position the items
        rvContacts.setLayoutManager(new LinearLayoutManager(this));
        // That's all! */

        super.onCreate(savedInstanceState);
        setContentView(R.layout.events_screen);
        RecyclerView rvEvents = (RecyclerView) findViewById(R.id.eventList);

        // Initialize contacts
        Date testDate = new Date();

        events = new ArrayList<Event>();

        for (int i = 1; i <= 10; i++) {
            events.add(new Event("TEST" + i, "USER1","TEST EVENT", testDate, testDate, 20, 30, "First test event for recyclerview", true));
        }



        // Create adapter passing in the sample user data
        EventListAdapter adapter = new EventListAdapter(events);
        // Attach the adapter to the recyclerview to populate items
        rvEvents.setAdapter(adapter);
        // Set layout manager to position the items
        rvEvents.setLayoutManager(new LinearLayoutManager(this));
        // That's all!


    }
}
