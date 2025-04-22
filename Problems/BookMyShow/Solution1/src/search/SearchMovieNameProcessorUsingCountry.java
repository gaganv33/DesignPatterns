package search;

import movie.MovieDetails;
import movie.MovieTheater;

import java.util.ArrayList;
import java.util.List;

public class SearchMovieNameProcessorUsingCountry extends SearchProcessor {
    protected SearchMovieNameProcessorUsingCountry(SearchProcessor searchProcessor) {
        super(searchProcessor);
    }

    @Override
    public List<MovieDetails> searchMovie(Request request, List<MovieTheater> movieTheaters) {
        if(request.isCityBlank() && request.isStateBlank() && request.isCountryNotBlank()) {
            return getMovies(request, movieTheaters);
        } else {
            if(this.nextSearchProcessor != null) return this.nextSearchProcessor.searchMovie(request, movieTheaters);
            return null;
        }
    }

    @Override
    protected List<MovieDetails> getMovies(Request request, List<MovieTheater> movieTheaters) {
        String name = request.getName();
        String country = request.getCountry();
        List<MovieDetails> movieDetails = new ArrayList<>();
        for(MovieTheater movieTheater : movieTheaters) {
            if(movieTheater.isMatchingLocationUsingCountry(country)) {
                movieDetails.addAll(movieTheater.getMovieUsingName(name));
            }
        }
        return movieDetails;
    }
}
