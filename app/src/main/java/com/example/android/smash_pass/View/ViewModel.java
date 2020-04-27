package com.example.android.smash_pass.View;

import com.example.android.smash_pass.Model.MyObserver;
import com.example.android.smash_pass.Model.VideoGame;
import com.example.android.smash_pass.Persistence.FirebaseHandler;

import java.util.Map;

public class ViewModel {
    private Map<String, VideoGame> dungeonCrawlerGamesMap;
    private Map<String, VideoGame> fightingGamesMap;
    private Map<String, VideoGame> fpsGamesMap;
    private Map<String, VideoGame> rtsGamesMap;
    private Map<String, VideoGame> turnBasedStrategyGamesMap;
    private VideoGame videoGame;
    private FirebaseHandler firebaseHandler;

    public ViewModel() {
        firebaseHandler = new FirebaseHandler();
        dungeonCrawlerGamesMap = firebaseHandler.getDungeonCrawlerGamesMap();
        fightingGamesMap = firebaseHandler.getFightingGamesMap();
        fpsGamesMap = firebaseHandler.getFpsGamesMap();
        rtsGamesMap = firebaseHandler.getRtsGamesMap();
        turnBasedStrategyGamesMap = firebaseHandler.getTurnBasedStrategyGamesMap();
    }

    public ViewModel(String key) {
        firebaseHandler = new FirebaseHandler();
        fightingGamesMap = firebaseHandler.getFightingGamesMap();
        fpsGamesMap = firebaseHandler.getFpsGamesMap();
        rtsGamesMap = firebaseHandler.getRtsGamesMap();
        turnBasedStrategyGamesMap = firebaseHandler.getTurnBasedStrategyGamesMap();
        videoGame = fightingGamesMap.get(key);
    }

    public void observeVideoGame(MyObserver myObserver) {
        videoGame.addObserver(myObserver);
    }

    public VideoGame getVideoGame() {
        return videoGame;
    }

    public Map<String, VideoGame> getdungeonCrawlerGamesMap() {return dungeonCrawlerGamesMap;}

    public Map<String, VideoGame> getFightingGamesMap() {
        return fightingGamesMap;
    }

    public Map<String, VideoGame> getfpsGamesMap() {
        return fpsGamesMap;
    }

    public Map<String, VideoGame> getRtsGamesMap() {
        return rtsGamesMap;
    }

    public  Map<String, VideoGame> getTurnBasedStrategyGamesMap(){
        return turnBasedStrategyGamesMap;
    }
}
