package com.example.android.smash_pass.View;

import com.example.android.smash_pass.Model.MyObservable;
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
    private Map<String, VideoGame> mmorpgGamesMap;
//    private VideoGame videoGame;
    private MyObservable myObservable;
    private FirebaseHandler firebaseHandler;
    private static ViewModel viewModel;

    private ViewModel() {
        myObservable = new MyObservable();
        firebaseHandler = new FirebaseHandler(myObservable);
        dungeonCrawlerGamesMap = firebaseHandler.getDungeonCrawlerGamesMap();
        fightingGamesMap = firebaseHandler.getFightingGamesMap();
        fpsGamesMap = firebaseHandler.getFpsGamesMap();
        rtsGamesMap = firebaseHandler.getRtsGamesMap();
        turnBasedStrategyGamesMap = firebaseHandler.getTurnBasedStrategyGamesMap();
        mmorpgGamesMap = firebaseHandler.getMmorpgGamesMap();
    }

    public static synchronized ViewModel getInstance() {
        if (viewModel == null)
            viewModel = new ViewModel();

        return viewModel;
    }

    public void observeVideoGame(MyObserver myObserver) {
        myObservable.addObserver(myObserver);
    }


    public Map<String, VideoGame> getDungeonCrawlerGamesMap() {
        return dungeonCrawlerGamesMap;
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

    public Map<String, VideoGame> getTurnBasedStrategyGamesMap() {
        return turnBasedStrategyGamesMap;
    }

    public Map<String, VideoGame> getMmorpgGamesMap() {
        return mmorpgGamesMap;
    }
}
