package com.example.android.smash_pass.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android.smash_pass.Model.MyObserver;
import com.example.android.smash_pass.R;

public class MainActivity extends AppCompatActivity {
    private Button btnOne;
    private Button btnTwo;
    private Button btnThree;
    private Button btnFour;
    private Button btnFive;
    private ViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void changeToFightingGames(View view){
        Intent myIntent = new Intent(this, FightingGamesActivity.class);
        startActivity(myIntent);
    }

    public void changeToFPSGames(View view){
        Intent myIntent = new Intent(this, FPSGamesActivity.class);
        startActivity(myIntent);
    }

    public void changeToMMOGames(View view){
        Intent myIntent = new Intent(this, MMORPGGamesActivity.class);
        startActivity(myIntent);
    }

    public void changeToRTSGames(View view){
        Intent myIntent = new Intent(this, RTSGamesActivity.class);
        startActivity(myIntent);
    }

    public void changeToDungeonCrawlerGames(View view){
        Intent myIntent = new Intent(this, DungeonCrawlerGamesActivity.class);
        startActivity(myIntent);
    }

    public void changeToVideoGame(View view){
        //TODO: add code here to inject information about the game from the db into the activity
        Intent myIntent = new Intent(this, VideoGameActivity.class);
        startActivity(myIntent);
    }
}
