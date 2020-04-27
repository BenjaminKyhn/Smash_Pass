package com.example.android.smash_pass.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.smash_pass.Model.VideoGame;
import com.example.android.smash_pass.R;
import com.squareup.picasso.Picasso;

public class VideoGameActivity extends AppCompatActivity {
    private TextView titleText;
    private TextView genreText;
    private TextView platformText;
    private TextView yearText;
    private TextView numberOfPlayersText;
    private TextView onlinePlayText;
    private ImageView mainImage;
    public static VideoGame videoGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_game);

        titleText = findViewById(R.id.titleText);
        mainImage = findViewById(R.id.mainImage);
        genreText = findViewById(R.id.genreText);
        platformText = findViewById(R.id.platformText);
        yearText = findViewById(R.id.yearText);
        numberOfPlayersText = findViewById(R.id.numberOfPlayersText);
        onlinePlayText = findViewById(R.id.onlinePlayText);

        populateViews();
    }

    private void populateViews() {
        if (videoGame.getScreenshots() != null){
            String pictureUrl = videoGame.getScreenshots().get(0);
            Picasso.get().load(pictureUrl).into(mainImage);
        }
        titleText.setText(videoGame.getName());
        genreText.setText(videoGame.getGenre());
        platformText.setText(videoGame.getPlatform());
        yearText.setText(String.valueOf(videoGame.getYear()));
        numberOfPlayersText.setText(String.valueOf(videoGame.getNumberOfPlayers()));
        onlinePlayText.setText(String.valueOf(videoGame.getOnlinePlay()));
    }

    public void home(View view){
        Intent myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }
}
