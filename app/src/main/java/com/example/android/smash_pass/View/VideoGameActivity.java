package com.example.android.smash_pass.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.smash_pass.Model.VideoGame;
import com.example.android.smash_pass.R;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class VideoGameActivity extends AppCompatActivity {
    private TextView titleText;
    private TextView genreText;
    private TextView platformText;
    private TextView yearText;
    private TextView numberOfPlayersText;
    private TextView onlinePlayText;
    private TextView smashFactorText;
    private ImageView mainImage;
    private Button passButton;
    private Button smashButton;
    private TextView votedText;

    private ViewModel viewModel;
    private VideoGame currentVideoGame;
    private ArrayList<GoogleSignInAccount> accounts = new ArrayList<>();
    private GoogleSignInAccount currentAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_game);

        // Identify the different views from the layout file
        titleText = findViewById(R.id.titleText);
        mainImage = findViewById(R.id.mainImage);
        genreText = findViewById(R.id.genreText);
        platformText = findViewById(R.id.platformText);
        yearText = findViewById(R.id.yearText);
        numberOfPlayersText = findViewById(R.id.numberOfPlayersText);
        onlinePlayText = findViewById(R.id.onlinePlayText);
        smashFactorText = findViewById(R.id.smashFactor);
        passButton = findViewById(R.id.passButton);
        smashButton = findViewById(R.id.smashButton);

        // Get video game and accounts from the intent that was passed
        Intent startIntent = getIntent();
        currentVideoGame = (VideoGame) startIntent.getSerializableExtra("videoGame");
        accounts = (ArrayList<GoogleSignInAccount>) startIntent.getSerializableExtra("accounts");

        // Instantiate current account if the list of accounts is not empty
        if (accounts != null){
            currentAccount = accounts.get(0);
        }

        // Get the view model
        viewModel = ViewModel.getInstance();

        // Instantiate buttons
        passButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (!currentVideoGame.getVotedAccounts().contains(currentAccount.getId())) {
                    currentVideoGame.setNumberOfVotes(currentVideoGame.getNumberOfVotes() + 1);
                    currentVideoGame.addVotedAccount(currentAccount.getId());
                    /* We're only updating the firebase reference, but not the object within the program,
                    but we're using the instantiated VideoGame object to get rating and numberOfVotes.
                    Therefore, the number returned by currentVideoGame.getNumberOfVotes() is always the same,
                    so when we try to increment it, it will only increment once. But when we go
                    back to MainActivity, the updated videoGameMap is passed as an intent and we can
                    once again increment numberOfPlayers by 1. */
                    currentVideoGame.calculateSmashFactor();
                    smashFactorText.setText((int) currentVideoGame.getSmashFactor() + "%"); // Update the view
                    viewModel.saveVideoGame(currentVideoGame);
                    smashButton.setEnabled(false);
                    passButton.setEnabled(false);
                    Toast.makeText(VideoGameActivity.this,"Thanks for voting PASS",Toast.LENGTH_SHORT).show();
                }
            }
        });

        smashButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (!currentVideoGame.getVotedAccounts().contains(currentAccount.getId())) {
                    currentVideoGame.setNumberOfVotes(currentVideoGame.getNumberOfVotes() + 1);
                    currentVideoGame.setRating(currentVideoGame.getRating() + 1);
                    currentVideoGame.addVotedAccount(currentAccount.getId());
                    currentVideoGame.calculateSmashFactor();
                    smashFactorText.setText((int) currentVideoGame.getSmashFactor() + "%"); // Update the view
                    viewModel.saveVideoGame(currentVideoGame);
                    smashButton.setEnabled(false);
                    passButton.setEnabled(false);
                    Toast.makeText(VideoGameActivity.this,"Thanks for voting SMASH",Toast.LENGTH_SHORT).show();
                }

            }
        });

        // Disable the buttons if the user already voted
        if (currentVideoGame.getVotedAccounts().contains(currentAccount.getId())){
            smashButton.setEnabled(false);
            passButton.setEnabled(false);
            votedText = findViewById(R.id.votedText);
            votedText.setText("Attention: You've already voted on this game!");
        }

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
