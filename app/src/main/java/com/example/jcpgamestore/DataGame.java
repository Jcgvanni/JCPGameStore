package com.example.jcpgamestore;

public class DataGame {
    String gameName, gameRelease;
    int image;
    int music;

    public DataGame(String gameName, String gameRelease, int image, int music) {
        this.gameName = gameName;
        this.gameRelease = gameRelease;
        this.image = image;
        this.music = music;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameRelease() {
        return gameRelease;
    }

    public void setGameRelease(String gameDesc) {
        this.gameRelease = gameDesc;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getMusic() {
        return music;
    }

    public void setMusic(int music) {
        this.music = music;
    }
}
