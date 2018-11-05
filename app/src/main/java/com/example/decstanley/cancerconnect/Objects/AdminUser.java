package com.example.decstanley.cancerconnect.Objects;

import android.media.Image;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends ValidatedUser {

    public AdminUser(String userID, String fullName, String username, String emailAddress, Date dob, boolean active, Date joinDate, ArrayList<Friend> friends, ArrayList<Post> posts, ArrayList<User> friendRequest) {
        super(userID, fullName, username, emailAddress, dob, active, joinDate, friends, posts, friendRequest);
    }

    public AdminUser(String userID, String fullName, String username, String emailAddress, Date dob, Image profilePicture, boolean active, Date joinDate, ArrayList<Friend> friends, ArrayList<Post> posts, ArrayList<User> friendRequest) {
        super(userID, fullName, username, emailAddress, dob, profilePicture, active, joinDate, friends, posts, friendRequest);
    }

     //deleteEvents()
    //+editEvents()
    //+deletePost()
}
