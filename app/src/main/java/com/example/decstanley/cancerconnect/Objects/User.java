package com.example.decstanley.cancerconnect.Objects;

import android.media.Image;

import java.util.ArrayList;
import java.util.Date;

public class User {

    private String userID;
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


    public User(String userID, String fullName, String username, String emailAddress, Date dob, boolean active, Date joinDate, ArrayList<Friend> friends, ArrayList<Post> posts, ArrayList<User> friendRequest) {
        this.userID = userID;
        this.fullName = fullName;
        this.username = username;
        this.emailAddress = emailAddress;
        this.dob = dob;
        this.profilePicture = null; //TODO set image to default image
        this.active = active;
        this.joinDate = joinDate;
        this.friends = friends;
        this.posts = posts;
        this.friendRequest = friendRequest;
    }


    public User(String userID, String fullName, String username, String emailAddress, Date dob, Image profilePicture, boolean active, Date joinDate, ArrayList<Friend> friends, ArrayList<Post> posts, ArrayList<User> friendRequest) {
        this.userID = userID;
        this.fullName = fullName;
        this.username = username;
        this.emailAddress = emailAddress;
        this.dob = dob;
        this.profilePicture = profilePicture;
        this.active = active;
        this.joinDate = joinDate;
        this.friends = friends;
        this.posts = posts;
        this.friendRequest = friendRequest;
    }

    public boolean sendMessage(){
        return false;
    }

    public boolean reportUser(User user){
        try{
            //TODO try to report user

        }catch(Exception e) {
            // did ot work
            return false;
        }
        return true;
    }

    public boolean addFriend(User user){
        try{
            //TODO try to add friend to array list

            //TODO add friend to database

        }catch(Exception e) {
            // did not work
            return false;
        }
        return true;
    }

    public boolean acceptFriend(User user){
        if(friendRequest.contains(user)){
            //TODO add friend
            return true;
        }
        return false;
    }

    public boolean deleteFriend(Friend friend){
        if(friendRequest.contains(friend)){
            // TODO remove friend
            return true;
        }
        return false;
    }

    public boolean addPost(Post post){
        try{
            //TODO add a check to ensure post added is valid
            posts.add(post);
        }catch (Exception e){
            // didnt work
            return false;
        }
        return true;
    }

    public boolean deletePost(Post post){
        try{
            //TODO add a check to ensure post added is valid
            if(posts.contains(post)){
                //TODO remove post
            }
        }catch (Exception e){
            // didnt work
            return false;
        }
        return true;
    }


    public boolean likePost(Post post){
        try{
            // TODO add a like to post
        }catch (Exception e){
            return false;
        }
        return true;
    }


    public boolean makeComment(Post post){
        try{
            // TODO add comment to post
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public boolean updateProfilePicture(Image image){
        try{
            //TODO set user Image to image in the parameter
        }catch (Exception e){
            // didnt work
            return false;
        }
        return true;
    }

    public boolean attendEvent(User user){
        try{
            //TODO add user to event
        }catch (Exception e){
            // didnt work
            return false;
        }
        return true;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUsername() {
        return username;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public Date getDob() {
        return dob;
    }
    public Image getProfilePicture() {
        return profilePicture;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public ArrayList<Friend> getFriends() {
        return friends;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }
    public ArrayList<User> getFriendRequest() {
        return friendRequest;
    }
}
