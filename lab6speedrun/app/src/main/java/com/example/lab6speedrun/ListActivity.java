package com.example.lab6speedrun;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    User Guest;
    ArrayList<Place> Places;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        generatePlaces();
        Bundle arguments = getIntent().getExtras();
        Guest = (User) arguments.getSerializable(User.class.getSimpleName());

        TextView Hello = (TextView) findViewById(R.id.textView);
        Hello.setText("Здравствуйте, " + Guest.getName());
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ListView list = (ListView) findViewById(R.id.PlacesList);



        //55.777348, 37.657008
        PlaceAdapter PlAdapter= new PlaceAdapter(this, R.layout.item,Places);
        list.setAdapter(PlAdapter);
        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Log.d("ON_CLICK", "________________ ПЕРЕХОД! на третий экран");
                Place selected = (Place) parent.getItemAtPosition(position);
                Intent intent=new Intent(ListActivity.this,MapActivity.class);
                intent.putExtra("time4am",  selected);
                startActivity(intent);
            }
        };
        list.setOnItemClickListener(itemListener);
        Log.d("ON_CLICK", "________________ onCreate 2-го экрана выполнен до конца");
    }
    public void onFindButtonClick(View view){
        Log.d("ON_CLICK", "________________ ПЕРЕХОД! на экран выбора");
        Intent intent=new Intent(ListActivity.this,ChoisePlaceActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onStop() {
        super.onStop();

    }
    public void generatePlaces(){
        Places = new ArrayList<>();
        //PlaceGenerator.GenerateRailwayStations(Places);
        PlaceGenerator.GenerateRailwayStationsMoscowAndSPB(Places);
    }
}
