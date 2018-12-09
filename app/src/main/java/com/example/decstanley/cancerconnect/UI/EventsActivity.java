package com.example.decstanley.cancerconnect.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.decstanley.cancerconnect.Objects.EventListAdapter;
import com.example.decstanley.cancerconnect.Objects.Event;
import com.example.decstanley.cancerconnect.R;

import java.util.Date;


public class EventsActivity extends AppCompatActivity{
    private Event[] events;
    private RecyclerView eventList;
    private RecyclerView.Adapter eventListAdapter;
    private RecyclerView.LayoutManager eventListLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events_screen);
        eventList = (RecyclerView) findViewById(R.id.eventList);

        //sets constant size to improve performance
        eventList.setHasFixedSize(true);

        //useing linear layout manager on eventlist
        eventListLayoutManager = new LinearLayoutManager(this);
        eventList.setLayoutManager(eventListLayoutManager);

        events = new Event[10];
        Date testDate = new Date();
        events[0] = new Event("TEST1", "USER1", testDate, testDate, 20, 30, "First test event for recyclerview", true);


        eventListAdapter = new EventListAdapter(events);
        eventList.setAdapter(eventListAdapter);
    }

}
