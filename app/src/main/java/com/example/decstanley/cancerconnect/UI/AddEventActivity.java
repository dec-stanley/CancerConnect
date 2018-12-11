package com.example.decstanley.cancerconnect.UI;

import android.content.Intent;
import android.icu.util.Calendar;
import android.os.AsyncTask;
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
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddEventActivity extends AppCompatActivity{

    private String email;
    private DatabaseReference databaseRef;
    private double latitude;
    private double longitude;

    private String titleText, descText, addressText, townText, countyText, postcodeText;
    private String dateTime;

    private String timeStr;

    private static String dateee = "nothing";
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

        CalendarView dateCalendarView = (CalendarView) findViewById(R.id.dateCalendar);
        dateCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            //show the selected date as a toast
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int day) {
                Toast.makeText(getApplicationContext(), day + "/" + month + "/" + year, Toast.LENGTH_LONG).show();
                dateee = day +"/" + (month + 1) +"/" + year;
            }
        });

        Button createButton = findViewById(R.id.createButton);
        createButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                EditText titleEditText = (EditText) findViewById(R.id.titleText);
                titleText = titleEditText.getText().toString();

                EditText descEditText = (EditText) findViewById(R.id.descText);
                descText = descEditText.getText().toString();

                EditText addressEditText = (EditText) findViewById(R.id.addressText);
                addressText = addressEditText.getText().toString();

                EditText townEditText = (EditText) findViewById(R.id.cityText);
                townText = townEditText.getText().toString();

                EditText countyEditText = (EditText) findViewById(R.id.countyText);
                countyText = countyEditText.getText().toString();
                EditText postcodeEditText = (EditText) findViewById(R.id.postcodeText);
                postcodeText = postcodeEditText.getText().toString().toUpperCase();

                EditText timeEditText = (EditText) findViewById(R.id.timeText);
                CalendarView dateCalendarView = (CalendarView) findViewById(R.id.dateCalendar);


                timeStr = timeEditText.getText().toString();
                // DateFormat formatter = new SimpleDateFormat("hh::mm", Locale.getDefault());

                /*try {
                    dateTime = formatter.parse(timeStr);
                } catch (ParseException e) {
                    e.printStackTrace();
                    Toast.makeText(AddEventActivity.this, "Couldn't parse", Toast.LENGTH_LONG * 100).show();
                    dateTime = new Date();
                }*/
                Toast.makeText(AddEventActivity.this, String.valueOf(dateCalendarView.getDate()), Toast.LENGTH_LONG * 100).show();

                latitude = 0.0;
                longitude = 0.0;

                String url = getGeoLoactionUrl(addressText + " " + townText + countyText + " " + postcodeText);
                getFromGoogle(url);


            }


        });
    }

    public void writeNewEvent(String eventID,String eventTitle, String startDateTime, String time, double longitude,double latitude,String address,String town,String county,String postcode, String eventSummary)
    {
        Event event = new Event(eventID, eventTitle, startDateTime,time, longitude, latitude, address, town, county, postcode, eventSummary);

        FirebaseFirestore database = FirebaseFirestore.getInstance();

        String newID = eventID+eventTitle;


        // Create a new user with a first and last name
        Map<String, Object> newEvent = new HashMap<>();
        newEvent.put("Title", eventTitle);
        newEvent.put("StartDate", startDateTime);
        newEvent.put("StartTime", time);
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


    private String getGeoLoactionUrl(String parameters) {

        parameters = "address="+parameters;
        parameters = parameters.replace(" ", "+");
        // json?address=1600+Amphitheatre+Parkway,+Mountain+View,+CA&key=YOUR_API_KEY
        String output = "json";

        String key = "key=AIzaSyCCpKVPOewpYzagdPgsLghkX3BLzn4Lt34";

        return "https://maps.googleapis.com/maps/api/geocode/"+output+"?" + parameters + "&" + key;

    }


    public void getFromGoogle(String url){
        double[] latlong = new double[2];
        final String newURL = url;

        AsyncTask async = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                OkHttpClient client = new OkHttpClient();

                Request request = new Request.Builder()
                        .url(newURL)
                        .build();

                Response response = null;

                try{
                    response = client.newCall(request).execute();
                    return response.body().string();
                }catch(IOException e){
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Object o) {
                parseJSON(o.toString());

            }
        }.execute();
    }

    private void parseJSON(String s){

        try {
            JSONObject root = new JSONObject(s);

            JSONArray results = root.getJSONArray("results");

            JSONObject hh = results.getJSONObject(0);
            JSONObject ko = hh.getJSONObject("geometry");
            JSONObject location = ko.getJSONObject("location");

            latitude = location.getDouble("lat");
            longitude = location.getDouble("lng");


            writeNewEvent(email, titleText, dateee, timeStr, longitude , latitude , addressText, townText, countyText, postcodeText, descText);
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


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
