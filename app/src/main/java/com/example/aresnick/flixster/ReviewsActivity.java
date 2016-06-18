package com.example.aresnick.flixster;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ReviewsActivity extends AppCompatActivity {

    TextView tvMovieTitle;
    TextView tvMovieOverview;
    ImageView ivMovieImage;
    TextView tvMovieRelease;
    RatingBar ratingBar;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews);
        String text = getIntent().getStringExtra("text");
        String text1 = getIntent().getStringExtra("text1");
        String text2 = getIntent().getStringExtra("text2");
        String text3 = getIntent().getStringExtra("text3");
        double int1= getIntent().getDoubleExtra("text4", 0);
        position = getIntent().getIntExtra("position", 0);
        tvMovieTitle = (TextView) findViewById(R.id.tvMovieTitle);
        tvMovieTitle.setText(text);
        tvMovieOverview = (TextView) findViewById(R.id.tvMovieOverview);
        tvMovieOverview.setText(text1);
        tvMovieOverview.setMovementMethod(new ScrollingMovementMethod());
        ivMovieImage = (ImageView) findViewById(R.id.ivMovieImage);
        Picasso.with(this).load(text2).into(ivMovieImage);
        tvMovieRelease = (TextView) findViewById(R.id.tvMovieRelease);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        //int rating = Integer.parseInt(text4.replaceAll("[\\D]", ""));
        tvMovieRelease.setText("Release Date: " + text3);
        float rating = (float) (int1/2.00);
        ratingBar.setRating(rating);
        //ivMovieImage.setImageResource(text2);

    }
}
