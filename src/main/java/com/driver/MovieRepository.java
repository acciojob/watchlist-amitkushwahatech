package com.driver;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository {

    private HashMap<String,Movie> movieDb;
    private HashMap<String, Director> directorDb;
    private HashMap<String, List<String>> directorMovieDb;

    //Pair is : DirectorName, List of Movie Names


    //Initialization is very important :

    public MovieRepository(){
        this.movieDb = new HashMap<String, Movie>();
        this.directorDb = new HashMap<String, Director>();
        this.directorMovieDb = new HashMap<String, List<String>>();
    }

    public void saveMovie(Movie movie){
        movieDb.put(movie.getName(), movie);
    }

    public void saveDirector(Director director){
        directorDb.put(director.getName(), director);
    }

    public void saveMovieDirectorPair(String movie, String director){

        //1. Add the movie into Datbase ---> WRONG bcz I dont have te movie object

        if(movieDb.containsKey(movie)&&directorDb.containsKey(director)){

            List<String> currentMoviesByDirector = new ArrayList<>();

            if(directorMovieDb.containsKey(director))
                currentMoviesByDirector = directorMovieDb.get(director);

            currentMoviesByDirector.add(movie);

            directorMovieDb.put(director,currentMoviesByDirector);

        }

    }

    public Movie findMovie(String movie){
        return movieDb.get(movie);
    }

    public Director findDirector(String director){
        return directorDb.get(director);
    }

    public List<String> findMoviesFromDirector(String director){
        List<String> moviesList = new ArrayList<String>();
        if(directorMovieDb.containsKey(director)) moviesList = directorMovieDb.get(director);
        return moviesList;
    }

    public List<String> findAllMovies(){
        return new ArrayList<>(movieDb.keySet());
    }

    public void deleteDirector(String director){

        List<String> movies = new ArrayList<String>();
        if(directorMovieDb.containsKey(director)){
            //1. Find the movie names by director from the pair
            movies = directorMovieDb.get(director);

            //2. Deleting all the movies from movieDb by using movieName
            for(String movie: movies){
                if(movieDb.containsKey(movie)){
                    movieDb.remove(movie);
                }
            }

            //3. Deleteing the pair
            directorMovieDb.remove(director);
        }

        //4. Delete the director from directorDb.
        if(directorDb.containsKey(director)){
            directorDb.remove(director);
        }
    }

    public void deleteAllDirector(){

        HashSet<String> moviesSet = new HashSet<String>();

        //Deleting the director's map
        directorDb = new HashMap<>();

        //Finding out all the movies by all the directors combined
        for(String director: directorMovieDb.keySet()){

            //Iterating in the list of movies by a director.
            for(String movie: directorMovieDb.get(director)){
                moviesSet.add(movie);
            }
        }

        //Deleting the movie from the movieDb.
        for(String movie: moviesSet){
            if(movieDb.containsKey(movie)){
                movieDb.remove(movie);
            }
        }
        //clearing the pair.
        directorMovieDb = new HashMap<>();
    }
}