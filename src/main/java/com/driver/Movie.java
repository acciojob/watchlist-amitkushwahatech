package com.driver;
//String name, int durationInMinutes, double imdbRating,
//        no-args constructor, all-args constructor and getters-setters
public class Movie {
    private String movieName;
    private int durationInMinutes;
    private double imdbRating;
    public Movie() {

    }
    public Movie(String movieName, int durationInMinutes, double imdbRating) {
        this.movieName = movieName;
        this.durationInMinutes = durationInMinutes;
        this.imdbRating = imdbRating;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }
}
