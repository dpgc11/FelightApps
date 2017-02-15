package com.example.android.felightapps.Maps;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.android.felightapps.R;

public class MapsAppsActivity extends AppCompatActivity {

    private Button mBangaloreMetroStationsButton;
    private Button mRouteToHomeButton;
    private Button mMyCurrentLocationButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_apps);
        mBangaloreMetroStationsButton = (Button) findViewById(R.id.btn_bangalore_metro_stations_activity);
        mRouteToHomeButton = (Button) findViewById(R.id.btn_route_to_home_activity);
        mMyCurrentLocationButton = (Button) findViewById(R.id.btn_my_current_location_activity);

        mBangaloreMetroStationsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MapsAppsActivity.this, BangaloreMetroStationsActivity.class);
                startActivity(i);
            }
        });

        mRouteToHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MapsAppsActivity.this, RouteToHomeActivity.class);
                startActivity(i);
            }
        });

        mMyCurrentLocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MapsAppsActivity.this, MyLocationActivity.class);
                startActivity(i);
            }
        });
    }
}
