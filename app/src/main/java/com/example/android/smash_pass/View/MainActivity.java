package com.example.android.smash_pass.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.android.smash_pass.Model.MyObserver;
import com.example.android.smash_pass.Model.VideoGame;
import com.example.android.smash_pass.R;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private ViewModel viewModel;
    private HashMap<String, VideoGame> fightingGamesMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViewModel();
    }

    private void setupViewModel() {
        viewModel = ViewModel.getInstance();

        viewModel.observeVideoGame(new MyObserver() {
            @Override
            public void update(Object o) {
                fightingGamesMap = (HashMap<String, VideoGame>) o;
            }
        });
    }

    public void changeToFightingGames(View view) {
        Intent myIntent = new Intent(this, FightingGamesActivity.class);
        myIntent.putExtra("map", fightingGamesMap);
        startActivity(myIntent);
    }

    public void changeToFPSGames(View view) {
        Intent myIntent = new Intent(this, FPSGamesActivity.class);
        startActivity(myIntent);
    }

    public void changeToMMOGames(View view) {
        Intent myIntent = new Intent(this, MMORPGGamesActivity.class);
        startActivity(myIntent);
    }

    public void changeToRTSGames(View view) {
        Intent myIntent = new Intent(this, RTSGamesActivity.class);
        startActivity(myIntent);
    }

    public void changeToDungeonCrawlerGames(View view) {
        Intent myIntent = new Intent(this, DungeonCrawlerGamesActivity.class);
        startActivity(myIntent);
    }

    public void changeToTurnBasedStrategyGames(View view) {
        Intent myIntent = new Intent(this, TurnBasedStrategyGamesActivity.class);
        startActivity(myIntent);
    }
}
