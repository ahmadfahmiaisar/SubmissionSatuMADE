package com.example.user.bismillahsub1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailMovie extends AppCompatActivity {
    private ImageView ivBackdrop;
    private TextView tvTitle, tvOverview, tvReleaseDate, tvRating, tvVote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        ivBackdrop = findViewById(R.id.detail_image_poster);
        tvTitle = findViewById(R.id.detail_tv_title);
        tvReleaseDate = findViewById(R.id.detail_tv_releaseDate);
        tvOverview = findViewById(R.id.detail_tv_overview);
        tvRating = findViewById(R.id.tv_ratingMovie);
        tvVote = findViewById(R.id.tv_voting);


        Intent intent = getIntent();
        String backdrop = intent.getStringExtra(Helper.BACKDROP);
        String title = intent.getStringExtra(Helper.TITTLE);
        String overview = intent.getStringExtra(Helper.OVERVIEW);
        String release = intent.getStringExtra(Helper.RELEASE_DATE);
        String rating = intent.getStringExtra(Helper.POPULAR_MOVIE);
        String vote = intent.getStringExtra(Helper.RATING_MOVIE);

        getSupportActionBar().setTitle(title);

        tvTitle.setText(title);
        tvOverview.setText(overview);
        tvReleaseDate.setText(release);
        tvRating.setText(rating);
        tvVote.setText(vote);

        Glide.with(this).load(backdrop).into(ivBackdrop);

    }
}