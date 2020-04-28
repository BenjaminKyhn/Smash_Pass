package com.example.android.smash_pass.Persistence;

import androidx.annotation.NonNull;

import com.example.android.smash_pass.Model.MyObservable;
import com.example.android.smash_pass.Model.VideoGame;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
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
    private MyObservable myObservable;

    public FirebaseHandler(MyObservable myObservable) {
        this.myObservable = myObservable;
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
                myObservable.notifyObservers(fightingGamesMap);
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
        ArrayList<String> screens01 = new ArrayList<>();
        screens01.add("https://i.imgur.com/9l7kRbw.jpg");
        dungeonCrawlerGamesMap.put("Wizard of Legend", new VideoGame("Wizard of Legend", "Dungeon Crawler Games", "PC", 2018, 2, true, screens01));
        ArrayList<String> screens17 = new ArrayList<>();
        screens17.add("https://i.imgur.com/7WxilCt.jpg");
        dungeonCrawlerGamesMap.put("Diablo II", new VideoGame("Diablo II", "Dungeon Crawler Games", "PC", 2000, 2, true, screens17));
        dungeonCrawlerGamesReference.setValue(dungeonCrawlerGamesMap);
        ArrayList<String> screens02 = new ArrayList<>();
        screens02.add("https://i.imgur.com/Ngn7XiR.jpg");
        fightingGamesMap.put("Super Smash Bros Ultimate", new VideoGame("Super Smash Bros Ultimate", "Fighting Games", "Nintendo Switch", 2018, 8, true, screens02));
        ArrayList<String> screens03 = new ArrayList<>();
        screens03.add("https://i.imgur.com/0iD1khb.jpg");
        fightingGamesMap.put("Super Smash Bros 4", new VideoGame("Super Smash Bros 4", "Fighting Games", "Nintendo Wii U", 2014, 8, true, screens03));
        ArrayList<String> screens04 = new ArrayList<>();
        screens04.add("https://i.imgur.com/zP5sLX2.jpg");
        fightingGamesMap.put("Tekken Tag Tournament 2", new VideoGame("Tekken Tag Tournament 2", "Fighting Games", "PlayStation 3", 2011, 2, true, screens04));
        ArrayList<String> screens05 = new ArrayList<>();
        screens05.add("https://i.imgur.com/vI7LpQC.jpg");
        fightingGamesMap.put("Brawlhalla", new VideoGame("Brawlhalla", "Fighting Games", "PC", 2014, 4, true, screens05));
        fightingGamesReference.setValue(fightingGamesMap);
        ArrayList<String> screens06 = new ArrayList<>();
        screens06.add("https://i.imgur.com/ARFs2bO.jpg");
        fpsGamesMap.put("Fortnite", new VideoGame("Fortnite", "FPS Games", "PC", 2017, 100, true, screens06));
        ArrayList<String> screens07 = new ArrayList<>();
        screens07.add("https://i.imgur.com/eu84Q0R.jpg");
        fpsGamesMap.put("Call of Duty: Modern Warfare 2", new VideoGame("Call of Duty: Modern Warfare 2", "FPS Games", "PC", 2009, 12, true, screens07));
        ArrayList<String> screens14 = new ArrayList<>();
        screens14.add("https://i.imgur.com/3WZb1AX.jpg");
        fpsGamesMap.put("Unreal Tournament", new VideoGame("Unreal Tournament", "FPS Games", "PC", 1999, 64, true, screens14));
        ArrayList<String> screens15 = new ArrayList<>();
        screens15.add("https://i.imgur.com/I5VhO1f.jpg");
        fpsGamesMap.put("Unreal Tournament 2004", new VideoGame("Unreal Tournament 2004", "FPS Games", "PC", 2004, 64, true, screens15));
        ArrayList<String> screens16 = new ArrayList<>();
        screens16.add("https://i.imgur.com/KMCOdji.jpg");
        fpsGamesMap.put("Overwatch", new VideoGame("Overwatch", "FPS Games", "PC", 2016, 10, true, screens16));
        fpsGamesReference.setValue(fpsGamesMap);
        ArrayList<String> screens09 = new ArrayList<>();
        screens09.add("https://i.imgur.com/NhV9SpN.jpg");
        rtsGamesMap.put("Starcraft II", new VideoGame("Starcraft II", "RTS Games", "PC", 2010, 8, true, screens09));
        ArrayList<String> screens10 = new ArrayList<>();
        screens10.add("https://i.imgur.com/6aDWyvC.jpg");
        rtsGamesMap.put("Age of Empires II: Definitive Edition", new VideoGame("Age of Empires II: Definitive Edition", "RTS Games", "PC", 2019, 4, true, screens10));
        ArrayList<String> screens11 = new ArrayList<>();
        screens11.add("https://i.imgur.com/sDVSdEB.jpg");
        rtsGamesMap.put("Mount & Blade II: Bannerlord", new VideoGame("Mount & Blade II: Bannerlord", "RTS Games", "PC", 2020, 0, true, screens11));
        rtsGamesReference.setValue(rtsGamesMap);
        ArrayList<String> screens08 = new ArrayList<>();
        screens08.add("https://i.imgur.com/IJm7P9O.jpg");
        turnBasedStrategyGamesMap.put("Civilization V", new VideoGame("Civilization V", "Turn-based Strategy Games", "PC", 2010, 12, true, screens08));
        turnBasedStrategyGamesReference.setValue(turnBasedStrategyGamesMap);
        ArrayList<String> screens12 = new ArrayList<>();
        screens12.add("https://i.imgur.com/q137NWA.jpg");
        mmorpgGamesMap.put("World of Warcraft: Classic", new VideoGame("World of Warcraft: Classic", "MMORPG Games", "PC", 2019, 125000, true, screens12));
        ArrayList<String> screens13 = new ArrayList<>();
        screens13.add("https://i.imgur.com/48f2i5R.jpg");
        mmorpgGamesMap.put("World of Warcraft: Battle for Azeroth", new VideoGame("World of Warcraft: Battle for Azeroth", "MMORPG Games", "PC", 2018, 125000, true, screens13));
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
