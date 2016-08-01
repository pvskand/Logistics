package com.ropar.skand.logistics;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Pending extends AppCompatActivity {

    String Booking_id=null;
    String status=null;
    String date_start=null;
    String details=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button startButton = (Button) findViewById(R.id.start);
        startButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                //String response=makehttprequest();   // request to made on starting the journey
                Intent i = new Intent(getApplicationContext(), MapsActivity.class);
                TextView source = (TextView) findViewById(R.id.SourceValue);
                String sourcePath = source.getText().toString();
                TextView destination = (TextView) findViewById(R.id.destinationValue);
                String destinationPath = destination.getText().toString();
                i.putExtra("source", sourcePath);
                i.putExtra("destination", destinationPath);
                startActivity(i);
            }
        });

    }
        private void makehttprequest()
    {
        JasonTaskStartJourney obj=new JasonTaskStartJourney();
        obj.execute("www.rnalogistics.com/updateBookingStatus ");
        String response=Jsonparser(details);
    }

    public String Jsonparser(String Jsontobeparsed)
    {
        String d=null;
        try {

            JSONObject obj=new JSONObject(Jsontobeparsed);
            JSONArray arr=obj.getJSONArray("");
            JSONObject status=arr.getJSONObject(0);
            d =status.getString("status");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return (d);

    }

    public class JasonTaskStartJourney extends AsyncTask<String,String,String>
    {

        @Override
        protected String doInBackground(String... params) {
            HttpURLConnection connection = null;
            BufferedReader reader = null;



            try {


                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setRequestProperty(" bookingId",Booking_id);
                connection.setRequestProperty("status",status);
                connection.setRequestProperty("dateOfStarting",date_start);
                connection.setDoOutput(true);
                // connection.connect();

                //int responseCode=connection.getResponseCode();

                InputStream stream = connection.getInputStream();

                reader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer = new StringBuffer();
                String line = "";
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }

                details=buffer.toString();

                return details;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }//end of finally

            return null;
        }//baclground ends


        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

        }//Post Execute ends

    }//Jason task ends*/


    }


