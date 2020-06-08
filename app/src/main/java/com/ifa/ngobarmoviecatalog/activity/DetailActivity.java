package com.ifa.ngobarmoviecatalog.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ifa.ngobarmoviecatalog.R;
import com.ifa.ngobarmoviecatalog.model.Result;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "string_extra";
    String title,overview,image;
    ImageView imgDetail;
    TextView tvTitle, tvDetail;
    Result result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvTitle = findViewById(R.id.tvJudulDeskripsi);
        tvDetail = findViewById(R.id.tvIsiDeskripsi);
        imgDetail = findViewById(R.id.imgMovieDeskripsi);

        result = getIntent().getParcelableExtra(EXTRA_MOVIE);

        title = result.getOriginalTitle();
        overview = result.getOverview();
        image = result.getPosterPath();

        tvTitle.setText(title);
        tvDetail.setText(overview);

        Glide.with(getApplicationContext())
                .load("https://image.tmdb.org/t/p/w185" + image)
                .into(imgDetail);

        // Membuat Title pada detail
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle(title);
        }

        // Tombol Arah panah balik
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}