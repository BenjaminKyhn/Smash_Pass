package com.example.android.smash_pass.View;

import com.example.android.smash_pass.Model.MyObserver;
import com.example.android.smash_pass.Model.VideoGame;
import com.example.android.smash_pass.Persistence.FirebaseHandler;

import java.util.Map;

public class ViewModel {
    private Map<String, VideoGame> fightingGamesMap;
    private VideoGame videoGame;
    private FirebaseHandler firebaseHandler;

    public ViewModel() {
        videoGame = new VideoGame();
        firebaseHandler = new FirebaseHandler(videoGame);
        fightingGamesMap = firebaseHandler.getFightingGamesMap();
    }

    public void observeVideoGame(MyObserver myObserver) {
        videoGame.addObserver(myObserver);
    }

    public VideoGame getVideoGame() {
        return videoGame;
    }

    public Map<String, VideoGame> getFightingGamesMap() {
        return fightingGamesMap;
    }
}
