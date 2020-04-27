package com.example.android.smash_pass.Persistence;

import androidx.annotation.NonNull;

import com.example.android.smash_pass.Model.VideoGame;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class FirebaseHandler {
    private DatabaseReference fightingGamesReference;
    private DatabaseReference fpsGamesReference;
    private Map<String, VideoGame> fightingGamesMap = new HashMap<>();
    private Map<String, VideoGame> fpsGamesMap = new HashMap<>();

    public FirebaseHandler() {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        fpsGamesReference = firebaseDatabase.getReference("FPS Games");
        fightingGamesReference = firebaseDatabase.getReference("Fighting Games");
        saveToDatabase();
        getDatabase();
    }

    private void getDatabase() {
        fightingGamesReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnapshotChild : dataSnapshot.getChildren()) {
                    VideoGame videoGame = dataSnapshotChild.getValue(VideoGame.class);

                    fightingGamesMap.put(dataSnapshotChild.getKey(), videoGame);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        fpsGamesReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnapshotChild : dataSnapshot.getChildren()) {
                    VideoGame videoGame = dataSnapshotChild.getValue(VideoGame.class);

                    fpsGamesMap.put(dataSnapshotChild.getKey(), videoGame);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    // With the current database structure, we're commited to adding all games of a certain genre whenever we want to add one game. Because if we just add one game the others will be removed.
    public void saveToDatabase() {
        fpsGamesMap.put("Fortnite", new VideoGame("Fortnite", "FPS Games", "PC", 2017, 100, true));
        fpsGamesReference.setValue(fpsGamesMap);
        fightingGamesMap.put("Super Smash Bros Ultimate", new VideoGame("Super Smash Bros Ultimate", "Fighting Games", "Nintendo Switch", 2018, 8, true));
        fightingGamesMap.put("Tekken Tag Tournament 2", new VideoGame("Tekken Tag Tournament 2", "Fighting Games", "PlayStation 3", 2011, 2, true));
        fightingGamesMap.put("Brawlhalla", new VideoGame("Brawlhalla", "Fighting Games", "PC", 2014, 4, true));
        fightingGamesReference.setValue(fightingGamesMap);
    }

    public void printStuff(Map<String, VideoGame> retrievedVideoGames) {
        for (String key : retrievedVideoGames.keySet()) {
            VideoGame videoGame = retrievedVideoGames.get(key);
            System.out.println("Key: " + key + ", Name: " + videoGame.getName() + ", Genre: " + videoGame.getGenre());
        }
    }

    public Map<String, VideoGame> getFightingGamesMap() {
        return fightingGamesMap;
    }
    public Map<String, VideoGame> getFpsGamesMap() {return fpsGamesMap;}
}
