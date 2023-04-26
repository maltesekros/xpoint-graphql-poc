package tech.xpoint.pocs.graphqlpoc.moviedetails;

import java.util.Arrays;
import java.util.List;

public class Actor {

    private String id;
    private String firstName;
    private String lastName;
    private String lastMovie;

    public Actor(String id, String firstName, String lastName, String lastMovie) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastMovie = lastMovie;
    }

    private static List<Actor> actors = Arrays.asList(
            new Actor("actor-1", "Pedro", "Pascal", "movie-2"),
            new Actor("actor-2", "Emilia", "Clarke", "movie-1"),
            new Actor("actor-3", "Kit", "Haringtom", "movie-1"),
            new Actor("actor-4", "Wagner", "Moura", "movie-2"),
            new Actor("actor-5", "Alberto", "Ammann", "movie-2"),
            new Actor("actor-6", "Ursula", "Corbero", "movie-3"),
            new Actor("actor-7", "Alvaro", "Morte", "movie-3")
    );

    public static Actor getById(String id) {
        return actors.stream().filter(actor -> actor.getId().equals(id)).findFirst().orElse(null);
    }

    public String getId() {
        return id;
    }

    public String getLastMovie() {
        return lastMovie;
    }
}
