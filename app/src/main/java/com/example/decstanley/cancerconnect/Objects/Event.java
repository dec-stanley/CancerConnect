package com.example.decstanley.cancerconnect.Objects;
import java.util.ArrayList;
import java.util.Date;

public class Event {
    private String eventID;
    private String eventTitle;
    private String eventCreator;
    private Date startDate;
    private Date endDate;
    private int longitude;
    private int latitude;
    private String eventSummary;
    private boolean inviteOnly;
    private ArrayList<String> peopleAttending;

    public Event(String eventID,String eventTitle, String eventCreator, Date startDate, Date endDate, int longitude,int latitude, String eventSummary, boolean inviteOnly) {
        this.eventID = eventID;
        this.eventTitle = eventTitle;
        this.eventCreator = eventCreator;
        this.startDate = startDate;
        this.endDate = endDate;
        this.longitude = longitude;
        this.latitude = latitude;
        this.eventSummary = eventSummary;
        this.inviteOnly = inviteOnly;
        peopleAttending = new ArrayList();


    }

    public Date getStartDate() {
        return startDate;
    }

    public boolean changeStartDate(Date startDate) {
        try {
            this.startDate = startDate;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Date getEndDate() {
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

    public boolean isInviteOnly() {
        return inviteOnly;
    }

    public boolean setInviteOnly(boolean inviteOnly) {
        try {
            this.inviteOnly = inviteOnly;
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

    public boolean addNewPerson(String userID) {
        try {
            peopleAttending.add(userID);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public int getLongitude(){return longitude;}

    public int getLatitude(){return latitude;}

    public String getTitle(){return eventTitle;}
}

