package com.example.decstanley.cancerconnect.Objects;

import android.media.Image;

import java.util.ArrayList;
import java.util.Date;

public class ValidatedUser extends User {

    protected Events events;

    public ValidatedUser(String userID, String fullName, String username, String emailAddress, Date dob, boolean active, Date joinDate, ArrayList<Friend> friends, ArrayList<Post> posts, ArrayList<User> friendRequest) {
        super(userID, fullName, username, emailAddress, dob, active, joinDate, friends, posts, friendRequest);
        events = new Events();
    }

    public ValidatedUser(String userID, String fullName, String username, String emailAddress, Date dob, Image profilePicture, boolean active, Date joinDate, ArrayList<Friend> friends, ArrayList<Post> posts, ArrayList<User> friendRequest) {
        super(userID, fullName, username, emailAddress, dob, profilePicture, active, joinDate, friends, posts, friendRequest);
    }

    public boolean createEvent(Event event){
        // TODO add event to database
        events.addEvent(event);
        return false;
    }
    public boolean deleteEvent(Event event){
        // TODO make sure  user to delete exist
        // TODO delete user from the array list
        return false;
    }
    public void editEvents(Event event){
        // dont know what this does yet!
    }
}
