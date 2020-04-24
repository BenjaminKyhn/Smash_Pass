package com.example.android.smash_pass.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.android.smash_pass.Model.MyObserver;
import com.example.android.smash_pass.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private Button btnOne;
    private ViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOne.findViewById(R.id.btnOne);

        setupViewModel();
    }

    private void setupViewModel() {
        viewModel = new ViewModel();
        viewModel.observeVideoGame(new MyObserver() {
            @Override
            public void update(Object o) {
                btnOne.setText((String) o);
            }
        });
    }
}
