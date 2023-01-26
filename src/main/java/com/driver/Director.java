package com.driver;
//String name, int numberOfMovies, double imdbRating,
//        no-args constructor, all-args constructor and getters-setters
public class Director {
    private String name;
    private int numberOfMovies;
    private double imbdRating;
    public Director() {

    }
    public Director(String name, int numberOfMovies, double imbdRating) {
        this.name = name;
        this.numberOfMovies = numberOfMovies;
        this.imbdRating = imbdRating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfMovies() {
        return numberOfMovies;
    }

    public void setNumberOfMovies(int numberOfMovies) {
        this.numberOfMovies = numberOfMovies;
    }

    public double getImbdRating() {
        return imbdRating;
    }

    public void setImbdRating(double imbdRating) {
        this.imbdRating = imbdRating;
    }
}
