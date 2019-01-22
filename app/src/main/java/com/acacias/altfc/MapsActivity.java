package com.acacias.altfc;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps2);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //Get the bundle
        Bundle bundle = getIntent().getExtras();

        //Extract the data…
        double dLat = Double.parseDouble(bundle.getString("Lat"));
        double dLong = Double.parseDouble(bundle.getString("Long"));
        String sGrround = bundle.getString("Ground");

        //LatLng sydney = new LatLng(-34.9003438, 150.604564);
        LatLng matchlocation = new LatLng(dLat, dLong);

        float zoomLevel = 16.0f; //This goes up to 21
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(matchlocation, 14));
        mMap.getUiSettings().setMapToolbarEnabled(true);

        Marker marker = mMap.addMarker(new MarkerOptions().position(matchlocation).title(sGrround));
        marker.showInfoWindow();
    }
}
