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
    private DatabaseReference databaseReference;

    public FirebaseHandler(VideoGame videoGame) {
        this.videoGame = videoGame;
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Fighting Games").child("Super Smash Bros Ultimate").child("name");
        addEventListener();
    }

    private void addEventListener() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                videoGame.setText((String) dataSnapshot.getValue());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void insert(String text){
        databaseReference.setValue(text);
    }
}
