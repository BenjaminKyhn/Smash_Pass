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

public class FPSGamesActivity extends AppCompatActivity {
    private ViewModel viewModel;
    private Map<String, VideoGame> fpsGamesMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_p_s_games);

        viewModel = ViewModel.getInstance();
        fpsGamesMap = viewModel.getfpsGamesMap();

        createButtons();
    }

    public void back(View view) {
        finish();
    }

    public void changeToVideoGame(View view, VideoGame videoGame) {
        Intent myIntent = new Intent(this, VideoGameActivity.class);
        startActivity(myIntent);
        VideoGameActivity.currentVideoGame = videoGame;
    }

    public void createButtons() {
        LinearLayout linearLayout = findViewById(R.id.fpsGamesLinearLayout);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 40, 0, 0);

        for (String key : fpsGamesMap.keySet()) {
            final VideoGame videoGame = fpsGamesMap.get(key);

            Button myButton = new Button(this);

            myButton.setLayoutParams(params);
            myButton.setTextSize(20);
            myButton.setTextColor(Color.WHITE);
            myButton.setBackgroundColor(Color.parseColor("#6200EE"));
            String gameTitle = videoGame.getName();
            myButton.setText(gameTitle);

            myButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    changeToVideoGame(v, videoGame);
                }
            });

            linearLayout.addView(myButton);
        }

        Button backButton = new Button(this);

        backButton.setLayoutParams(params);
        backButton.setTextSize(20);
        backButton.setTextColor(Color.WHITE);
        backButton.setBackgroundColor(Color.parseColor("#6200EE"));
        backButton.setText("Back");

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back(v);
            }
        });

        linearLayout.addView(backButton);
    }
}
