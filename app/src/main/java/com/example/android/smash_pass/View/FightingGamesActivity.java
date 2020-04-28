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

import java.util.HashMap;
import java.util.Map;

public class FightingGamesActivity extends AppCompatActivity {
    private Map<String, VideoGame> fightingGamesMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fighting_games);

        // Get the intent that was passed to this Activity
        Intent startIntent = getIntent();
        fightingGamesMap = (HashMap<String, VideoGame>) startIntent.getSerializableExtra("map");

        // Create a list of buttons and add them to the activity
        createButtons();
    }

    public void back(View view) {
        finish();
    }

    public void changeToVideoGame(View view, VideoGame videoGame) {
        Intent myIntent = new Intent(this, VideoGameActivity.class);
        startActivity(myIntent);
        VideoGameActivity.videoGame = videoGame;
    }

    public void createButtons() {
        LinearLayout linearLayout = findViewById(R.id.fightingGamesLinearLayout);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 40, 0, 0);

        for (String key : fightingGamesMap.keySet()) {
            // Create the video game object
            final VideoGame videoGame = fightingGamesMap.get(key);

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
                    changeToVideoGame(v, videoGame);
                }
            });

            // Add the button to the activity as a ButtonView
            linearLayout.addView(myButton);
        }

        Button backButton = new Button(this);

        // Set the appearance of the button
        backButton.setLayoutParams(params);
        backButton.setTextSize(20);
        backButton.setTextColor(Color.WHITE);
        backButton.setBackgroundColor(Color.parseColor("#6200EE"));
        backButton.setText("Back");

        // Give the button an on-click method to switch intent
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back(v);
            }
        });

        // Add the button to the activity as a ButtonView
        linearLayout.addView(backButton);
    }
}
