package com.example.decstanley.cancerconnect.Objects;

import java.time.LocalDate;
import java.util.Date;

public class Comment {
    private String commentID;
    private String userID;
    private String comment;
    private Date datePosted;

    Comment(String commentID, String userID, String comment)
    {
        this.commentID = commentID;
        this.userID = userID;
        this.comment = comment;
        this.datePosted = new Date();
    }

    public String getCommentID(){return this.commentID;}
    public String getUserID(){return this.userID;}
    public String getComment(){return this.comment;}
    public Date getDatePosted(){return this.datePosted;}

    public void setComment(String newComment){this.comment = newComment;}
}
