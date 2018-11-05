package com.example.decstanley.cancerconnect.Objects;

import java.util.ArrayList;

public class Messages {
    private ArrayList<Message> messages;
    private String recipientID;

    public Messages(String recipientID){
        this.recipientID = recipientID;
        messages = new ArrayList();
    }

    public String getRecipientID(){
        return recipientID;
    }

    public void addMessage(Message message){
        messages.add(message);
    }
}
