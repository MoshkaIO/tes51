package com.example.lab6speedrun;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaceAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private int layout;
    private ArrayList<Place> Places;
    private boolean[] flags;

    public PlaceAdapter(Context context, int resource, ArrayList<Place> newPlaces) {
        super();
        Places = newPlaces;
        flags = new boolean[Places.size()];
        for (int i = 0; i < Places.size(); i++) {
            flags[i] = Places.get(i).isFlag();
        }
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return Places.size();
    }

    @Override
    public Place getItem(int i) {
        return Places.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.item, parent, false);
        }
        Place thisPlace = Places.get(position);
        Log.d("ON_CLICK", "________________ ИСПОЛЬЗОВАН АДАПТЕР");
        ((TextView) view.findViewById(R.id.NameOfItem)).setText(thisPlace.getName());
        ((TextView) view.findViewById(R.id.textOfItem)).setText(thisPlace.getDescription());
        ImageView thisImage = (ImageView) view.findViewById(R.id.pic);
        thisImage.setImageResource(thisPlace.getPictureOfPlace());
        thisImage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView TEX;
            }
        });
        return view;
    }

}
