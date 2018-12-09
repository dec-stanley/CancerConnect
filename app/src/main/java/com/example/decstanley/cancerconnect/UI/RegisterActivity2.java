package com.example.decstanley.cancerconnect.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import com.example.decstanley.cancerconnect.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class RegisterActivity2 extends AppCompatActivity {
    private EditText phoneNumber;
    private EditText dob;
    private String fullname, password, email;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_screen2);
        setUpButtonListeners();

        // firebase auth stuff
        firebaseAuth = FirebaseAuth.getInstance();


        phoneNumber = (EditText) findViewById(R.id.PhoneNumberEntry);
        dob = (EditText) findViewById(R.id.DOBEntry);

        // get data from other page and set them to public variables
        fullname = getIntent().getStringExtra("FULLNAME");
        password = getIntent().getStringExtra("EMAIL");
        email = getIntent().getStringExtra("PASSWORD");

    }

    // sets up all listeners for the buttons on the activity
    private void setUpButtonListeners() {
        /*< Back button Listener > */
        ImageButton backButton = findViewById(R.id.BackButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                backToRegisterActivity1();
            }
        });
        /*< /Backbutton Listener > */

        Button contButton = (Button)  findViewById(R.id.Sumbit);
        contButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                if(isValidData()){
                    if(enterData()){
                        // move user to the feed activity
                    }else{
                        //TODO show error messages - DATA WAS NOT ENTERED INTO THE DATABASE
                    }

                }else{
                    //TODO show error messages - DATA IS NoT VALID
                }
            }
        });
    }

    // returns if data is entered
    private boolean enterData(){

        Toast.makeText(RegisterActivity2.this, "" + Patterns.EMAIL_ADDRESS.matcher(email).matches(), Toast.LENGTH_LONG * 10).show();
        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(RegisterActivity2.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(RegisterActivity2.this, "Entered", Toast.LENGTH_LONG * 10).show();
                }else{
                    if(task.getException() instanceof FirebaseAuthUserCollisionException){
                        // user is already signned up
                    }else{
                        // it just didnt work
                    }
                }
            }
        });
        return true;
    }

    //Returns if the data entered is valid
    private boolean isValidData(){
        //TODO - DEC -
        //Validation. get data and check if its valid bblah blah blah return true if all is valid return false if one or more are not valid
        return true;
    }


    //Takes the user back to the RegisterActivity2 activity
    private void backToRegisterActivity1(){
        Intent i = new Intent(RegisterActivity2.this , RegisterActivity1.class);
        startActivity(i);
    }



}
