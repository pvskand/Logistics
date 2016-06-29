package com.ropar.skand.logistics;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;



public class HomePage extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Pending List view
        String[] pending = {"\n Booking ID:    #1234567 \n" +
                "Company Name: Tata"+
                " Date:   15/02/2016\n" +
                " Source: 12345\n" +
                " Destination: 54321 \n" +
                " Date of Booking: 17/02/2016\n"+
                " Material Type: Goods\n"+
                " Earning: Rs.260000"

        };
        ArrayAdapter adapter = new ArrayAdapter <String>(this, android.R.layout.simple_list_item_1, pending);
        ListView listView = (ListView)findViewById(R.id.listPending);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), Pending.class);
                startActivity(i);

            }
        });

        // History List view
        String[] color = {"\n Booking ID:    #1234567 \n" +
                "Company Name: Tata"+
                " Date:   15/02/2016\n" +
                " Source: 12345\n" +
                " Destination: 54321 \n" +
                " Date of Booking: 17/02/2016\n"+
                " Material Type: Goods\n"+
                " Earning: Rs.260000","\n Booking ID:    #1234567 \n" +
                "Company Name: Tata"+
                " Date:   15/02/2016\n" +
                " Source: 12345\n" +
                " Destination: 54321 \n" +
                " Date of Booking: 17/02/2016\n"+
                " Material Type: Goods\n"+
                " Earning: Rs.260000","\n Booking ID:    #1234567 \n" +
                "Company Name: Tata"+
                " Date:   15/02/2016\n" +
                " Source: 12345\n" +
                " Destination: 54321 \n" +
                " Date of Booking: 17/02/2016\n"+
                " Material Type: Goods\n"+
                " Earning: Rs.260000"};
        ArrayAdapter adapter1 = new ArrayAdapter <String>(this, android.R.layout.simple_list_item_1, color);
        ListView listView1 = (ListView)findViewById(R.id.list);
        listView1.setAdapter(adapter1);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast toast = Toast.makeText(getApplicationContext(), "Opening Booking Details", Toast.LENGTH_SHORT);
                toast.show();
                Intent i = new Intent(getApplicationContext(), bookingHistory.class);
                startActivity(i);

            }
        });
        // List view enew



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // getSupportActionBar().setDisplayHomeAsUpEnabled(true);




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.account) {
            // Handle the camera action
        } else if (id == R.id.bookings) {



        } else if (id == R.id.profile) {

        }
         else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
