package com.example.decstanley.cancerconnect.Objects;

import java.util.ArrayList;

public class Comments {
    private ArrayList<Comment> comments;

    Comments() {
        comments = new ArrayList();
    }

    public void addComment(Comment newComment)
    {
        comments.add(newComment);
    }

    public void deleteComment(int commentID)
    {
        //comments.remove();
    }
}
