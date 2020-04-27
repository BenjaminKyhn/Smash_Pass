package com.example.android.smash_pass.View;

import com.example.android.smash_pass.Model.MyObserver;
import com.example.android.smash_pass.Model.VideoGame;
import com.example.android.smash_pass.Persistence.FirebaseHandler;

import java.util.Map;

public class ViewModel {
    private Map<String, VideoGame> fightingGamesMap;
    private Map<String, VideoGame> fpsGamesMap;
    private Map<String, VideoGame> rtsGamesMap;
    private VideoGame videoGame;
    private FirebaseHandler firebaseHandler;

    public ViewModel() {
        firebaseHandler = new FirebaseHandler();
        fightingGamesMap = firebaseHandler.getFightingGamesMap();
        fpsGamesMap = firebaseHandler.getFpsGamesMap();
        rtsGamesMap = firebaseHandler.getRtsGamesMap();
    }

    public ViewModel(String key) {
        firebaseHandler = new FirebaseHandler();
        fightingGamesMap = firebaseHandler.getFightingGamesMap();
        fpsGamesMap = firebaseHandler.getFpsGamesMap();
        rtsGamesMap = firebaseHandler.getRtsGamesMap();
        videoGame = fightingGamesMap.get(key);
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

    public Map<String, VideoGame> getfpsGamesMap() {
        return fpsGamesMap;
    }

    public Map<String, VideoGame> getRtsGamesMap() {
        return rtsGamesMap;
    }
}
