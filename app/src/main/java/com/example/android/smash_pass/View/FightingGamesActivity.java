package com.example.android.smash_pass.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.android.smash_pass.R;

public class FightingGamesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fighting_games);

        createButtons();
    }

    public void back(View view){
        Intent myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }

    public void changeToVideoGame(View view){
        Intent myIntent = new Intent(this, VideoGameActivity.class);
        startActivity(myIntent);
    }

    public void createButtons(){
        LinearLayout linearLayout = findViewById(R.id.fightingGamesLinearLayout);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(0,40,0,0);

        Button myButton = new Button(this);

        myButton.setLayoutParams(params);
        myButton.setTextSize(20);
        myButton.setTextColor(Color.WHITE);
        myButton.setBackgroundColor(Color.parseColor("#6200EE"));

        myButton.setText("Test");

        linearLayout.addView(myButton);
    }
}
