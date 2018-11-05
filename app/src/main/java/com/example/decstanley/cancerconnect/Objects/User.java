package com.example.decstanley.cancerconnect.Objects;

import android.media.Image;

import java.util.ArrayList;
import java.util.Date;

public class User {

    private char userID;
    private String fullName;
    private String username;
    private String emailAddress;
    private Date dob;
    private Image profilePicture;
    private boolean active;
    private Date joinDate;
    private ArrayList<Friend> friends;
    private ArrayList<Post> posts;

    // debateable friendRequest
    private ArrayList<User> friendRequest;

    public boolean sendMessage(){
        return false;
    }

    public boolean reportUser(User user){
        try{
            // try to report user

        }catch(Exception e) {
            // did ot work
            return false;
        }
        return true;
    }

    public boolean addFriend(User user){
        try{
            // try to add friend to array list

            //add friend to database

        }catch(Exception e) {
            // did not work
            return false;
        }
        return true;
    }
    public boolean acceptFriend(){
        return false;
    }

}
