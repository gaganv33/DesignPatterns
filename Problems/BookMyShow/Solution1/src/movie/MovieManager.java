package movie;

import java.util.concurrent.ConcurrentHashMap;

public class MovieManager {
    private static volatile MovieManager instance;
    private final ConcurrentHashMap<String, Movie> movies;
    private MovieManager() {
        movies = new ConcurrentHashMap<>();
    }

    public static MovieManager getInstance() {
        if(instance == null) {
            synchronized (MovieManager.class) {
                if(instance == null) {
                    instance = new MovieManager();
                }
            }
        }
        return instance;
    }

    public ConcurrentHashMap<String, Movie> getMovies() {
        return movies;
    }

    public void addMovie(Movie movie) {
        movies.put(movie.getName(), movie);
    }

    public void removeMovie(String name) {
        movies.remove(name);
    }

    public Movie getMovieUsingName(String name) {
        if(movies.containsKey(name)) return movies.get(name);
        return null;
    }
}
