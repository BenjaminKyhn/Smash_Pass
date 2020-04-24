package com.example.android.smash_pass.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.android.smash_pass.R;
import com.squareup.picasso.Picasso;

public class VideoGameActivity extends AppCompatActivity {
    ImageView mainImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_game);

        mainImage = findViewById(R.id.mainImage);
        String pictureUrl = "https://www.pngitem.com/pimgs/m/157-1579710_picture-chuck-norris-hd-png-download.png";
        Picasso.get().load(pictureUrl).into(mainImage);
    }
}
