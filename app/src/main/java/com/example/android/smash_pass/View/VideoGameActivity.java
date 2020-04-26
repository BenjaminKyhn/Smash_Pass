package com.example.android.smash_pass.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.smash_pass.Model.MyObserver;
import com.example.android.smash_pass.Model.VideoGame;
import com.example.android.smash_pass.R;
import com.squareup.picasso.Picasso;

public class VideoGameActivity extends AppCompatActivity {
    TextView titleText;
    TextView genreText;
    TextView platformText;
    TextView yearText;
    TextView numberOfPlayersText;
    TextView onlinePlayText;
    ImageView mainImage;
    ViewModel viewModel;
    VideoGame videoGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_game);

        titleText = findViewById(R.id.titleText);
        genreText = findViewById(R.id.genreText);
        platformText = findViewById(R.id.platformText);
        yearText = findViewById(R.id.yearText);
        numberOfPlayersText = findViewById(R.id.numberOfPlayersText);
        onlinePlayText = findViewById(R.id.onlinePlayText);

        mainImage = findViewById(R.id.mainImage);
        String pictureUrl = "https://www.pngitem.com/pimgs/m/157-1579710_picture-chuck-norris-hd-png-download.png";
        Picasso.get().load(pictureUrl).into(mainImage);

        populateViews();
    }

    private void populateViews() {
        viewModel = new ViewModel("Super Smash Bros Ultimate");
        videoGame = viewModel.getVideoGame();
        titleText.setText(videoGame.getName());
        genreText.setText(videoGame.getGenre());
        platformText.setText(videoGame.getPlatform());
        yearText.setText(String.valueOf(videoGame.getYear()));
        numberOfPlayersText.setText(String.valueOf(videoGame.getNumberOfPlayers()));
        onlinePlayText.setText(String.valueOf(videoGame.getOnlinePlay()));

//        viewModel.observeVideoGame(new MyObserver() {
//            @Override
//            public void update(Object o) { // This is bad. Why does it take an object parameter if I don't use it?
//                titleText.setText(videoGame.getName());
//                genreText.setText(viewModel.getVideoGame().getGenre());
//                platformText.setText(viewModel.getVideoGame().getPlatform());
//                yearText.setText(String.valueOf(viewModel.getVideoGame().getYear()));
//                numberOfPlayersText.setText(String.valueOf(viewModel.getVideoGame().getNumberOfPlayers()));
//                onlinePlayText.setText(String.valueOf(viewModel.getVideoGame().getOnlinePlay()));
//                genreText.setText((String) o);
//            }
//        });
    }

    public void home(View view){
        Intent myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }
}
