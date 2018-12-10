package com.example.decstanley.cancerconnect.Objects;

import java.util.ArrayList;
import java.util.Date;
import java.util.Collections;

public class Events {
    private ArrayList<Event> events;

    Events() {
        events = new ArrayList();
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
}
