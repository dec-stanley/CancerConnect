package com.example.decstanley.cancerconnect.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.decstanley.cancerconnect.Objects.Event;
import com.example.decstanley.cancerconnect.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddEventActivity extends AppCompatActivity{

    private String email;
    private DatabaseReference databaseRef;

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

                EditText titleEditText = (EditText) findViewById(R.id.titleText);
                String titleText = titleEditText.getText().toString();

                EditText descEditText = (EditText) findViewById(R.id.descText);
                String descText = descEditText.getText().toString();

                EditText addressEditText = (EditText) findViewById(R.id.addressText);
                String addressText = addressEditText.getText().toString();

                EditText townEditText = (EditText) findViewById(R.id.cityText);
                String townText = townEditText.getText().toString();

                EditText countyEditText = (EditText) findViewById(R.id.countyText);
                String countyText = countyEditText.getText().toString();
                EditText postcodeEditText = (EditText) findViewById(R.id.postcodeText);
                String postcodeText = postcodeEditText.getText().toString().toUpperCase();

                EditText timeEditText = (EditText) findViewById(R.id.timeText);
                CalendarView dateCalendarView = (CalendarView) findViewById(R.id.dateCalendar);



                String timeStr = timeEditText.getText().toString();
                DateFormat formatter = new SimpleDateFormat("hh::mm:ss");
                Date dateTime;
                dateTime = new Date();
                dateTime.setTime(0);
                try {
                    dateTime = formatter.parse(timeStr);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Toast.makeText(AddEventActivity.this, String.valueOf(dateTime.getTime()), Toast.LENGTH_LONG * 100).show();

                //Date time = dateTime;

                dateTime.setTime(dateTime.getTime() + dateCalendarView.getDate());
                //Calendar dateTime = Calendar.getInstance();

                /*String timeStr = timeEditText.getText().toString();
                DateFormat formatter = new SimpleDateFormat("hh::mm:ss a");
                Date time;
                time = new Date();
                time.setTime(0);
                try {
                    time = formatter.parse(timeStr);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                dateTime.setTimeInMillis(dateCalendarView.getDate() + time.getTime());*/





                writeNewEvent(email, titleText, dateTime, 2 , 3 , addressText, townText, countyText, postcodeText, descText);
                //add to database

                if(TextUtils.isEmpty(titleText)){
                    Toast.makeText(AddEventActivity.this, "Please enter an event title", Toast.LENGTH_LONG * 10).show();
                }
                else {
                    if (TextUtils.isEmpty(descText)) {
                        Toast.makeText(AddEventActivity.this, "Please enter an event description", Toast.LENGTH_LONG * 10).show();
                    }
                    else {
                        if (TextUtils.isEmpty(addressText)) {
                            Toast.makeText(AddEventActivity.this, "Please enter an event address", Toast.LENGTH_LONG * 10).show();
                        }
                        else {
                            if (TextUtils.isEmpty(townText)) {
                                Toast.makeText(AddEventActivity.this, "Please enter an event town", Toast.LENGTH_LONG * 10).show();
                            }
                            else {
                                if (TextUtils.isEmpty(descText)) {
                                    Toast.makeText(AddEventActivity.this, "Please enter an event description", Toast.LENGTH_LONG * 10).show();
                                }
                                else {
                                    if (TextUtils.isEmpty(countyText)) {
                                        Toast.makeText(AddEventActivity.this, "Please enter an event county", Toast.LENGTH_LONG * 10).show();
                                    }
                                    else {
                                        if (TextUtils.isEmpty(postcodeText)) {
                                            Toast.makeText(AddEventActivity.this, "Please enter an event postcode", Toast.LENGTH_LONG * 10).show();
                                        }
                                        else {
                                            if (TextUtils.isEmpty(postcodeText)) {
                                                Toast.makeText(AddEventActivity.this, "Please enter an event postcode", Toast.LENGTH_LONG * 10).show();
                                            }
                                            final String EMAIL_PATTERN = "^([A-PR-UWYZ](([0-9](([0-9]|[A-HJKSTUW])?)?)|([A-HK-Y][0-9]([0-9]|[ABEHMNPRVWXY])?)) ?[0-9][ABD-HJLNP-UW-Z]{2})$";
                                            Pattern pattern = Pattern.compile(EMAIL_PATTERN);
                                            CharSequence inputStr = postcodeText;
                                            Matcher matcher = pattern.matcher(inputStr);
                                            if(matcher.matches()){
                                                Intent i = new Intent(AddEventActivity.this , EventsActivity.class);
                                                i.putExtra("EMAIL", email);
                                                startActivity(i);
                                            }
                                            else{
                                                Toast.makeText(AddEventActivity.this, "Please enter a valid postcode", Toast.LENGTH_LONG * 10).show();
                                            }
                                        }
                                    }
                                }
                            }

                        }
                    }
                }

            }
        });
    }

    public void writeNewEvent(String eventID,String eventTitle, Date startDateTime, int longitude,int latitude,String address,String town,String county,String postcode, String eventSummary)
    {
        Event event = new Event(eventID, eventTitle, startDateTime, longitude, latitude, address, town, county, postcode, eventSummary);

        FirebaseFirestore database = FirebaseFirestore.getInstance();

        String newID = eventID+eventTitle;


        // Create a new user with a first and last name
        Map<String, Object> newEvent = new HashMap<>();
        newEvent.put("Title", eventTitle);
        newEvent.put("StartDate", startDateTime);
        newEvent.put("Longitude", longitude);
        newEvent.put("Latitude", latitude);
        newEvent.put("Address", address);
        newEvent.put("Town", town);
        newEvent.put("County", county);
        newEvent.put("Postcode", postcode);
        newEvent.put("Summary", eventSummary);


        // Add a new document with a generated ID
        database.collection("Events").document(newID).set(newEvent);



    }

}
