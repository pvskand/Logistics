package com.ropar.skand.logistics;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;



import android.Manifest;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import Modules.DirectionFinder;
import Modules.DirectionFinderListener;
import Modules.Route;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, DirectionFinderListener {

    private GoogleMap mMap;
    private Button btnFindPath;
    private EditText etOrigin;
    private EditText etDestination;
    private List<Marker> originMarkers = new ArrayList<>();
    private List<Marker> destinationMarkers = new ArrayList<>();
    private List<Polyline> polylinePaths = new ArrayList<>();
    private ProgressDialog progressDialog;
    String Booking_id=null;
    String status=null;
    String date_destination=null;
    String details=null;
    String date_completion=null;
    String date=null;
    
    int f1 = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        btnFindPath = (Button) findViewById(R.id.btnFindPath);
        etOrigin = (EditText) findViewById(R.id.etOrigin);
        etDestination = (EditText) findViewById(R.id.etDestination);

        final String source = getIntent().getStringExtra("source");
        final String destination = getIntent().getStringExtra("destination");
        int flag = getIntent().getIntExtra("flag",-1);
        if(flag==2) // goes when you reach the final destination
        {
            String source1 = getIntent().getStringExtra("source");
            String destination1 = getIntent().getStringExtra("destination");
            etDestination.setText(destination1);
            etOrigin.setText(source1);

            TextView button = (TextView)findViewById(R.id.reachedSource);
            String reachedDestination = "Reached Destination";
            button.setText(reachedDestination);
            f1++;
        }
        else {
            // Getting text from booking status

            etDestination.setText(source); // setting the Destination
        }
        btnFindPath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Demo();
            }
        });
        // on Clicking Reached Source Button
        Button reached = (Button)findViewById(R.id.reachedSource);
        reached.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(f1==2) {
                    Intent i = new Intent(getApplicationContext(), MapsActivity.class);
                    i.putExtra("flag", 2);
                    i.putExtra("source", source);
                    i.putExtra("destination", destination);
                    startActivity(i);
                    //request_reached_source();  /***** function call for http request ****/
                }
                if(f1==3)
                {
                    //request_reached_destination();  /***** function call for http request ****/
                    Intent i = new Intent(getApplicationContext(),HomePage.class);
                    startActivity(i);
                }

            }
        });
    }

    private void request_reached_destination()
    {
        date=date_completion;
        JasonTaskReachedDestination obj=new JasonTaskReachedDestination();
        obj.execute("www.rnalogistics.com/completedJourney  ");
        String response=Jsonparser(details);
    }

    private void request_reached_source()
    {
        date=date_destination;
        JasonTaskReachedDestination obj=new JasonTaskReachedDestination();
        obj.execute("www.rnalogistics.com/reachDestination ");
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

    public class JasonTaskReachedDestination extends AsyncTask<String,String,String>
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
                connection.setRequestProperty("dateOfStarting",date);
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


    private void Demo()
    {
        // Build the intent
        //Uri location = Uri.parse("google.navigation:0,0?q=Dwarka,+New,+Delhi");
        //Uri location = Uri.parse("geo:37.422219,-122.08364?z=14");
        //Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
        Uri gmmIntentUri = Uri.parse("google.navigation:q=Dwarka,+New+Delhi+India");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");


// Verify it resolves
        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(mapIntent, 0);
        boolean isIntentSafe = activities.size() > 0;

// Start an activity if it's safe
        if (isIntentSafe) {
            startActivity(mapIntent);
        }
    }

    private void sendRequest() {
        String origin = etOrigin.getText().toString();
        String destination = etDestination.getText().toString();
        if (origin.isEmpty()) {
            Toast.makeText(this, "Please enter origin address!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (destination.isEmpty()) {
            Toast.makeText(this, "Please enter destination address!", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            new DirectionFinder(this, origin, destination).execute();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng hcmus = new LatLng(28.6139, 77.2090);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(hcmus, 18));
        originMarkers.add(mMap.addMarker(new MarkerOptions()
                .title("You are here")
                .position(hcmus)));

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);
    }



    public void onDirectionFinderStart() {
        progressDialog = ProgressDialog.show(this, "Please wait.",
                "Finding direction..!", true);

        if (originMarkers != null) {
            for (Marker marker : originMarkers) {
                marker.remove();
            }
        }

        if (destinationMarkers != null) {
            for (Marker marker : destinationMarkers) {
                marker.remove();
            }
        }

        if (polylinePaths != null) {
            for (Polyline polyline:polylinePaths ) {
                polyline.remove();
            }
        }
    }


    public void onDirectionFinderSuccess(List<Route> routes) {
        progressDialog.dismiss();
        polylinePaths = new ArrayList<>();
        originMarkers = new ArrayList<>();
        destinationMarkers = new ArrayList<>();

        for (Route route : routes) {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(route.startLocation, 16));
            ((TextView) findViewById(R.id.tvDuration)).setText(route.duration.text);
            ((TextView) findViewById(R.id.tvDistance)).setText(route.distance.text);

            originMarkers.add(mMap.addMarker(new MarkerOptions()
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.start_blue))
                    .title(route.startAddress)
                    .position(route.startLocation)));
            destinationMarkers.add(mMap.addMarker(new MarkerOptions()
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.end_green))
                    .title(route.endAddress)
                    .position(route.endLocation)));

            PolylineOptions polylineOptions = new PolylineOptions().
                    geodesic(true).
                    color(Color.BLUE).
                    width(10);

            for (int i = 0; i < route.points.size(); i++)
                polylineOptions.add(route.points.get(i));

            polylinePaths.add(mMap.addPolyline(polylineOptions));
        }
    }
}
