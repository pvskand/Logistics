package com.ropar.skand.logistics;

import android.app.Activity;
import android.app.TabActivity;
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
import android.widget.TabHost;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;



public class HomePage extends TabActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.content_home_page);
        //setContentView(R.layout.activity_home_page);

        // create the TabHost that will contain the Tabs
        TabHost tabHost = (TabHost)findViewById(android.R.id.tabhost);
        /*if(1==1)
        {Toast toast = Toast.makeText(getApplicationContext(), "Invalid Credentials", Toast.LENGTH_SHORT);
            toast.show();
        }*/

        tabHost.setup();

        TabHost.TabSpec tab1 = tabHost.newTabSpec("First Tab");
        TabHost.TabSpec tab2 = tabHost.newTabSpec("Second Tab");


        // Set the Tab name and Activity
        // that will be opened when particular Tab will be selected
        tab1.setIndicator("Pending");
        tab1.setContent(new Intent(this,Tab1Activity.class));

        tab2.setIndicator("Booking History");
        tab2.setContent(new Intent(this,Tab2Activity.class));



        /** Add the tabs  to the TabHost to display. */
        tabHost.addTab(tab1);
        tabHost.addTab(tab2);




        // getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        //navigationView.setNavigationItemSelectedListener(this);
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
