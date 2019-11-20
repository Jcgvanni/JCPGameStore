package com.example.jcpgamestore;

public class DataGame {
    String gameName;
    String gamePrice;
    int image;

    public DataGame(String gameName, String gamePrice, int image) {
        this.gameName = gameName;
        this.gamePrice = gamePrice;
        this.image = image;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGamePrice() {
        return gamePrice;
    }

    public void setGamePrice(String gamePrice) {
        this.gamePrice = gamePrice;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
