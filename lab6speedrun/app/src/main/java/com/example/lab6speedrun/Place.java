package com.example.lab6speedrun;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.yandex.mapkit.MapKit;
import com.yandex.mapkit.geometry.Point;

import java.io.Serializable;
public class Place implements Parcelable{
    private String Name;
    private String Description;
    private String WorkingTime;
    private int PictureOfPlace;
    private Point Coords;
    private boolean flag;
    private Options PlaceOptions;
    public Place(String newName, String newDescription, double latitude, double longtitude) {
        Name = newName;
        Description = newDescription;
        PictureOfPlace = R.drawable.defaultpic;
        Coords = new Point(latitude, longtitude);
        flag = false;
    }

    public Place(String newName, String newDescription, int newPictureOfPlace, double latitude, double longtitude) {
        Name = newName;
        Description = newDescription;
        WorkingTime = "";
        PictureOfPlace = newPictureOfPlace;
        Coords = new Point(latitude, longtitude);
        flag = false;
    }

    public Place(String newName, String newDescription, int newPictureOfPlace, double latitude, double longtitude, Options newOpt) {
        Name = newName;
        Description = newDescription;
        WorkingTime = "";
        PictureOfPlace = newPictureOfPlace;
        Coords = new Point(latitude, longtitude);
        flag = false;
        PlaceOptions=newOpt;
    }
    Place(Parcel in){
        String[] data = new String[10];
        in.readStringArray(data);
        Name= data[0];
        Description = data[1];
        PictureOfPlace = Integer.parseInt(data[2]);
        Coords = new Point(Double.parseDouble(data[3]), Double.parseDouble(data[4]));
        PlaceOptions = new Options(data[5],Integer.parseInt(data[6]),Integer.parseInt(data[7]),data[8],data[9]);
                // Options(String architect, int year, int capacity, String city, String style)
    }
    /*
    Courier(Parcel in){
    String[] data = new String[4];
    in.readStringArray(data);
    Name=data[0];
    canDiliveryDocuments=Boolean.parseBoolean(data[3]);
    couriers_ship=new Ship(Dooble.parseDouble(data[2]),data[1]);
    }

    public void writeToParcel(@NonNull Parcel parcel, int i) {
    parcel.writeStringArray(new String[]{this.Name, this.couriers_ship.getName(),
    String.valueOf(this.couriers.getVelocity()),String.valueOf(this.canDiliveryDocuments)    }   );
    }

     public static final Creator<Courier> CREATOR = new Creator<Courier>() {
        @Override
        public Courier createFromParcel(Parcel in) {
            return new Courier(in);
        }

        @Override
        public Courier[] newArray(int size) {
            return new Courier[size];
        }
    };
     */

    public static final Creator<Place> CREATOR = new Creator<Place>() {
        @Override
        public Place createFromParcel(Parcel in) {
            return new Place(in);
        }

        @Override
        public Place[] newArray(int size) {
            return new Place[size];
        }
    };

    public Options getPlaceOptions() {
        return PlaceOptions;
    }

    public void setPlaceOptions(Options placeOptions) {
        PlaceOptions = placeOptions;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getWorkingTime() {
        return WorkingTime;
    }

    public void setWorkingTime(String workingTime) {
        WorkingTime = workingTime;
    }

    public int getPictureOfPlace() {
        return PictureOfPlace;
    }

    public void setPictureOfPlace(int pictureOfPlace) {
        PictureOfPlace = pictureOfPlace;
    }

    public Point getCoords() {
        return Coords;
    }

    public void setCoords(Point coords) {
        Coords = coords;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeStringArray(new String[]{this.Name, this.Description, String.valueOf(this.PictureOfPlace),
                String.valueOf(Coords.getLatitude()), String.valueOf(Coords.getLongitude()),
                PlaceOptions.getArchitect(), String.valueOf(PlaceOptions.getYear()),
                String.valueOf(PlaceOptions.getCapacity()), PlaceOptions.getCity(),PlaceOptions.getStyle()});
        // Options(String architect, int year, int capacity, String city, String style)

    }

}
