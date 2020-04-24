package com.example.android.smash_pass.Persistence;

import androidx.annotation.NonNull;

import com.example.android.smash_pass.Model.VideoGame;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FirebaseHandler {
    private VideoGame videoGame;
    private DatabaseReference nameReference;
    private DatabaseReference genreReference;

    public FirebaseHandler(VideoGame videoGame) {
        this.videoGame = videoGame;
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        nameReference = firebaseDatabase.getReference("Fighting Games").child("Super Smash Bros Ultimate").child("name");
        genreReference = firebaseDatabase.getReference("Fighting Games").child("Super Smash Bros Ultimate").child("genre");
        addEventListener();
    }

    private void addEventListener() {
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
    }

    public void insert(String text){
        nameReference.setValue(text);
    }
}
