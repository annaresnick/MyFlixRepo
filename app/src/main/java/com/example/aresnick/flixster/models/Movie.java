package com.example.aresnick.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by aresnick on 6/15/2016.
 */
public class Movie {

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getOverview() {
        return overview;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getReleaseDate(){
        return releaseDate;
    }

    public Double getVoteAverage(){
        return voteAverage;
    }

    public String getBackdropPath(){
        return backDropPath;
    }

    String posterPath;
    String backDropPath;
    String originalTitle;
    String overview;
    String releaseDate;
    Double voteAverage;

    public Movie(JSONObject jsonObject) throws JSONException{
        this.posterPath = jsonObject.getString("poster_path");
        this.originalTitle = jsonObject.getString("original_title");
        this.overview = jsonObject.getString("overview");
        this.releaseDate = jsonObject.getString("release_date");
        this.voteAverage = jsonObject.getDouble("vote_average");
        this.backDropPath = jsonObject.getString("backdrop_path");
    }

    public static ArrayList<Movie> fromJSONArray(JSONArray array){
        ArrayList<Movie> results = new ArrayList<>();

        for (int x = 0; x < array.length(); x++) {
            try {
                results.add(new Movie(array.getJSONObject(x)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return results;
    }
}
//package com.example.aresnick.flixster;
//
///**
// * Created by aresnick on 6/15/2016.
// */
//public class Movie {
//    public String title;
//    public String posterUrl;
//    public int rating;
//
//    public Movie(String title, String posterUrl, int rating) {
//        this.title = title;
//        this.posterUrl = posterUrl;
//        this.rating = rating;
//    }
//
//    public static ArrayList<Movie> getFakeMovies(){
//        ArrayList<Movie> movies = new ArrayList<>();
//
//        for(int i = 0; i < 60; i++) {
//            movies.add(new Movie("The Social Network", "", 75));
//            movies.add(new Movie("The Internship", "", 50));
//            movies.add(new Movie("The Lion King", "", 100));
//        }
//        return movies;
//    }
//
//    @Override
//    public String toString() {
//        return title + " - " + rating;
//    }
//}
