package com.example.decstanley.cancerconnect.Objects;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;

import com.example.decstanley.cancerconnect.UI.EventsActivity;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.Collections;
import java.util.HashMap;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class Events {
    private ArrayList<Event> events;

    public Events() {
        events = new ArrayList<Event>();
    }

    public boolean addEvent(Event event) {
        try {
            events.add(event);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteEvent(Event event) {
        try {
            events.remove(event);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public ArrayList<Event> searchEvents(String eventName) {
        ArrayList<Event> eventList = new ArrayList();
        for (Event event: events) {
            if (event.getEventTitle().equals(eventName)) {
                eventList.add(event);
            }
        }
        return eventList;
    }
    public ArrayList<Event> searchEvents(Date date) {
        ArrayList<Event> eventList = new ArrayList();
        for (Event event: events) {
            if (event.getStartDateTime().equals(date)) {
                eventList.add(event);
            }
        }
        return eventList;
    }

    public void sortEventsDate() {
        ArrayList<Date> dates = new ArrayList();
        for (Event event: events) {
            dates.add(event.getStartDateTime());
        }
        Collections.sort(dates);
        ArrayList<Event> events = new ArrayList();
        for (Date date: dates) {
            for (Event event: searchEvents(date)) {
                events.add(event);
            }
        }
        this.events = events;
    }

    public void sortEventsDistance(double currLat, double currLong) {
        ArrayList<String> locations = new ArrayList();
        for (Event event: events) {
            if (!locations.contains(event.getPostcode())) locations.add(event.getPostcode());
        }
        HashMap<Double, String> distLoc = new HashMap<>();
        ArrayList<Double> distList = new ArrayList<>();
        for (String location: locations) {
            int index=0;
            Event currEvent = events.get(index);
            while (!location.equals(currEvent.getPostcode())) {
                index++;
                currEvent = events.get(index);
            }
            double dist = calculateDistance(currLat, currLong, currEvent.getLatitude(), currEvent.getLongitude());
            distList.add(dist);
            distLoc.put(dist, location);
        }
        Collections.sort(distList);


        ArrayList<Event> events = new ArrayList();
        for (double dist: distList) {
            String loc = distLoc.get(dist);
            for (Event event: searchEventsDist(loc)) {
                events.add(event);
            }
        }
        this.events = events;
    }


    private ArrayList<Event> searchEventsDist(String postcode) {
        ArrayList<Event> eventList = new ArrayList();
        for (Event event: events) {
            if (event.getPostcode().equals(postcode)) {
                eventList.add(event);
            }
        }
        return eventList;
    }

    private double calculateDistance(double currLat, double currLong, double eventLat, double eventLong) {
        double dLat = Math.toRadians(eventLat - currLat);
        double dLon = Math.toRadians(eventLong - currLong);
        currLat = Math.toRadians(currLat);
        eventLat = Math.toRadians(eventLat);

        double a = Math.pow(Math.sin(dLat / 2),2) + Math.pow(Math.sin(dLon / 2),2) * Math.cos(currLat) * Math.cos(eventLat);
        double c = 2 * Math.asin(Math.sqrt(a));
        return 6372.8 * c;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }
}
