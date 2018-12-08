package com.example.decstanley.cancerconnect.UI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.example.decstanley.cancerconnect.R;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
        setUpButtonListeners(); // sets up the button listeners


        Intent intent = new Intent(LoginActivity.this, EventsActivity.class );
        startActivity(intent);
    }


    private void setUpButtonListeners(){
        /*< Backbutton Listener > */
        // Listener for login button takes user from the main page to the login activity
        ImageButton  backButton =  findViewById(R.id.backButton2);
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
        Intent i = new Intent(LoginActivity.this , MainActivity.class);
        startActivity(i);
    }
}