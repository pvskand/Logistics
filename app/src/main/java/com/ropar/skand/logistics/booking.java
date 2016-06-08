package com.ropar.skand.logistics;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ListActivity;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class booking extends Activity{




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        String[] color = {" Booking ID:    #1234567 \n Date:   15/02/2016\n Source: 12345\n Destination: 54321 \n Date of completion: 17/02/2016"};
        ArrayAdapter adapter = new ArrayAdapter <String>(this, R.layout.activity_booking, R.id.texthere, color);
        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
