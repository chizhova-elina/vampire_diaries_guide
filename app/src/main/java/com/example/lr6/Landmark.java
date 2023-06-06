package com.example.lr6;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.yandex.mapkit.geometry.Point;

public class Landmark implements Parcelable {
    private String name;
    private int description;
    private String time;
    private Point point;
    private int img;

    public Landmark(String name, int description, String time, Point point,int img) {
        this.name = name;
        this.description = description;
        this.time = time;
        this.point = point;
        this.img = img;
    }
    public Landmark(String name, int description, String time, Point point) {
        this.name = name;
        this.description = description;
        this.time = time;
        this.point = point;
        img=R.drawable.no_image_available;
    }
    public Landmark(String name, int description, Point point, int img) {
        this.name = name;
        this.description = description;
        this.time = "24hours";
        this.point = point;
        this.img = img;
    }
    public Landmark(String name, int description, Point point) {
        this.name = name;
        this.description = description;
        this.time = "24hours";
        this.point = point;
        img=R.drawable.no_image_available;
    }

    protected Landmark(Parcel in) {
        name = in.readString();
        description = in.readInt();
        img = in.readInt();
        time = in.readString();
        point = new Point(in.readDouble(), in.readDouble());
    }

    public static final Creator<Landmark> CREATOR = new Creator<Landmark>() {
        @Override
        public Landmark createFromParcel(Parcel in) {
            return new Landmark(in);
        }

        @Override
        public Landmark[] newArray(int size) {
            return new Landmark[size];
        }
    };

    public String getName() {
        return name;
    }

    public int getDescription() {
        return description;
    }

    public String getTime() {
        return time;
    }

    public Point getPoint() {
        return new Point(point.getLatitude(), point.getLongitude());
    }
    public int getImg() {
        return img;
    }

    @Override
    public String toString(){
        return getName();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(description);
        dest.writeInt(img);
        dest.writeString(time);
        dest.writeDouble(point.getLatitude());
        dest.writeDouble(point.getLongitude());
    }
}