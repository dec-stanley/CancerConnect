package com.example.decstanley.cancerconnect.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.example.decstanley.cancerconnect.R;

public class RegisterActivity1  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_screen1);
        setUpButtonListeners(); // sets up the button listeners
    }

    private void setUpButtonListeners(){
        /*< Backbutton Listener > */
        // Listener for login button takes user from the main page to the login activity
        ImageButton backButton =  findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                backToMainActivity();
            }
        });
        /*< /Backbutton Listener > */
    }

    //takes the user back to the main activity
    private void backToMainActivity(){
        Intent i = new Intent(RegisterActivity1.this , MainActivity.class);
        startActivity(i);
    }
}
