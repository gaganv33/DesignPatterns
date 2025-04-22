package proxy;

import booking.Booking;
import movie.MovieDetails;
import movie.MovieTheaterManager;
import search.Request;
import seat.SeatInformation;
import user.User;

import java.util.List;

public class UserProxy {
    private final MovieTheaterManager movieTheaterManager;

    public UserProxy() {
        movieTheaterManager = MovieTheaterManager.getInstance();
    }

    public List<SeatInformation> getAllSeatInformation(String movieTheaterId, String movieScreenId) {
        return movieTheaterManager.getAllSeatInformation(movieTheaterId, movieScreenId);
    }

    public Booking bookSeats(String movieTheaterId, String movieScreenId, List<String> seatIds, User user) {
        return movieTheaterManager.bookSeats(movieTheaterId, movieScreenId, seatIds, user);
    }

    public void cancelBooking(Booking booking) {
        movieTheaterManager.cancelBooking(booking);
    }

    public List<MovieDetails> searchMovie(Request request) {
        return movieTheaterManager.searchMovie(request);
    }
}
