package com.example.decstanley.cancerconnect.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.example.decstanley.cancerconnect.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entry_screen);

        setUpButtonListeners(); // sets up the button listeners

        /*mUser = FirebaseAuth.getInstance().getCurrentUser();

        if (mUser!=null){
            Intent intent = new Intent(MainActivity.this,NewsfeedActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }*/


    }


    // creates button listeners
    private void setUpButtonListeners(){
        /*< Login Button Listener > */
        // Listener for login button takes user from the main page to the login activity
        Button loginButton = findViewById(R.id.LoginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent i = new Intent(MainActivity.this , LoginActivity.class);
                startActivity(i);
            }
        });
        /*< /Login Button Listener > */

        /*< Register Button Listener > */
        // Listener for login button takes user from the main page to the Register activity
        Button registerButton = findViewById(R.id.RegisterButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent i = new Intent(MainActivity.this , RegisterActivity1.class);
                startActivity(i);
            }
        });
        /*< /Register Button Listener > */
    }
}
