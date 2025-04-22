package search;

public class SearchProcessorFactory {
    public static final SearchProcessor searchProcessor;

    static {
        searchProcessor = new SearchMovieNameProcessorUsingCityStateCountry(
                new SearchMovieNameProcessorUsingCityState(new SearchMovieNameProcessorUsingStateCountry(
                        new SearchMovieNameProcessorUsingCityCountry(new SearchMovieNameProcessorUsingCity(
                                new SearchMovieNameProcessorUsingState(new SearchMovieNameProcessorUsingCountry(
                                        new SearchMovieNameProcessor(null)
                                ))
                        ))
                ))
        );
    }
}
