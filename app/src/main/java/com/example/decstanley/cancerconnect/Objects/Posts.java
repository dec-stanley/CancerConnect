package com.example.decstanley.cancerconnect.Objects;

import java.util.ArrayList;

public class Posts {
    private ArrayList<Post> posts;

    public void addPost(Post newPost)
    {
        posts.add(newPost);
    }

    public void deletePost(int postID)
    {
        //posts.remove();
    }
}
