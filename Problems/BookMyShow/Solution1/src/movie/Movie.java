package movie;

import data.MovieType;

import java.time.LocalTime;
import java.util.List;

public class Movie {
    private final String name;
    private final MovieType movieType;
    private final LocalTime duration;
    private final List<String> directors;
    private final List<String> actors;

    public Movie(String name, MovieType movieType, LocalTime duration, List<String> directors, List<String> actors) {
        this.name = name;
        this.movieType = movieType;
        this.duration = duration;
        this.directors = directors;
        this.actors = actors;
    }

    public String getName() {
        return name;
    }

    public MovieType getMovieType() {
        return movieType;
    }

    public LocalTime getDuration() {
        return duration;
    }

    public List<String> getDirectors() {
        return directors;
    }

    public List<String> getActors() {
        return actors;
    }
}
