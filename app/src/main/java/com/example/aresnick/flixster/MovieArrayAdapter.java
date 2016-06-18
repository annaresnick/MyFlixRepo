package com.example.aresnick.flixster;

import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aresnick.flixster.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

public class MovieArrayAdapter extends ArrayAdapter<Movie> {

    public MovieArrayAdapter(Context context, List<Movie> movies) {
        super(context, android.R.layout.simple_list_item_1, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // get the data item for position
        Movie movie = getItem(position);

        // check the existing view being reused
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie, parent, false);
        }

        // find the image view
        ImageView ivImage = (ImageView) convertView.findViewById(R.id.ivMovieImage);

        // clear out image from convertView
        ivImage.setImageResource(0);

        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        TextView tvOverview = (TextView) convertView.findViewById(R.id.tvOverview);

        //restrict overview length
        String overview = movie.getOverview();
        String overviewCondensed;

        if(overview.length() >= 150) {
            overviewCondensed = overview.substring(0, 150) + "...";
        } else {
            overviewCondensed = overview;
        }
        // fix the orientation
        boolean isLandscape = ivImage.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
        if(isLandscape){
            //Configure ivImage to have backdrop image URL
            Picasso.with(getContext()).load(movie.getBackdropPath()).into(ivImage);
            //Picasso.with(getContext()).load(movie.getBackdropPath()).transform(new RoundedCornersTransformation(10,10)).into(ivImage);
        } else{
            //Configure ivImage to have poster image URL
            Picasso.with(getContext()).load(movie.getPosterPath()).into(ivImage);
            Picasso.with(getContext()).load(movie.getPosterPath()).transform(new RoundedCornersTransformation(10,10)).into(ivImage);
        }


        // populate data
        tvTitle.setText(movie.getOriginalTitle());
        tvOverview.setText(overviewCondensed);


        // return the view
        return convertView;
    }
}

/*
    public MoviesAdapter(Context context, ArrayList<Movie> movies) {
        super(context, R.layout.item_movie, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        // Get the data item for this position
        Movie movie = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_movie, parent, false);
        }

        // Lookup view for data population
        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        ImageView ivPoster = (ImageView) convertView.findViewById(R.id.ivMovieImage);


        // Populate the data into the template view using the data object
        tvTitle.setText(movie.title);

        Log.d("MoviesAdapter", "Position: " + position);

        //ivPoster.set

        String imageUri = "https://i.imgur.com/tGbaZCY.jpg";
        Picasso.with(getContext()).load(imageUri).into(ivPoster);

        // Return the completed view to render on screen
        return convertView;

    }
}
*/
