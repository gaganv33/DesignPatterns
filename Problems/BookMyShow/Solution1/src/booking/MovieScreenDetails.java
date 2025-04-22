package booking;

import data.MovieScreenType;
import seat.SeatDetails;

import java.util.List;

public class MovieScreenDetails {
    private final String movieScreenId;
    private final MovieScreenType movieScreenType;
    private final List<SeatDetails> seatDetails;

    public MovieScreenDetails(String movieScreenId, MovieScreenType movieScreenType, List<SeatDetails> seatDetails) {
        this.movieScreenId = movieScreenId;
        this.movieScreenType = movieScreenType;
        this.seatDetails = seatDetails;
    }

    public String getMovieScreenId() {
        return movieScreenId;
    }

    public MovieScreenType getMovieScreenType() {
        return movieScreenType;
    }

    public List<SeatDetails> getSeatDetails() {
        return seatDetails;
    }
}
