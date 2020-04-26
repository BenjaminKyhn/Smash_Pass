package com.example.android.smash_pass.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.android.smash_pass.Model.VideoGame;
import com.example.android.smash_pass.R;

import java.util.Map;

public class FightingGamesActivity extends AppCompatActivity {
    private ViewModel viewModel;
    private Map<String, VideoGame> fightingGamesMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fighting_games);

        // Instantiate a view model so we can get the map of video games
        viewModel = new ViewModel();
        fightingGamesMap = viewModel.getFightingGamesMap();

        // Create a list of buttons and add them to the activity
        createButtons();
    }

    public void back(View view) {
        Intent myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }

    public void changeToVideoGame(View view) {
        Intent myIntent = new Intent(this, VideoGameActivity.class);
        startActivity(myIntent);
    }

    public void createButtons() {
        LinearLayout linearLayout = findViewById(R.id.fightingGamesLinearLayout);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 40, 0, 0);

        for (String key : fightingGamesMap.keySet()) {
            // Create the video game object
            VideoGame videoGame = fightingGamesMap.get(key);

            // Create a button
            Button myButton = new Button(this);

            // Set the appearance of the button
            myButton.setLayoutParams(params);
            myButton.setTextSize(20);
            myButton.setTextColor(Color.WHITE);
            myButton.setBackgroundColor(Color.parseColor("#6200EE"));
            String gameTitle = videoGame.getName();
            myButton.setText(gameTitle);

            // Give the button an on-click method to switch intent
            myButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    changeToVideoGame(v);
                }
            });

            // Add the button to the activity as a ButtonView
            linearLayout.addView(myButton);
        }
    }
}
