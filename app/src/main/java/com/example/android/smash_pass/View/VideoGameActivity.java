package com.example.android.smash_pass.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
    private TextView smashFactorText;
    private ImageView mainImage;
    private Button thumbsDownButton;
    private Button thumbsUpButton;

    private boolean voted;

    private ViewModel viewModel;
    private VideoGame currentVideoGame;

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
        smashFactorText = findViewById(R.id.smashFactor);
        thumbsDownButton = findViewById(R.id.thumbsDown);
        thumbsUpButton = findViewById(R.id.thumbsUp);

        Intent startIntent = getIntent();
        currentVideoGame = (VideoGame) startIntent.getSerializableExtra("videoGame");
        viewModel = ViewModel.getInstance();

        thumbsDownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!thumbsUpButton.isEnabled())
                    thumbsUpButton.setEnabled(true);
                if (!voted) {
                    currentVideoGame.setNumberOfVotes(currentVideoGame.getNumberOfVotes() + 1);
                    viewModel.saveVideoGame(currentVideoGame);
                    // we're only updating the firebasereference, but not the object within the program
                    // when we go back to MainActivity, the videoGameMap object is updated
                    // when go back forward to GenresActivity we're passing the updated videoGameMap through an intent and that's why you can vote again
                    voted = true;
                }

                System.out.println(currentVideoGame.getNumberOfVotes());
                thumbsDownButton.setEnabled(false);
            }
        });

        thumbsUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!thumbsDownButton.isEnabled())
                    thumbsDownButton.setEnabled(true);
                if (!voted) {
                    currentVideoGame.setNumberOfVotes(currentVideoGame.getNumberOfVotes() + 1);
                    viewModel.saveVideoGame(currentVideoGame);
                    voted = true;
                }

                System.out.println(currentVideoGame.getNumberOfVotes());
                thumbsUpButton.setEnabled(false);
            }
        });

        populateViews();
    }

    private void populateViews() {
        // Populate the ImageView
        if (currentVideoGame.getScreenshots() != null) {
            String pictureUrl = currentVideoGame.getScreenshots().get(0);
            Picasso.get().load(pictureUrl).into(mainImage);
        }

        // Populate the TextViews
        titleText.setText(currentVideoGame.getName());
        genreText.setText(currentVideoGame.getGenre());
        platformText.setText(currentVideoGame.getPlatform());
        yearText.setText(String.valueOf(currentVideoGame.getYear()));
        numberOfPlayersText.setText(String.valueOf(currentVideoGame.getNumberOfPlayers()));
        onlinePlayText.setText(String.valueOf(currentVideoGame.getOnlinePlay()));
        smashFactorText.setText((int) currentVideoGame.getSmashFactor() + "%");
    }

    public void back(View view) {
        finish();
    }
}
