package com.example.decstanley.cancerconnect.Objects;

import java.util.Date;

public class Message {



    private String messageID;
    private String message;
    private Date dateSent;

    public Message(String messageID, String message, Date dateSent){
        this.messageID = messageID;
        this.message = message;
        this.dateSent = dateSent;
    }

    public boolean setMessage(String message){
        try {
            this.message = message;
        }catch(Exception e){
            return false;
        }
        return true;
    }

    public String getMessage(){
        return message;
    }

    public Date getDate(){
        return dateSent;
    }
}
