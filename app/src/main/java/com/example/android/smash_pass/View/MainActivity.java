package com.example.android.smash_pass.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.android.smash_pass.Model.MyObserver;
import com.example.android.smash_pass.Model.VideoGame;
import com.example.android.smash_pass.R;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private ViewModel viewModel;
    private HashMap<String, VideoGame> videoGameMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViewModel();
    }

    public void createButtons(View view) {
        // Remove the start button
        Button start = findViewById(R.id.btnStart);
        ((ViewGroup) start.getParent()).removeView(start);

        // Create a list and add all genres from the map to the list
        ArrayList<String> allGenres = new ArrayList<>();
        for (String key : videoGameMap.keySet()) {

            final VideoGame videoGame = videoGameMap.get(key);

            if (!allGenres.contains(videoGame.getGenre()))
                allGenres.add(videoGame.getGenre());
        }

        // Set layout parameters
        LinearLayout linearLayout = findViewById(R.id.mainLinearLayout);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 40, 0, 0);

        // Iterate through the list of genres
        for (final String genre : allGenres){
            // Create a button
            Button myButton = new Button(this);

            // Set the appearance of the button
            myButton.setLayoutParams(params);
            myButton.setTextSize(20);
            myButton.setTextColor(Color.WHITE);
            myButton.setHighlightColor(Color.BLACK);
            myButton.setBackgroundColor(Color.parseColor("#A10000"));
            myButton.setText(genre);

            // Give the button an on-click method to switch intent
            myButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openGenre(v, genre);
                }
            });

            // Add the button to the activity as a ButtonView
            linearLayout.addView(myButton);
        }
    }

    private void setupViewModel() {
        viewModel = ViewModel.getInstance();

        viewModel.observeVideoGame(new MyObserver() {
            @Override
            public void update(Object o) {
                videoGameMap = (HashMap<String, VideoGame>) o;
            }
        });
    }

    public void openGenre(View view, String genre) {
        Intent myIntent = new Intent(this, GenresActivity.class);
        myIntent.putExtra("map", videoGameMap);
        startActivity(myIntent);
        GenresActivity.currentGenre = genre;
    }

}
