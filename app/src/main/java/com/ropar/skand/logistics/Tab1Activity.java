package com.ropar.skand.logistics;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

/**
 * Created by skand on 2/8/16.
 */
public class Tab1Activity  extends AppCompatActivity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);


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
        ArrayAdapter adapter2 = new ArrayAdapter <String>(this, android.R.layout.simple_list_item_1, pending);
        ListView listView2 = (ListView)findViewById(R.id.list);
        listView2.setAdapter(adapter2);
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast toast = Toast.makeText(getApplicationContext(), "Opening Pending Details", Toast.LENGTH_SHORT);
                toast.show();
                Intent i = new Intent(getApplicationContext(), Pending.class);
                startActivity(i);

            }
        });
    }


}