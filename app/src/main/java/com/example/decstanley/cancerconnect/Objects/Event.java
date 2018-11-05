package com.example.decstanley.cancerconnect.Objects;
import java.util.ArrayList;
public class Event {
    private int eventID;
    private String eventTitle;
    private int eventCreator;
    private String startDate;
    private String endDate;
    private String eventAddress;
    private String eventSummary;
    private boolean inviteOnly;
    private ArrayList<Integer> peopleAttending;

    Event(int eventID, int eventCreator, String startDate, String endDate, String eventAddress, String eventSummary, boolean inviteOnly) {
        this.eventID = eventID;
        this.eventCreator = eventCreator;
        this.startDate = startDate;
        this.endDate = endDate;
        this.eventAddress = eventAddress;
        this.eventSummary = eventSummary;
        this.inviteOnly = inviteOnly;


    }

    public String getStartDate() {
        return startDate;
    }

    public boolean changeStartDate(String startDate) {
        try {
            this.startDate = startDate;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getEndDate() {
        return endDate;
    }

    public boolean changeEndDate(String endDate) {
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

    public String getEventAddress() {
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

    public boolean addNewPerson(int userID) {
        try {
            peopleAttending.add(userID);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

