package com.example.lab6speedrun;

import android.util.Log;

import java.util.ArrayList;

public class PlaceFilter {
    public static void FilterWithOptions(ArrayList<Place> PlacesCopy, Options Filter){
        if (Filter.IsEmpty()){ //проверка, не все ли поля нулевые
            PlacesCopy.clear();
            return;
        }
        if (!Filter.getArchitect().isEmpty()){
            Log.d("ON_CLICK", "________________ ФИЛЬТР. По Архитектору");
            for (int i=0; i<PlacesCopy.size(); i++){
                if (!PlacesCopy.get(i).getPlaceOptions().getArchitect().equals(Filter.getArchitect())){
                    PlacesCopy.remove(i);
                    i--;
                }
            }
        }
        if (Filter.getYear()!=0){
            Log.d("ON_CLICK", "________________ ФИЛЬТР. По году постройки");
            for (int i=0; i<PlacesCopy.size(); i++){
                if (PlacesCopy.get(i).getPlaceOptions().getYear()!=Filter.getYear()){
                    PlacesCopy.remove(i);
                    i--;
                }
            }
        }
        if (Filter.getCapacity()!=0){
            Log.d("ON_CLICK", "________________ ФИЛЬТР. По вместимости");
            for (int i=0; i<PlacesCopy.size(); i++){
              /*  if (PlacesCopy.get(i).getPlaceOptions().getCapacity()!=Filter.getCapacity()){
                    PlacesCopy.remove(i);
                    i--;
                }*/
                if (PlacesCopy.get(i).getPlaceOptions().getCapacity()<Filter.getCapacity()) { //удаляем все кто менее вместимы
                    PlacesCopy.remove(i);
                    i--;
                }
            }
        }
        if (!Filter.getCity().isEmpty()){
            Log.d("ON_CLICK", "________________ ФИЛЬТР. По городу");
            for (int i=0; i<PlacesCopy.size(); i++){
                if (!PlacesCopy.get(i).getPlaceOptions().getCity().equals(Filter.getCity())){
                    Log.d("ON_CLICK", "________________ проверка: "+PlacesCopy.get(i).getPlaceOptions().getCity()
                    +" не равно "+Filter.getCity());
                    PlacesCopy.remove(i);
                    i--;
                }
            }
        }
        if (!Filter.getStyle().isEmpty()){
            Log.d("ON_CLICK", "________________ ФИЛЬТР. По стилю");
            for (int i=0; i<PlacesCopy.size(); i++){
                if (!PlacesCopy.get(i).getPlaceOptions().getStyle().equals(Filter.getStyle())){
                    PlacesCopy.remove(i);
                    i--;
                }
            }
        }

        //return PlacesCopy;
    }
}
