package com.example.decstanley.cancerconnect.UI;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.decstanley.cancerconnect.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth loginAuth; //declare instance of firebase auth

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entry_screen);

        loginAuth = FirebaseAuth.getInstance();// initialize firebase auth instance


        FirebaseUser currentUser = loginAuth.getCurrentUser();
    }
}
