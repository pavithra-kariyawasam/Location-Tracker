package com.location.locationtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void btnCurrentLocation(View view){
        startActivity(new Intent(this,MapsActivity.class));
    }

    public void btnpreviousLocation(View view){
        startActivity(new Intent(getApplicationContext(),Main2Activity.class));
    }
}
