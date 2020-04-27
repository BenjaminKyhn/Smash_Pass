package com.example.android.smash_pass.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

        viewModel = new ViewModel();
        fpsGamesMap = viewModel.getfpsGamesMap();
    }

    public void back(View view){
        Intent myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }

    public void changeToVideoGame(View view, VideoGame videoGame) {
        Intent myIntent = new Intent(this, VideoGameActivity.class);
        startActivity(myIntent);
        VideoGameActivity.videoGame = videoGame;
    }

    public void createButton() {
        LinearLayout linearLayout = findViewById(R.id.fpsGamesLinearLayout);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 40, 0, 0);

        for (String key : fpsGamesMap.keySet()) {

        }
    }

}
