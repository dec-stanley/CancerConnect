package com.example.decstanley.cancerconnect.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.decstanley.cancerconnect.Objects.Event;
import com.example.decstanley.cancerconnect.R;
import com.google.firebase.auth.FirebaseAuth;

public class AddEventActivity extends AppCompatActivity{

    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_event_screen);
        email = getIntent().getStringExtra("EMAIL");
        setUpButtonListeners(); // sets up the button listeners
    }

    private void setUpButtonListeners(){

        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(AddEventActivity.this , EventsActivity.class);
                i.putExtra("EMAIL", email);
                startActivity(i);
            }
        });
        /*< /Back button Listener > */

        Button createButton = findViewById(R.id.createButton);
        createButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                //Event newEvent = new Event()
                //add to database



                Intent i = new Intent(AddEventActivity.this , EventsActivity.class);
                i.putExtra("EMAIL", email);
                startActivity(i);
            }
        });
    }
}
