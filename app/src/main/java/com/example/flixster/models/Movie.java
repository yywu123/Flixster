package com.example.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.LinkedList;
import java.util.List;

@Parcel
public class Movie {
    String posterPath ;
    String title ;
    String overview ;
    String backdropPath ;
    double rating ;
    int movieId ;


    //emptu constructor needed by the Parceler library
    public Movie() {}


    public Movie (JSONObject jsonObject ) throws JSONException {
        posterPath = jsonObject.getString("poster_path");
        backdropPath = jsonObject.getString("backdrop_path");
        title = jsonObject.getString("title") ;
        overview = jsonObject.getString("overview") ;
        rating = jsonObject.getDouble("vote_average");
        movieId = jsonObject.getInt("id");
    }

    public static List<Movie> fromJsonArray (JSONArray movieJsonArray) throws JSONException {
        List<Movie> movies = new LinkedList<>() ;
        for (int i = 0 ; i < movieJsonArray.length(); i++){
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }
        return  movies  ;
    }

    public String getTitle() {
        return title;
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getOverview() {
        return overview;
    }

    public String getBackdropPath(){
        return String.format("https://image.tmdb.org/t/p/w342/%s", backdropPath);
    }

    public double getRating() {
        return rating;
    }

    public int getMovieId() {
        return movieId;
    }
}
