package com.example.android.smash_pass.View;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.smash_pass.Model.MyObserver;
import com.example.android.smash_pass.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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

        btnOne = findViewById(R.id.btnOne);
        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeToFightingGames();
            }
        });

        btnTwo = findViewById(R.id.btnTwo);
        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeToFPSGames();
            }
        });

        btnThree = findViewById(R.id.btnThree);
        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeToMMOGames();
            }
        });

        btnFour = findViewById(R.id.btnFour);
        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeToRTSGames();
            }
        });

        btnFive = findViewById(R.id.btnFive);
        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeToPuzzlePlatformGames();
            }
        });

        setupViewModel();
    }

    private void setupViewModel() {
        viewModel = new ViewModel();
        viewModel.observeVideoGame(new MyObserver() {
            @Override
            public void update(Object o) {
            }
        });
    }

    public void changeToFightingGames(){
        Intent myIntent = new Intent(this, FightingGamesActivity.class);
        startActivity(myIntent);
    }

    public void changeToFPSGames(){
        Intent myIntent = new Intent(this, FPSGamesActivity.class);
        startActivity(myIntent);
    }

    public void changeToMMOGames(){
        Intent myIntent = new Intent(this, FPSGamesActivity.class);
        startActivity(myIntent);
    }

    public void changeToRTSGames(){
        Intent myIntent = new Intent(this, FPSGamesActivity.class);
        startActivity(myIntent);
    }

    public void changeToPuzzlePlatformGames(){
        Intent myIntent = new Intent(this, FPSGamesActivity.class);
        startActivity(myIntent);
    }
}
