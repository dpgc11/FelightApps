package com.example.android.felightapps.Maps;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.android.felightapps.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class BangaloreMetroStationsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng bangalore = new LatLng(12.9716, 77.5946);
        LatLng kempegowdaMetroStation = new LatLng(12.9757, 77.5728);
        LatLng sampigeRoadMetroStation = new LatLng(12.9905, 77.5707);
        LatLng peenyaIndustryMetroStation = new LatLng(13.0363, 77.5255);
        LatLng kuvempuRoadMetroStation = new LatLng(12.9985, 77.5570);
        LatLng srirampuraMetroStation = new LatLng(12.9965, 77.5633);

        mMap.addMarker(new MarkerOptions().position(kempegowdaMetroStation).title("Kempegowda Metro Station").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_train_red_900_24dp)));
        mMap.addMarker(new MarkerOptions().position(sampigeRoadMetroStation).title("Sampige Road Metro Station").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_train_red_900_24dp)));
        mMap.addMarker(new MarkerOptions().position(peenyaIndustryMetroStation).title("Peenya Industry Metro Station").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_train_red_900_24dp)));
        mMap.addMarker(new MarkerOptions().position(kuvempuRoadMetroStation).title("Kuvempu Nagar Metro Station").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_train_red_900_24dp)));
        mMap.addMarker(new MarkerOptions().position(srirampuraMetroStation).title("Srirampura Metro Station").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_train_red_900_24dp)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bangalore));
        mMap.addCircle(new CircleOptions()
                .center(bangalore)
                .radius(25000)
                .strokeColor(Color.RED)
        );
    }
}
