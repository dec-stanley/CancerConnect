package com.example.decstanley.cancerconnect.UI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.decstanley.cancerconnect.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class EntryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entry_screen);
    }
}
