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
    private DatabaseReference videoGameReference;
    private Map<String, VideoGame> videoGameMap = new HashMap<>();
    private MyObservable myObservable;

    public FirebaseHandler(MyObservable myObservable) {
        this.myObservable = myObservable;
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        videoGameReference = firebaseDatabase.getReference("Video Games");
        saveToDatabase();
        getDatabase();
    }

    private void getDatabase() {
        videoGameReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshotChild : dataSnapshot.getChildren()) {
                    VideoGame videoGame = dataSnapshotChild.getValue(VideoGame.class);
                    videoGameMap.put(dataSnapshotChild.getKey(), videoGame);
                }
                myObservable.notifyObservers(videoGameMap);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void saveToDatabase() {
        ArrayList<String> screens01 = new ArrayList<>();
        screens01.add("https://i.imgur.com/9l7kRbw.jpg");
        videoGameMap.put("Wizard of Legend", new VideoGame("Wizard of Legend", "Dungeon Crawler", "PC", 2018, 2, true, screens01, 47));

        ArrayList<String> screens02 = new ArrayList<>();
        screens02.add("https://i.imgur.com/Ngn7XiR.jpg");
        videoGameMap.put("Super Smash Bros Ultimate", new VideoGame("Super Smash Bros Ultimate", "Fighting", "Nintendo Switch", 2018, 8, true, screens02));

        ArrayList<String> screens03 = new ArrayList<>();
        screens03.add("https://i.imgur.com/0iD1khb.jpg");
        videoGameMap.put("Super Smash Bros 4", new VideoGame("Super Smash Bros 4", "Fighting", "Nintendo Wii U", 2014, 8, true, screens03));

        ArrayList<String> screens04 = new ArrayList<>();
        screens04.add("https://i.imgur.com/zP5sLX2.jpg");
        videoGameMap.put("Tekken Tag Tournament 2", new VideoGame("Tekken Tag Tournament 2", "Fighting", "PlayStation 3", 2011, 2, true, screens04));

        ArrayList<String> screens05 = new ArrayList<>();
        screens05.add("https://i.imgur.com/vI7LpQC.jpg");
        videoGameMap.put("Brawlhalla", new VideoGame("Brawlhalla", "Fighting", "PC", 2014, 4, true, screens05));

        ArrayList<String> screens06 = new ArrayList<>();
        screens06.add("https://i.imgur.com/ARFs2bO.jpg");
        videoGameMap.put("Fortnite", new VideoGame("Fortnite", "First Person Shooter", "PC", 2017, 100, true, screens06));

        ArrayList<String> screens07 = new ArrayList<>();
        screens07.add("https://i.imgur.com/eu84Q0R.jpg");
        videoGameMap.put("Call of Duty: Modern Warfare 2", new VideoGame("Call of Duty: Modern Warfare 2", "First Person Shooter", "PC", 2009, 12, true, screens07));

        ArrayList<String> screens08 = new ArrayList<>();
        screens08.add("https://i.imgur.com/IJm7P9O.jpg");
        videoGameMap.put("Civilization V", new VideoGame("Civilization V", "Turn-based Strategy", "PC", 2010, 12, true, screens08));

        ArrayList<String> screens09 = new ArrayList<>();
        screens09.add("https://i.imgur.com/NhV9SpN.jpg");
        videoGameMap.put("Starcraft II", new VideoGame("Starcraft II", "Real Time Strategy", "PC", 2010, 8, true, screens09));

        ArrayList<String> screens10 = new ArrayList<>();
        screens10.add("https://i.imgur.com/6aDWyvC.jpg");
        videoGameMap.put("Age of Empires II: Definitive Edition", new VideoGame("Age of Empires II: Definitive Edition", "Real Time Strategy", "PC", 2019, 4, true, screens10));

        ArrayList<String> screens11 = new ArrayList<>();
        screens11.add("https://i.imgur.com/sDVSdEB.jpg");
        videoGameMap.put("Mount & Blade II: Bannerlord", new VideoGame("Mount & Blade II: Bannerlord", "Real Time Strategy", "PC", 2020, 0, true, screens11));

        ArrayList<String> screens12 = new ArrayList<>();
        screens12.add("https://i.imgur.com/q137NWA.jpg");
        videoGameMap.put("World of Warcraft: Classic", new VideoGame("World of Warcraft: Classic", "MMORPG", "PC", 2019, 125000, true, screens12));

        ArrayList<String> screens13 = new ArrayList<>();
        screens13.add("https://i.imgur.com/48f2i5R.jpg");
        videoGameMap.put("World of Warcraft: Battle for Azeroth", new VideoGame("World of Warcraft: Battle for Azeroth", "MMORPG", "PC", 2018, 125000, true, screens13));

        ArrayList<String> screens14 = new ArrayList<>();
        screens14.add("https://i.imgur.com/3WZb1AX.jpg");
        videoGameMap.put("Unreal Tournament", new VideoGame("Unreal Tournament", "First Person Shooter", "PC", 1999, 64, true, screens14));

        ArrayList<String> screens15 = new ArrayList<>();
        screens15.add("https://i.imgur.com/I5VhO1f.jpg");
        videoGameMap.put("Unreal Tournament 2004", new VideoGame("Unreal Tournament 2004", "First Person Shooter", "PC", 2004, 64, true, screens15));

        ArrayList<String> screens16 = new ArrayList<>();
        screens16.add("https://i.imgur.com/KMCOdji.jpg");
        videoGameMap.put("Overwatch", new VideoGame("Overwatch", "First Person Shooter", "PC", 2016, 10, true, screens16));

        ArrayList<String> screens17 = new ArrayList<>();
        screens17.add("https://i.imgur.com/7WxilCt.jpg");
        videoGameMap.put("Diablo II", new VideoGame("Diablo II", "Dungeon Crawler", "PC", 2000, 2, true, screens17));

        ArrayList<String> screens18 = new ArrayList<>();
        screens18.add("https://i.imgur.com/MExodpS.jpg");
        videoGameMap.put("Mario Kart 8", new VideoGame("Mario Kart 8", "Racing", "Wii U", 2013, 12, true, screens18));

        videoGameReference.setValue(videoGameMap);
    }

    public void printStuff(Map<String, VideoGame> retrievedVideoGames) {
        for (String key : retrievedVideoGames.keySet()) {
            VideoGame videoGame = retrievedVideoGames.get(key);
            System.out.println("Key: " + key + ", Name: " + videoGame.getName() + ", Genre: " + videoGame.getGenre());
        }
    }

    public Map<String, VideoGame> getVideoGameMap() {
        return videoGameMap;
    }
}
