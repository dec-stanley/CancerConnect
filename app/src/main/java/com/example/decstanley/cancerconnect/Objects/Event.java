package com.example.decstanley.cancerconnect.Objects;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Event {
    private String eventID;
    private String eventTitle;
    private String eventCreator;
    private Calendar startDateTime;
    private int longitude;
    private int latitude;
    private String address;
    private String town;
    private String city;
    private String county;
    private String postcode;
    private String eventSummary;

    public Event(String eventID,String eventTitle, String eventCreator, Calendar startDateTime, int longitude,int latitude, String eventSummary) {
        this.eventID = eventID;
        this.eventTitle = eventTitle;
        this.eventCreator = eventCreator;
        this.startDateTime = startDateTime;
        this.longitude = longitude;
        this.latitude = latitude;
        this.eventSummary = eventSummary;



    }

    public Calendar getStartDateTime() {
        return startDateTime;
    }

    public boolean changeStartDateTime(Calendar startDateTime) {
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

/*    public String getEventAddress() {
        return eventAddress;
    }

    public boolean changeEventAddress(String eventAddress) {
        try {
            this.eventAddress = eventAddress;
            return true;
        } catch (Exception e) {
            return false;
        }
    }
*/

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

    public int getLongitude(){return longitude;}

    public int getLatitude(){return latitude;}

    public String getTitle(){return eventTitle;}
}

