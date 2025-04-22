package search;

import movie.MovieDetails;
import movie.MovieTheater;

import java.util.ArrayList;
import java.util.List;

public class SearchMovieNameProcessorUsingStateCountry extends SearchProcessor {
    protected SearchMovieNameProcessorUsingStateCountry(SearchProcessor searchProcessor) {
        super(searchProcessor);
    }

    @Override
    public List<MovieDetails> searchMovie(Request request, List<MovieTheater> movieTheaters) {
        if(request.isCityBlank() && request.isStateNotBlank() && request.isCountryNotBlank()) {
            return getMovies(request, movieTheaters);
        } else {
            if(this.nextSearchProcessor != null) return this.nextSearchProcessor.searchMovie(request, movieTheaters);
            return null;
        }
    }

    @Override
    protected List<MovieDetails> getMovies(Request request, List<MovieTheater> movieTheaters) {
        String name = request.getName();
        String state = request.getState();
        String country = request.getCountry();
        List<MovieDetails> movieDetails = new ArrayList<>();
        for(MovieTheater movieTheater : movieTheaters) {
            if(movieTheater.isMatchingLocationUsingState(state) && movieTheater.isMatchingLocationUsingCountry(country)) {
                movieDetails.addAll(movieTheater.getMovieUsingName(name));
            }
        }
        return movieDetails;
    }
}
