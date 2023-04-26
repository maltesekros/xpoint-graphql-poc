package tech.xpoint.pocs.graphqlpoc.moviedetails;

import java.util.Arrays;
import java.util.List;

public class Movie {

    private String id;
    private String movieName;
    private List<String> actors;

    private Integer noOfSeasons;

    public Movie(String id, String movieName, List<String> actors, Integer noOfSeasons) {
        this.id = id;
        this.movieName = movieName;
        this.actors = actors;
        this.noOfSeasons = noOfSeasons;
    }

    private static List<Movie> movies = createMovies();

    private static List<Movie> createMovies() {
        Movie gameOfThrones = new Movie("movie-1", "Game of Thrones", Arrays.asList(
                "actor-1", "actor-2", "actor-3"), 8);
        Movie narcos = new Movie("movie-2", "Narcos", Arrays.asList(
                "actor-1", "actor-4", "actor-5"), 3);
        Movie casaDelPapel = new Movie("movie-3", "Casa Del Papel", Arrays.asList(
                "actor-6", "actor-7"), 5);
        return Arrays.asList(gameOfThrones, narcos, casaDelPapel);
    }

    public static Movie getById(String id) {
        return movies.stream().filter(movie -> movie.getId().equals(id)).findFirst().orElse(null);
    }

    public static List<Movie> getAllMovies() {
        return movies;
    }

    public String getId() {
        return id;
    }

    public List<String> getActors() {
        return actors;
    }
}
