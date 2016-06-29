package com.ropar.skand.logistics;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Pending extends AppCompatActivity {

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
                Intent i = new Intent(getApplicationContext(),MapsActivity.class);
                TextView source = (TextView)findViewById(R.id.SourceValue);
                String sourcePath = source.getText().toString();
                TextView destination = (TextView)findViewById(R.id.destinationValue);
                String destinationPath = destination.getText().toString();
                i.putExtra("source",sourcePath);
                i.putExtra("destination",destinationPath);
                startActivity(i);
            }
        });


    }

}
