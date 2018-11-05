package com.example.decstanley.cancerconnect.Objects;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class Users {
    private ArrayList<User> users;

    public Users(){
        users = new ArrayList<User>();
    }

    public boolean addUser(User user){
        try{
            //TODO Add check to see if user is already in the list before adding
            users.add(user);
        }catch (Exception e){
            return false;
        }
        return true;
    }
    public boolean removeUser(User user){
        try{
            //TODO Add check to see if user is exists in the database
            users.add(user);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public ArrayList<User> getAllUsers(){
        return users;
    }
    public User searchUser(String userToSearchFor){
        for(User user: users){
            if(user.getFullName().equalsIgnoreCase(userToSearchFor)){
                return user;
            }
        }
        return null;
    }
}
