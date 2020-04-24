package com.example.android.smash_pass.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.smash_pass.Model.MyObserver;
import com.example.android.smash_pass.R;
import com.squareup.picasso.Picasso;

public class VideoGameActivity extends AppCompatActivity {
    TextView titleText;
    ImageView mainImage;
    ViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_game);

        titleText = findViewById(R.id.titleText);

        mainImage = findViewById(R.id.mainImage);
        String pictureUrl = "https://www.pngitem.com/pimgs/m/157-1579710_picture-chuck-norris-hd-png-download.png";
        Picasso.get().load(pictureUrl).into(mainImage);

        setupViewModel();
    }

    private void setupViewModel() {
        viewModel = new ViewModel();
        viewModel.observeVideoGame(new MyObserver() {
            @Override
            public void update(Object arg) {
                titleText.setText((String) arg);
            }
        });
    }
}
