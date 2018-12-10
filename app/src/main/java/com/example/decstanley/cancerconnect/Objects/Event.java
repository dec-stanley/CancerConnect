package com.example.decstanley.cancerconnect.Objects;

import java.util.Date;

public class Event {
    private String eventID;
    private String eventTitle;
    private String eventCreator;
    private Date startDateTime;
    private int longitude;
    private int latitude;
    private String address;
    private String town;
    private String county;
    private String postcode;
    private String eventSummary;


    public Event()
    {

    }


    public Event(String eventID,String eventTitle, Date startDateTime, int longitude,int latitude,String address,String town,String county,String postcode, String eventSummary) {
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

    public int getLongitude(){return longitude;}

    public int getLatitude(){return latitude;}

    public String getTitle(){return eventTitle;}

    public String getEventID(){return eventID;}
}

