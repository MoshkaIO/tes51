package com.example.lab6speedrun;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.mapview.MapView;

public class MapActivity  extends AppCompatActivity {
    private MapView mapView;
    private TextView options;
    Place thisPlace;
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //MapKitFactory.setApiKey("abfcc1e5-4686-432a-9097-1066126621d9");
        MapKitFactory.initialize(this);
        setContentView(R.layout.activity_map);

        Bundle arguments = getIntent().getExtras();
        thisPlace = (Place) arguments.getParcelable("time4am");
         @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView Desc = (TextView) findViewById(R.id.desc);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView Name = (TextView) findViewById(R.id.name);
        options = (TextView) findViewById(R.id.options);
        ShowOptions();
        Name.setText(thisPlace.getName());
        Desc.setText(thisPlace.getDescription());
        mapView = (MapView) findViewById(R.id.mapview);
        mapView.getMap().move(
                new CameraPosition(thisPlace.getCoords(), 16.0f, 0.0f, 0.0f),
                new Animation(Animation.Type.SMOOTH, 3),
                null);
        Point mappoint= thisPlace.getCoords();
        mapView.getMap().getMapObjects().addPlacemark(mappoint);
    }
    private void ShowOptions(){
        options.setText(thisPlace.getPlaceOptions().getAllOptions());
    }
    protected void onStop() {
        mapView.onStop();
        MapKitFactory.getInstance().onStop();
        super.onStop();
    }

    @Override
    protected void onStart() {
        super.onStart();
        MapKitFactory.getInstance().onStart();
        mapView.onStart();
    }


}
