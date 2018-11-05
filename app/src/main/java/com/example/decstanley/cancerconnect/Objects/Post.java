package com.example.decstanley.cancerconnect.Objects;

import java.util.ArrayList;

public class Post {
    private String postID;
    private String userID;
    private String information;
    private ArrayList<String> likes;
    private Comments comments;

    public String getPostID() {
        return this.postID;
    }

    public String getUserID() {
        return this.userID;
    }

    public String getInformation() {
        return this.information;
    }

    public void addLike(String userID) {
        likes.add(userID);
    }

    public void addComment(String commentID, String userID, String comment) {
        comments.addComment(new Comment(commentID, userID, comment));
    }

    public void openMoreOptions(){}
}
