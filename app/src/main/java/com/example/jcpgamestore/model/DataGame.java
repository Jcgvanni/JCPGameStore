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

}
