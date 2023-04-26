package tech.xpoint.pocs.graphqlpoc.moviedetails;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MovieController {

    @QueryMapping
    public Movie movieById(@Argument String id) {
        return Movie.getById(id);
    }

    @QueryMapping
    public List<Movie> movies() {
        return Movie.getAllMovies();
    }

    @SchemaMapping(typeName="Actor", field="lastMovie")
    public Movie lastMovie(Actor actor) {
        return Movie.getById(actor.getLastMovie());
    }

    @SchemaMapping
    public List<Actor> actors(Movie movie) {
        List<Actor> actors = new ArrayList<>();
        for (String actorId : movie.getActors()) {
            actors.add(Actor.getById(actorId));
        }
        return actors;
    }
}
