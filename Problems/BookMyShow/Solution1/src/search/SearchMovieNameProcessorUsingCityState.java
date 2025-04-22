package search;

import movie.MovieDetails;
import movie.MovieTheater;

import java.util.ArrayList;
import java.util.List;

public class SearchMovieNameProcessorUsingCityState extends SearchProcessor {
    protected SearchMovieNameProcessorUsingCityState(SearchProcessor searchProcessor) {
        super(searchProcessor);
    }

    @Override
    public List<MovieDetails> searchMovie(Request request, List<MovieTheater> movieTheaters) {
        if(request.isCityNotBlank() && request.isStateNotBlank() && request.isCountryBlank()) {
            return getMovies(request, movieTheaters);
        } else {
            if(this.nextSearchProcessor != null) return this.nextSearchProcessor.searchMovie(request, movieTheaters);
            return null;
        }
    }

    @Override
    protected List<MovieDetails> getMovies(Request request, List<MovieTheater> movieTheaters) {
        String name = request.getName();
        String city = request.getCity();
        String state = request.getState();
        List<MovieDetails> movieDetails = new ArrayList<>();
        for(MovieTheater movieTheater : movieTheaters) {
            if(movieTheater.isMatchingLocationUsingCity(city) && movieTheater.isMatchingLocationUsingState(state)) {
                movieDetails.addAll(movieTheater.getMovieUsingName(name));
            }
        }
        return movieDetails;
    }
}
