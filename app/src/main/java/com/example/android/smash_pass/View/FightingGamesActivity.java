package com.example.android.smash_pass.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.android.smash_pass.R;

public class FightingGamesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fighting_games);
    }

    public void back(View view){
        Intent myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }
}
