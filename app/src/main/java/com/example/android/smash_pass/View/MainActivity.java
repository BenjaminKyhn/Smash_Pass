package com.example.android.smash_pass.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.android.smash_pass.Model.MyObserver;
import com.example.android.smash_pass.Model.VideoGame;
import com.example.android.smash_pass.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private SignInButton signInButton;
    private Button signOutButton;
    private GoogleSignInClient mGoogleSignInClient;
    private FirebaseAuth mAuth;
    private int RC_SIGN_IN = 1;
    private String userID;

    private ViewModel viewModel;
    private HashMap<String, VideoGame> videoGameMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signInButton = findViewById(R.id.sign_in_button);
        signOutButton = findViewById(R.id.sign_out_button);
        mAuth = FirebaseAuth.getInstance();

        setupViewModel();

        startSignInProcess();
    }

    private void startSignInProcess() {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });

        signOutButton.setVisibility(View.INVISIBLE);
    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount acc = completedTask.getResult(ApiException.class);
            Toast.makeText(MainActivity.this, "Signed In Successfully", Toast.LENGTH_SHORT).show();
            firebaseGoogleAuth(acc);
        } catch (ApiException e) {
            Log.d("LoginFail", e.getMessage());
            Toast.makeText(MainActivity.this, "Sign In Failed", Toast.LENGTH_SHORT).show();
            firebaseGoogleAuth(null);
        }
    }

    private void firebaseGoogleAuth(GoogleSignInAccount acc) {
        //check if the account is null
        if (acc != null) {
            AuthCredential authCredential = GoogleAuthProvider.getCredential(acc.getIdToken(), null);
            mAuth.signInWithCredential(authCredential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        FirebaseUser user = mAuth.getCurrentUser();
                        updateUI(user);
                    } else {
                        updateUI(null);
                    }
                }
            });
        }
    }

    private void updateUI(FirebaseUser fUser) {
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(getApplicationContext());
        if (account != null) {
            userID = account.getId();
            String personName = account.getDisplayName();
            String personEmail = account.getEmail();
            signInButton.setVisibility(View.INVISIBLE);
            signOutButton.setVisibility(View.VISIBLE);
            Toast.makeText(MainActivity.this, personName + " " + personEmail, Toast.LENGTH_SHORT).show();
            createButtons();
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

    public void openGenre(String genre) {
        Intent myIntent = new Intent(this, GenresActivity.class);
        myIntent.putExtra("map", videoGameMap);
        myIntent.putExtra("genre", genre);
        myIntent.putExtra("userID", userID);
        startActivity(myIntent);
    }

    public void createButtons() {
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
        for (final String genre : allGenres) {
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
                    openGenre(genre);
                }
            });

            // Add the button to the activity as a ButtonView
            linearLayout.addView(myButton);
        }

        // Set the appearance of the button
        signOutButton.setLayoutParams(params);
        signOutButton.setTextSize(20);
        signOutButton.setTextColor(Color.BLACK);
        signOutButton.setHighlightColor(Color.BLACK);
        signOutButton.setBackgroundColor(Color.parseColor("#A10000"));
        signOutButton.setText("Sign Out");

        // Give the button an on-click method to switch intent
        signOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGoogleSignInClient.signOut();
                Toast.makeText(MainActivity.this, "You are Logged Out", Toast.LENGTH_SHORT).show();
                signInButton.setVisibility(View.VISIBLE);
                signOutButton.setVisibility(View.INVISIBLE);
                finish(); // TODO: find a way to remove the buttons so we don't have to exit the app
            }
        });
    }
}
