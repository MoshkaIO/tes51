package com.example.lab6speedrun;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ChoisePlaceActivity extends AppCompatActivity {

    ArrayList<Place> Places;
    EditText Name;
    EditText Year;
    EditText Capacity;
    EditText City;
    EditText Style;
    TextView Warning;
    PlaceAdapter PlAdapter;
    ListView list;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choise);

        list = (ListView) findViewById(R.id.PlacesList);
        Name = findViewById(R.id.editTextName);
        Year = findViewById(R.id.editYear);
        Capacity = findViewById(R.id.editCapacity);
        City = findViewById(R.id.editCity);
        Style = findViewById(R.id.editStyle);
        Warning = findViewById(R.id.textWarning);

        generatePlaces();
        //55.777348, 37.657008
       // PlAdapter= new PlaceAdapter(this, R.layout.item,Places);
       // list.setAdapter(PlAdapter);

    }
    public void onCheckButtonClick(View view){
        ArrayList <Place> PlacesCopy = new ArrayList<>();
        if (Year.getText().toString().isEmpty()) Year.setText("0");
        if (Capacity.getText().toString().isEmpty()) Capacity.setText("0");
        Options Filter = new Options(Name.getText().toString(),Integer.parseInt(Year.getText().toString()),
                Integer.parseInt(Capacity.getText().toString()),City.getText().toString(),Style.getText().toString());
                //Integer.parseInt(data[2])
        for (int i=0; i<Places.size(); i++){
            PlacesCopy.add(Places.get(i));
        }
        Log.d("чё?", "________________ На фильтр отправили "+PlacesCopy.size()+" городов");
        PlaceFilter.FilterWithOptions(PlacesCopy, Filter);
        Log.d("чё?", "________________ Фильтр прошли "+PlacesCopy.size()+" городов");

        PlAdapter= new PlaceAdapter(this, R.layout.item,PlacesCopy);
        list.setAdapter(PlAdapter);
        if (PlacesCopy.isEmpty()){
            Warning.setText("К сожалению, нам не удалось найти таких вокзалов");
            return;
        }
        if (Year.getText().toString().equals("0")) Year.setText("");
        if (Capacity.getText().toString().equals("0")) Capacity.setText("");
        Warning.setText(" Вот ваш вокзал мечты!");

        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Log.d("ON_CLICK", "________________ ПЕРЕХОД! на третий экран");
                Place selected = (Place) parent.getItemAtPosition(position);
                Intent intent=new Intent(ChoisePlaceActivity.this,MapActivity.class);
                intent.putExtra("time4am",  selected);
                startActivity(intent);
            }
        };
        list.setOnItemClickListener(itemListener);


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
        Log.d("ON_CLICK", "________________ Генератор сгенерировал нам "+String.valueOf(Places.size())+" объектоу");
    }
}
