package search;

import movie.MovieDetails;
import movie.MovieTheater;

import java.util.List;

public abstract class SearchProcessor {
    protected final SearchProcessor nextSearchProcessor;

    protected SearchProcessor(SearchProcessor nextSearchProcessor) {
        this.nextSearchProcessor = nextSearchProcessor;
    }

    public abstract List<MovieDetails> searchMovie(Request request, List<MovieTheater> movieTheaters);
    protected abstract List<MovieDetails> getMovies(Request request, List<MovieTheater> movieTheaters);
}
