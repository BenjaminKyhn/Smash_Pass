package com.example.android.smash_pass.View;

import com.example.android.smash_pass.Model.MyObserver;
import com.example.android.smash_pass.Model.VideoGame;
import com.example.android.smash_pass.Persistence.FirebaseHandler;

public class ViewModel {
    private VideoGame videoGame;
    private FirebaseHandler firebaseHandler;

    public ViewModel() {
        videoGame = new VideoGame();
        firebaseHandler = new FirebaseHandler(videoGame);
    }

    public void observeVideoGame(MyObserver myObserver) {
        videoGame.addObserver(myObserver);
    }

    public void persist(String text) {
        firebaseHandler.insert(text);
    }

    public VideoGame getVideoGame() {
        return videoGame;
    }
}
