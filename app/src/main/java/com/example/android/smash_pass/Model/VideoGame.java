package com.example.android.smash_pass.Model;

public class VideoGame extends MyObservable{
    private String text;
    private String genre;
    private String name;
    private int year;
    private double smashFactor;

    public VideoGame(){
    }

    public VideoGame(String name){
        this.name = name;
    }

    public void setText(String text){
        this.text = text;
        notifyObservers(this.text); // Hvorfor passer vi en String som argument, når notifyObservers tager imod et object?
    }
}
