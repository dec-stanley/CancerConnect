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

    public boolean sendMessage(){
        return false;
    }

    public boolean reportUser(){
        return false;
    }
}
