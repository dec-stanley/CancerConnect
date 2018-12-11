package com.example.decstanley.cancerconnect.Objects;

import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.Date;

public class Event {
    private String eventID;
    private String eventTitle;
    private String eventCreator;
    private String startDate;
    private String startTime;
    private double longitude;
    private double latitude;
    private String address;
    private String town;
    private String county;
    private String postcode;
    private String eventSummary;
    private double distance;


    public Event(QueryDocumentSnapshot document)
    {
        eventID = document.getId();
        address = document.getString("Address");
        county = document.getString("County");
        latitude = document.getDouble("Latitude");
        longitude = document.getDouble("Longitude");
        postcode = document.getString("Postcode");
        startDate = document.getString("StartDate");
        startTime = document.getString("StartTime");
        eventSummary = document.getString("Summary");
        eventTitle = document.getString("Title");
        town = document.getString("Town");
        distance = -1;
    }


    public Event(String eventID,String eventTitle, String startDate, String startTime, double longitude,double latitude,String address,String town,String county,String postcode, String eventSummary) {
        this.eventID = eventID;
        this.eventTitle = eventTitle;
        this.eventCreator = eventCreator;
        this.startDate = startDate;
        this.startTime = startTime;
        this.longitude = longitude;
        this.latitude = latitude;
        this.address = address;
        this.town = town;
        this.county = county;
        this.postcode = postcode;
        this.eventSummary = eventSummary;
        distance = -1;
    }


    public String getStartDateTime() {
        return startDate;
    }

    public String getStartTime(){return startTime; }

    public boolean changeStartDateTime(String startDateTime) {
        try {
            this.startDate = startDate;
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public String getEventTitle() {
        return eventTitle;
    }

    public boolean changeEventTitle(String eventTitle) {
        try {
            this.eventTitle = eventTitle;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getEventAddress() {
        return address;
    }

    public boolean changeEventAddress(String eventAddress) {
        try {
            this.address = eventAddress;
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public String getEventSummary() {
        return eventSummary;
    }

    public boolean setEventSummary(String eventSummary) {
        try {
            this.eventSummary = eventSummary;
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public double getLongitude(){return longitude;}

    public double getLatitude(){return latitude;}

    public String getTitle(){return eventTitle;}

    public String getEventID(){return eventID;}

    public String getPostcode(){return postcode;}

    public double getDistance(){return distance;}

    public String getTown(){return town;}

    public String getCounty(){return county;}
}


