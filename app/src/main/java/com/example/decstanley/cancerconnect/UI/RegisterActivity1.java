package com.example.decstanley.cancerconnect.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.decstanley.cancerconnect.R;

public class RegisterActivity1  extends AppCompatActivity {

    private EditText nameEntry;
    private EditText emailEntry;
    private EditText passwordEntry1;
    private EditText passwordEntry2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_screen1);
        setUpButtonListeners(); // sets up the button listeners

        nameEntry = (EditText) findViewById(R.id.NameEntry);
        emailEntry = (EditText) findViewById(R.id.EmailEntry);
        passwordEntry1 = (EditText) findViewById(R.id.PasswordEntry);
        passwordEntry2 = (EditText) findViewById(R.id.RepasswordEntry);

    }

    private void setUpButtonListeners(){
        /*< Backbutton Listener > */
        ImageButton backButton =  findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                backToMainActivity();
            }
        });
        /*< /Backbutton Listener > */

        /*< ContinueButton Listener > */
        Button contButton = (Button)  findViewById(R.id.ContinueButton);
        contButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                if(isValidData()){
                    moveToSecondRegisterPage();
                }else{
                    //TODO show error messages
                }
            }
        });
        /*< /ContinueButton Listener > */

    }

    //Returns if the data entered is valid
    private boolean isValidData(){
        //TODO - -
        //Validation. get data and check if its valid bblah blah blah return true if all is valid return false if one or more are not valid
        // an example to check if its empty
        if(TextUtils.isEmpty(nameEntry.getText().toString().trim())){
            Toast.makeText(this, "Please enter a name", Toast.LENGTH_LONG * 10).show();
        }

        return true;
    }

    //Takes the user back to the main activity
    private void backToMainActivity(){
        Intent i = new Intent(RegisterActivity1.this , MainActivity.class);
        startActivity(i);
    }

    //Takes the user to the second register page and also passes the data from this page
    private void moveToSecondRegisterPage(){
        Intent i = new Intent(RegisterActivity1.this , RegisterActivity2.class);

        i.putExtra("FULLNAME",nameEntry.getText().toString());
        i.putExtra("EMAIL", emailEntry.getText().toString());
        i.putExtra("PASSWORD", passwordEntry1.getText().toString());

        startActivity(i);
    }
}
