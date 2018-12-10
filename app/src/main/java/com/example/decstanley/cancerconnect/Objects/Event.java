package com.example.decstanley.cancerconnect.Objects;

import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.Date;

public class Event {
    private String eventID;
    private String eventTitle;
    private String eventCreator;
    private Date startDateTime;
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
        startDateTime = document.getDate("StartDate");
        eventSummary = document.getString("Summary");
        eventTitle = document.getString("Title");
        town = document.getString("Town");
        distance = -1;
    }


    public Event(String eventID,String eventTitle, Date startDateTime, double longitude,double latitude,String address,String town,String county,String postcode, String eventSummary) {
        this.eventID = eventID;
        this.eventTitle = eventTitle;
        this.eventCreator = eventCreator;
        this.startDateTime = startDateTime;
        this.longitude = longitude;
        this.latitude = latitude;
        this.address = address;
        this.town = town;
        this.county = county;
        this.postcode = postcode;
        this.eventSummary = eventSummary;
        distance = -1;
    }


    public Date getStartDateTime() {
        return startDateTime;
    }

    public boolean changeStartDateTime(Date startDateTime) {
        try {
            this.startDateTime = startDateTime;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

/*    public Date getEndDate() {
        return endDate;
    }

    public boolean changeEndDate(Date endDate) {
        try {
            this.endDate = endDate;
            return true;
        } catch (Exception e) {
            return false;
        }
    }
*/

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


/*    public boolean addNewPerson(String userID) {
        try {
            peopleAttending.add(userID);
            return true;
        } catch (Exception e) {
            return false;
        }
    }*/

    public void setDistance(double currLat, double currLong)
    {
        double dLat = Math.toRadians(latitude - currLat);
        double dLon = Math.toRadians(longitude - currLong);
        currLat = Math.toRadians(currLat);
        latitude = Math.toRadians(latitude);

        double a = Math.pow(Math.sin(dLat / 2),2) + Math.pow(Math.sin(dLon / 2),2) * Math.cos(currLat) * Math.cos(latitude);
        double c = 2 * Math.asin(Math.sqrt(a));
        distance = 6372.8 * c;
    }


    public double getLongitude(){return longitude;}

    public double getLatitude(){return latitude;}

    public String getTitle(){return eventTitle;}

    public String getEventID(){return eventID;}

    public String getPostcode(){return postcode;}

    public double getDistance(){return distance;}
}


