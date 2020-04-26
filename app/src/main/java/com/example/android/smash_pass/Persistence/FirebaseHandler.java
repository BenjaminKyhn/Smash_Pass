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
    private VideoGame videoGame;
    private DatabaseReference nameReference;
    private DatabaseReference genreReference;
    private DatabaseReference platformReference;
    private DatabaseReference yearReference;
    private DatabaseReference numberOfPlayersReference;
    private DatabaseReference onlinePlayReference;
    private DatabaseReference fightingGamesReference;

    public FirebaseHandler(VideoGame videoGame) {
        this.videoGame = videoGame;
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        nameReference = firebaseDatabase.getReference("Fighting Games").child("Super Smash Bros Ultimate").child("name");
        genreReference = firebaseDatabase.getReference("Fighting Games").child("Super Smash Bros Ultimate").child("genre");
        platformReference = firebaseDatabase.getReference("Fighting Games").child("Super Smash Bros Ultimate").child("platform");
        yearReference = firebaseDatabase.getReference("Fighting Games").child("Super Smash Bros Ultimate").child("year");
        numberOfPlayersReference = firebaseDatabase.getReference("Fighting Games").child("Super Smash Bros Ultimate").child("numberOfPlayers");
        onlinePlayReference = firebaseDatabase.getReference("Fighting Games").child("Super Smash Bros Ultimate").child("onlinePlay");
        fightingGamesReference = firebaseDatabase.getReference("Fighting Games");
        addEventListener();
    }

    private void addEventListener() {
        saveStuff();

        fightingGamesReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Map<String, VideoGame> videoGameMap = new HashMap<>();

                for (DataSnapshot dataSnapshotChild : dataSnapshot.getChildren()) {
                    VideoGame videoGame = dataSnapshotChild.getValue(VideoGame.class);

                    videoGameMap.put(dataSnapshotChild.getKey(), videoGame);
                }


                printStuff(videoGameMap);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        nameReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                videoGame.setName((String) dataSnapshot.getValue());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        genreReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                videoGame.setGenre((String) dataSnapshot.getValue());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        platformReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                videoGame.setPlatform((String) dataSnapshot.getValue());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        yearReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                videoGame.setYear((long) dataSnapshot.getValue());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        numberOfPlayersReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                videoGame.setNumberOfPlayers((long) dataSnapshot.getValue());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        onlinePlayReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                videoGame.setOnlinePlay((boolean) dataSnapshot.getValue());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void insert(String text) {
        nameReference.setValue(text);
    }

    public void printStuff(Map<String, VideoGame> retrievedVideoGames) {
        for (String key : retrievedVideoGames.keySet()) {
            VideoGame videoGame = retrievedVideoGames.get(key);
            System.out.println("Name: " + videoGame.getName());
        }
    }

    public void saveStuff() {
        Map<String, VideoGame> videoGameMap = new HashMap<>();
        videoGameMap.put("Super Smash Bros Ultimate", new VideoGame("Super Smash Bros Ultimate", "Fighting Games", "Nintendo Switch", 2018, 8, true));
        videoGameMap.put("Tekken Tag Tournament 2", new VideoGame("Tekken Tag Tournament 2", "Fighting Games", "PlayStation 3", 2011, 2, true));
        fightingGamesReference.setValue(videoGameMap);
    }

}
