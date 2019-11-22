package com.example.jcpgamestore.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class DataGame implements Serializable {
    int id;
    String gameName;
    Double price;
    int image;

    public DataGame() {}

    public DataGame(String gameName, int image) {
        super();
        this.gameName = gameName;
        this.image = image;
    }

    protected DataGame(Parcel in) {
        id = in.readInt();
        gameName = in.readString();
        if (in.readByte() == 0) {
            price = null;
        } else {
            price = in.readDouble();
        }
        image = in.readInt();
    }
//
//    public static final Creator<DataGame> CREATOR = new Creator<DataGame>() {
//        @Override
//        public DataGame createFromParcel(Parcel in) {
//            return new DataGame( in );
//        }
//
//        @Override
//        public DataGame[] newArray(int size) {
//            return new DataGame[size];
//        }
//    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }


    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
//
//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    @Override
//    public void writeToParcel(Parcel parcel, int i) {
//        parcel.writeInt( id );
//        parcel.writeDouble( price );
//        parcel.writeString( gameName );
//        parcel.writeInt( image );
//    }
}
