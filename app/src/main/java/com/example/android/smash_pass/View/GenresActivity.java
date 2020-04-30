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

public class GenresActivity extends AppCompatActivity {
    private HashMap<String, VideoGame> videoGameMap;
    private String currentGenre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genres);

        // Get the intent that was passed to this Activity
        Intent startIntent = getIntent();
        videoGameMap = (HashMap<String, VideoGame>) startIntent.getSerializableExtra("map");
        currentGenre = startIntent.getStringExtra("genre");

        // Create a list of buttons and add them to the activity
        createButtons();
    }

    public void back(View view) {
        finish();
    }

    public void openVideoGame(VideoGame videoGame) {
        Intent myIntent = new Intent(this, VideoGameActivity.class);
        myIntent.putExtra("videoGame", videoGame);
        startActivity(myIntent);
    }

    public void createButtons() {
        LinearLayout linearLayout = findViewById(R.id.genresLinearLayout);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 40, 0, 0);

        for (String key : videoGameMap.keySet()) {
            // Create the video game object
            final VideoGame videoGame = videoGameMap.get(key);

            if (videoGame.getGenre().equals(currentGenre)){
                // Create a button
                Button myButton = new Button(this);

                // Set the appearance of the button
                myButton.setLayoutParams(params);
                myButton.setTextSize(20);
                myButton.setTextColor(Color.WHITE);
                myButton.setHighlightColor(Color.BLACK);
                myButton.setBackgroundColor(Color.parseColor("#A10000"));
                String gameTitle = videoGame.getName();
                myButton.setText(gameTitle);

                // Give the button an on-click method to switch intent
                myButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openVideoGame(videoGame);
                    }
                });

                // Add the button to the activity as a ButtonView
                linearLayout.addView(myButton);
            }
        }

        Button backButton = new Button(this);

        // Set the appearance of the button
        backButton.setLayoutParams(params);
        backButton.setTextSize(20);
        backButton.setTextColor(Color.WHITE);
        backButton.setHighlightColor(Color.BLACK);
        backButton.setBackgroundColor(Color.parseColor("#A10000"));
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
