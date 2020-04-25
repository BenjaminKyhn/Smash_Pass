package com.example.android.smash_pass.Model;

public class VideoGame extends MyObservable{
    private String name;
    private String genre;
    private String platform;
    private long year;
    private long numberOfPlayers;
    private boolean onlinePlay;
    private double smashFactor;

    public VideoGame(){
    }

    public VideoGame(String name){
        this.name = name;
    }

    public String getName(){
        return name;
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
        notifyObservers(this.genre);
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
        notifyObservers(this.platform);
    }

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
        notifyObservers(this.year);
    }

    public long getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(long numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
        notifyObservers(this.numberOfPlayers);
    }

    public String getOnlinePlay() {
        if (onlinePlay)
            return "Yes";
        else
            return "No";
    }

    public void setOnlinePlay(boolean onlinePlay) {
        this.onlinePlay = onlinePlay;
        notifyObservers(this.onlinePlay);
    }

    public double getSmashFactor() {
        return smashFactor;
    }

    public void setSmashFactor(double smashFactor) {
        this.smashFactor = smashFactor;
    }
}
