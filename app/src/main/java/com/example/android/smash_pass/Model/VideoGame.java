package com.example.android.smash_pass.Model;

public class VideoGame extends MyObservable{
    private String name;
    private String genre;
    private String platform;
    private int year;
    private int numberOfPlayers;
    private boolean onlinePlay;
    private double smashFactor;

    public VideoGame(){
    }

    public VideoGame(String name){
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
        notifyObservers(this.name); // Hvorfor passer vi en String som argument, når notifyObservers tager imod et object?
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public boolean isOnlinePlay() {
        return onlinePlay;
    }

    public void setOnlinePlay(boolean onlinePlay) {
        this.onlinePlay = onlinePlay;
    }

    public double getSmashFactor() {
        return smashFactor;
    }

    public void setSmashFactor(double smashFactor) {
        this.smashFactor = smashFactor;
    }


}
