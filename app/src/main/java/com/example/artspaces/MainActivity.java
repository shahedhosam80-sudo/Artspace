package com.example.artspaces;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ImageView artworkImage;
    TextView titleText, artistText, counterText;
    Button nextBtn, prevBtn;
    int index = 0;

    int[] images = {R.drawable.art1, R.drawable.art2, R.drawable.art3, R.drawable.art4, R.drawable.art5, R.drawable.art6};
    String[] titles = {"The Starry Night", "Ophelia", "Wheatfield with Crows", "Liberty Leading the People", "The Scream", "Girl with a Pearl Earring"};
    String[] artists = {"Vincent van Gogh", "John Everett Millais", "Vincent van Gogh", "Eugène Delacroix", "Edvard Munch", "Johannes Vermeer"};
    String[] years = {"1889", "1852", "1890", "1830", "1893", "1665"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        artworkImage = findViewById(R.id.ivArtwork);
        titleText = findViewById(R.id.tvTitle);
        artistText = findViewById(R.id.tvArtistYear);
        counterText = findViewById(R.id.tvCounter);
        nextBtn = findViewById(R.id.btnNext);
        prevBtn = findViewById(R.id.btnPrevious);

        if (savedInstanceState != null) {
            index = savedInstanceState.getInt("my_index", 0);
        }

        showArtwork();

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index < images.length - 1) {
                    index++;
                    showArtwork();
                }
            }
        });

        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index > 0) {
                    index--;
                    showArtwork();
                }
            }
        });

        artworkImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ArtworkDetailsActivity.class);
                intent.putExtra("artTitle", titles[index]);
                intent.putExtra("artArtist", artists[index]);
                intent.putExtra("artYear", years[index]);
                startActivity(intent);
            }
        });
    }

    private void showArtwork() {
        artworkImage.setImageResource(images[index]);
        titleText.setText(titles[index]);
        artistText.setText(artists[index] + ", " + years[index]);
        counterText.setText((index + 1) + " / " + images.length);

        prevBtn.setEnabled(index > 0);
        nextBtn.setEnabled(index < images.length - 1);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("my_index", index);
    }
}