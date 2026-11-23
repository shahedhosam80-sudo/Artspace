package com.example.artspaces;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ArtworkDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artwork_details);

        TextView titleTv = findViewById(R.id.detailsTitle);
        TextView artistTv = findViewById(R.id.detailsArtist);
        TextView yearTv = findViewById(R.id.detailsYear);
        Button webBtn = findViewById(R.id.visitWebBtn);
        Button backBtn = findViewById(R.id.backBtn);

        Intent intent = getIntent();
        String title = intent.getStringExtra("artTitle");
        String artist = intent.getStringExtra("artArtist");
        String year = intent.getStringExtra("artYear");

        titleTv.setText(title);
        artistTv.setText(artist);
        yearTv.setText(year);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        webBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
                startActivity(browserIntent);
            }
        });
    }
}