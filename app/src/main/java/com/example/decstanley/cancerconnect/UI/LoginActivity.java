package com.example.decstanley.cancerconnect.UI;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import com.example.decstanley.cancerconnect.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;

    private EditText email;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

        email = findViewById(R.id.EmailEntry);
        password = findViewById(R.id.PasswordEntry);
        firebaseAuth = FirebaseAuth.getInstance();

        setUpButtonListeners(); // sets up the button listeners



    }

    public void login(){
        String emailT = email.getText().toString();
        String passwordT = password.getText().toString();

        firebaseAuth.signInWithEmailAndPassword(emailT, passwordT).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    // take user to events pages
                    moveToEventsActivity();
                }else{
                    Toast.makeText(LoginActivity.this, "Your email and password are invalid", Toast.LENGTH_LONG * 10).show();
                }
            }
        });
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

        Button logButton = findViewById(R.id.LoginButton);
        logButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                if(isValidData()){
                    login();
                }else{
                    Toast.makeText(LoginActivity.this, "Your email and password are invalid", Toast.LENGTH_LONG * 10).show();
                }
            }
        });
        /*< /Back button Listener > */
    }

    private boolean isValidData(){
        if(TextUtils.isEmpty(email.getText().toString().trim())){
            Toast.makeText(this, "Please enter your email", Toast.LENGTH_LONG * 10).show();
            return false;
        }
        if(TextUtils.isEmpty(password.getText().toString().trim())){
            Toast.makeText(this, "Please enter your password", Toast.LENGTH_LONG * 10).show();
            return false;
        }
        return true;
    }


    //takes the user back to the main activity
    private void backToMainActivity(){
        Intent i = new Intent(LoginActivity.this , MainActivity.class);
        startActivity(i);
    }
    private void moveToEventsActivity(){

        Intent i = new Intent(LoginActivity.this , EventsActivity.class);
        i.putExtra("EMAIL", email.getText().toString());
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }
}