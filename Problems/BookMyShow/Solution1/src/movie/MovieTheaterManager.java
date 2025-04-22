package movie;

import booking.Booking;
import booking.MovieScreenDetails;
import search.Request;
import search.SearchProcessor;
import search.SearchProcessorFactory;
import seat.Seat;
import seat.SeatInformation;
import user.User;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class MovieTheaterManager {
    private static volatile MovieTheaterManager instance;
    private final ConcurrentHashMap<String, MovieTheater> movieTheaters;
    private final SearchProcessor searchProcessor;

    private MovieTheaterManager() {
        this.movieTheaters = new ConcurrentHashMap<>();
        this.searchProcessor = SearchProcessorFactory.searchProcessor;
    }

    public static MovieTheaterManager getInstance() {
        if(instance == null) {
            synchronized (MovieTheaterManager.class) {
                if(instance == null) {
                    instance = new MovieTheaterManager();
                }
            }
        }
        return instance;
    }

    public ConcurrentHashMap<String, MovieTheater> getMovieTheaters() {
        return movieTheaters;
    }

    public void addMovieTheater(MovieTheater movieTheater) {
        movieTheaters.put(movieTheater.getId(), movieTheater);
    }

    public void removeMovieTheater(String movieTheaterId) {
        movieTheaters.remove(movieTheaterId);
    }

    public void addMovieScreenInMovieTheater(String movieTheaterId, MovieScreen movieScreen) {
        MovieTheater movieTheater = getMovieTheaterUsingMovieTheaterId(movieTheaterId);
        if(movieTheater != null) movieTheater.addMovieScreen(movieScreen);
    }

    public void removeMovieScreenInMovieTheater(String movieTheaterId, String movieScreenId) {
        MovieTheater movieTheater = getMovieTheaterUsingMovieTheaterId(movieTheaterId);
        if(movieTheater != null) movieTheater.removeMovieScreen(movieScreenId);
    }

    public void addSeatInMovieScreenUsingMovieTheaterId(String movieTheaterId, String movieScreenId, Seat seat) {
        MovieTheater movieTheater = getMovieTheaterUsingMovieTheaterId(movieTheaterId);
        if(movieTheater != null) movieTheater.addSeatInMovieScreen(movieScreenId, seat);
    }

    public void removeSeatInMovieScreenUsingMovieTheaterId(String movieTheaterId, String movieScreenId, String seatId) {
        MovieTheater movieTheater = getMovieTheaterUsingMovieTheaterId(movieTheaterId);
        if(movieTheater != null) movieTheater.removeSeatInMovieScreen(movieScreenId, seatId);
    }

    public void setMovieInMovieScreen(String movieTheaterId, String movieScreenId, Movie movie, LocalDate startDate, LocalTime startTime) {
        MovieTheater movieTheater = getMovieTheaterUsingMovieTheaterId(movieTheaterId);
        if(movieTheater != null) movieTheater.setMovieInMovieScreen(movieScreenId, movie, startDate, startTime);
    }

    public void clearMovieInMovieScreen(String movieTheaterId, String movieScreenId) {
        MovieTheater movieTheater = getMovieTheaterUsingMovieTheaterId(movieTheaterId);
        if(movieTheater != null) movieTheater.removeMovieInMovieScreen(movieScreenId);
    }

    public Booking bookSeats(String movieTheaterId, String movieScreenId, List<String> seatIds, User user) {
        MovieTheater movieTheater = getMovieTheaterUsingMovieTheaterId(movieTheaterId);
        if(movieTheater != null) {
            MovieScreenDetails movieScreenDetails = movieTheater.bookSeatsForMovieScreen(movieScreenId, seatIds, user);
            if(movieScreenDetails == null) return null;
            return new Booking(UUID.randomUUID().toString(), movieTheaterId, movieScreenDetails);
        }
        return null;
    }

    public void cancelBooking(Booking booking) {
        MovieTheater movieTheater = getMovieTheaterUsingMovieTheaterId(booking.getMovieTheaterId());
        if(movieTheater != null) {
            movieTheater.cancelBookingForMovieScreen(booking.getMovieScreenDetails());
        }
    }

    public List<SeatInformation> getAllSeatInformation(String movieTheaterId, String movieScreenId) {
        MovieTheater movieTheater = getMovieTheaterUsingMovieTheaterId(movieTheaterId);
        if(movieTheater == null) return new ArrayList<>();
        return movieTheater.getAllSeatInformation(movieScreenId);
    }

    public List<MovieDetails> searchMovie(Request request) {
        return searchProcessor.searchMovie(request, new ArrayList<>(movieTheaters.values()));
    }

    private MovieTheater getMovieTheaterUsingMovieTheaterId(String movieTheaterId) {
        if(movieTheaters.containsKey(movieTheaterId)) return movieTheaters.get(movieTheaterId);
        System.out.println("Movie theater with ID: " + movieTheaterId + " is not valid.");
        return null;
    }
}
