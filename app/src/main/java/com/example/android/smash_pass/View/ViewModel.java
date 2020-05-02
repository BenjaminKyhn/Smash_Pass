package com.example.android.smash_pass.View;

import com.example.android.smash_pass.Model.MyObservable;
import com.example.android.smash_pass.Model.MyObserver;
import com.example.android.smash_pass.Model.VideoGame;
import com.example.android.smash_pass.Persistence.FirebaseHandler;

import java.util.Map;

public class ViewModel {
    private Map<String, VideoGame> videoGameMap;
    private MyObservable myObservable;
    private FirebaseHandler firebaseHandler;
    private static ViewModel viewModel;

    private ViewModel() {
        myObservable = new MyObservable();
        firebaseHandler = new FirebaseHandler(myObservable);
        videoGameMap = firebaseHandler.getVideoGameMap();
    }

    public static synchronized ViewModel getInstance() {
        if (viewModel == null)
            viewModel = new ViewModel();

        return viewModel;
    }

    public void observeVideoGame(MyObserver myObserver) {
        myObservable.addObserver(myObserver);
    }

    public void saveVideoGame(VideoGame videoGame){
        firebaseHandler.saveVideoGame(videoGame);
    }
}
