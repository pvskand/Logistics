package com.ropar.skand.logistics;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by skand on 2/8/16.
 */
public class Tab2Activity  extends Activity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
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
        ArrayAdapter adapter2 = new ArrayAdapter <String>(this, android.R.layout.simple_list_item_1, color);
        ListView listView2 = (ListView)findViewById(R.id.list);
        listView2.setAdapter(adapter2);
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast toast = Toast.makeText(getApplicationContext(), "Opening Booking Details", Toast.LENGTH_SHORT);
                toast.show();
                Intent i = new Intent(getApplicationContext(), bookingHistory.class);
                startActivity(i);

            }
        });

    }
}
