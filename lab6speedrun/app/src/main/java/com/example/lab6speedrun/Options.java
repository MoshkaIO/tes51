package com.example.lab6speedrun;

public class Options {
    private String Architect;
    //private String Year;
    private int Year;
    private int Capacity;
    private  String City;
    private String Style;

     Options(String architect, int year, int capacity, String city, String style) {
        Architect = architect;
        Year = year;
        Capacity = capacity;
        City = city;
        Style = style;
    }
    Options (Options newOpt){
        Architect = newOpt.getArchitect();
        Year = newOpt.getYear();
        Capacity = newOpt.getCapacity();
        City = newOpt.getCity();
        Style = newOpt.getStyle();
    }
    Options(){}
    public String getAllOptions(){
        // return "Архитектор: "+Architect+" \n Год постройки: " + String.valueOf(Year) +
                // " \n Архитектурный стиль: " + Style + ", Вместимость: "+String.valueOf(Capacity)+ "человек.\n Город:"+City;
        return "Архитектор: "+Architect+" \n Год постройки: " + String.valueOf(Year) +
        " \n Архитектурный стиль: " + Style + "\n Вместимость: "+String.valueOf(Capacity)+ " человек.\n Город:"+City;
    }
    public boolean IsEmpty(){
         if ( (Architect.isEmpty())&&(Year==0)&&(Capacity==0)&&(City.isEmpty())&&(Style.isEmpty())   ) return true;
         return false;
    }

    public String getArchitect() {
        return Architect;
    }

    public void setArchitect(String architect) {
        Architect = architect;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public int getCapacity() {
        return Capacity;
    }

    public void setCapacity(int capacity) {
        Capacity = capacity;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getStyle() {
        return Style;
    }

    public void setStyle(String style) {
        Style = style;
    }
}
