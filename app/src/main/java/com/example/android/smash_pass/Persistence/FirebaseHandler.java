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
    private DatabaseReference dungeonCrawlerGamesReference;
    private DatabaseReference fightingGamesReference;
    private DatabaseReference fpsGamesReference;
    private DatabaseReference rtsGamesReference;
    private DatabaseReference turnBasedStrategyGamesReference;
    private DatabaseReference mmorpgGamesReference;
    private Map<String, VideoGame> dungeonCrawlerGamesMap = new HashMap<>();
    private Map<String, VideoGame> fightingGamesMap = new HashMap<>();
    private Map<String, VideoGame> fpsGamesMap = new HashMap<>();
    private Map<String, VideoGame> rtsGamesMap = new HashMap<>();
    private Map<String, VideoGame> turnBasedStrategyGamesMap = new HashMap<>();
    private Map<String, VideoGame> mmorpgGamesMap = new HashMap<>();

    public FirebaseHandler() {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        dungeonCrawlerGamesReference = firebaseDatabase.getReference("Dungeon Crawler Games");
        fightingGamesReference = firebaseDatabase.getReference("Fighting Games");
        fpsGamesReference = firebaseDatabase.getReference("FPS Games");
        rtsGamesReference = firebaseDatabase.getReference("RTS Games");
        turnBasedStrategyGamesReference = firebaseDatabase.getReference("Turn-based Strategy Games");
        mmorpgGamesReference = firebaseDatabase.getReference("MMORPG Games");
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

        rtsGamesReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnapshotChild : dataSnapshot.getChildren()) {
                    VideoGame videoGame = dataSnapshotChild.getValue(VideoGame.class);

                    rtsGamesMap.put(dataSnapshotChild.getKey(), videoGame);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        turnBasedStrategyGamesReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnapshotChild : dataSnapshot.getChildren()) {
                    VideoGame videoGame = dataSnapshotChild.getValue(VideoGame.class);

                    turnBasedStrategyGamesMap.put(dataSnapshotChild.getKey(), videoGame);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        dungeonCrawlerGamesReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnapshotChild : dataSnapshot.getChildren()) {
                    VideoGame videoGame = dataSnapshotChild.getValue(VideoGame.class);

                    dungeonCrawlerGamesMap.put(dataSnapshotChild.getKey(), videoGame);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        mmorpgGamesReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnapshotChild : dataSnapshot.getChildren()) {
                    VideoGame videoGame = dataSnapshotChild.getValue(VideoGame.class);

                    mmorpgGamesMap.put(dataSnapshotChild.getKey(), videoGame);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    // With the current database structure, we're commited to adding all games of a certain genre whenever we want to add one game. Because if we just add one game the others will be removed.
    public void saveToDatabase() {
        dungeonCrawlerGamesMap.put("Wizard of Legend", new VideoGame("Wizard of Legend", "Dungeon Crawler Games", "PC", 2018, 2, true));
        dungeonCrawlerGamesReference.setValue(dungeonCrawlerGamesMap);
        fightingGamesMap.put("Super Smash Bros Ultimate", new VideoGame("Super Smash Bros Ultimate", "Fighting Games", "Nintendo Switch", 2018, 8, true));
        fightingGamesMap.put("Super Smash Bros 4", new VideoGame("Super Smash Bros 4", "Fighting Games", "Nintendo Wii U", 2014, 8, true));
        fightingGamesMap.put("Tekken Tag Tournament 2", new VideoGame("Tekken Tag Tournament 2", "Fighting Games", "PlayStation 3", 2011, 2, true));
        fightingGamesMap.put("Brawlhalla", new VideoGame("Brawlhalla", "Fighting Games", "PC", 2014, 4, true));
        fightingGamesReference.setValue(fightingGamesMap);
        fpsGamesMap.put("Fortnite", new VideoGame("Fortnite", "FPS Games", "PC", 2017, 100, true));
        fpsGamesMap.put("Call of Duty: Modern Warfare 2", new VideoGame("Call of Duty: Modern Warfare 2", "FPS Games", "PC", 2009, 12, true));
        fpsGamesReference.setValue(fpsGamesMap);
        rtsGamesMap.put("Starcraft II", new VideoGame("Starcraft II", "RTS Games", "PC", 2010, 8, true));
        rtsGamesMap.put("Age of Empires II: Definitive Edition", new VideoGame("Age of Empires II: Definitive Edition", "RTS Games", "PC", 2019, 4, true));
        rtsGamesMap.put("Mount & Blade II: Bannerlord", new VideoGame("Mount & Blade II: Bannerlord", "RTS Games", "PC", 2020, 0, true));
        rtsGamesReference.setValue(rtsGamesMap);
        turnBasedStrategyGamesMap.put("Civilization V", new VideoGame("Civilization V", "Turn-based Strategy Games", "PC", 2010, 12, true));
        turnBasedStrategyGamesReference.setValue(turnBasedStrategyGamesMap);
        mmorpgGamesMap.put("World of Warcraft: Classic", new VideoGame("World of Warcraft: Classic", "MMORPG Games", "PC", 2019, 125000, true));
        mmorpgGamesMap.put("World of Warcraft: Battle for Azeroth", new VideoGame("World of Warcraft: Battle for Azeroth", "MMORPG Games", "PC", 2018, 125000, true));
        mmorpgGamesReference.setValue(mmorpgGamesMap);
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

    public Map<String, VideoGame> getFpsGamesMap() {
        return fpsGamesMap;
    }

    public Map<String, VideoGame> getRtsGamesMap() {
        return rtsGamesMap;
    }

    public Map<String, VideoGame> getTurnBasedStrategyGamesMap() {
        return turnBasedStrategyGamesMap;
    }

    public Map<String, VideoGame> getDungeonCrawlerGamesMap() {
        return dungeonCrawlerGamesMap;
    }

    public Map<String, VideoGame> getMmorpgGamesMap() {
        return mmorpgGamesMap;
    }
}
