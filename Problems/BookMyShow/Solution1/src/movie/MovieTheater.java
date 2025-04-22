package movie;

import booking.MovieScreenDetails;
import location.Location;
import seat.Seat;
import seat.SeatDetails;
import seat.SeatInformation;
import user.User;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class MovieTheater {
    private final String id;
    private final Location location;
    private final ConcurrentHashMap<String, MovieScreen> movieScreens;

    public MovieTheater(String id, Location location) {
        this.id = id;
        this.location = location;
        this.movieScreens = new ConcurrentHashMap<>();
    }

    public String getId() {
        return id;
    }

    public Location getLocation() {
        return location;
    }

    public ConcurrentHashMap<String, MovieScreen> getMovieScreens() {
        return movieScreens;
    }

    public void addMovieScreen(MovieScreen movieScreen) {
        movieScreens.put(movieScreen.getId(), movieScreen);
    }

    public void removeMovieScreen(String movieScreenId) {
        movieScreens.remove(movieScreenId);
    }

    public void addSeatInMovieScreen(String movieScreenId, Seat seat) {
        MovieScreen movieScreen = getMovieScreenUsingMovieScreenId(movieScreenId);
        if(movieScreen != null) movieScreen.addSeat(seat);
    }

    public void removeSeatInMovieScreen(String movieScreenId, String seatId) {
        MovieScreen movieScreen = getMovieScreenUsingMovieScreenId(movieScreenId);
        if(movieScreen != null) movieScreen.removeSeat(seatId);
    }

    public void setMovieInMovieScreen(String movieScreenId, Movie movie, LocalDate startDate, LocalTime startTime) {
        MovieScreen movieScreen = getMovieScreenUsingMovieScreenId(movieScreenId);
        if(movieScreen != null) movieScreen.setMovie(movie, startDate, startTime);
    }

    public void removeMovieInMovieScreen(String movieScreenId) {
        MovieScreen movieScreen = getMovieScreenUsingMovieScreenId(movieScreenId);
        if(movieScreen != null) movieScreen.clearMovie();
    }

    public MovieScreenDetails bookSeatsForMovieScreen(String movieScreenId, List<String> seatIds, User user) {
        MovieScreen movieScreen = getMovieScreenUsingMovieScreenId(movieScreenId);
        if(movieScreen == null) return null;
        List<SeatDetails> seatDetails = movieScreen.bookSeats(seatIds, user);
        if(seatDetails == null) return null;
        return new MovieScreenDetails(movieScreen.getId(), movieScreen.getMovieScreenType(),seatDetails);
    }

    public void cancelBookingForMovieScreen(MovieScreenDetails movieScreenDetails) {
        MovieScreen movieScreen = getMovieScreenUsingMovieScreenId(movieScreenDetails.getMovieScreenId());
        if(movieScreen == null) return;
        if(movieScreen.cancelSeats(movieScreenDetails.getSeatDetails())) {
            System.out.println("Booking is cancelled successfully.");
        } else {
            System.out.println("Booking could not be cancelled.");
        }
    }

    public List<SeatInformation> getAllSeatInformation(String movieScreenId) {
        MovieScreen movieScreen = getMovieScreenUsingMovieScreenId(movieScreenId);
        if(movieScreen == null) return new ArrayList<>();
        return movieScreen.getAllSeatInformation();
    }

    public List<MovieDetails> getMovieUsingName(String name) {
        List<MovieDetails> movieDetails = new ArrayList<>();
        for(MovieScreen movieScreen : movieScreens.values()) {
            Movie movie = movieScreen.getMovieIfMatchesWithName(name);
            if(movie != null) {
                MovieDetails movieDetailsObj = MovieDetails.builder()
                        .movieTheaterId(this.id).movieScreenId(movieScreen.getId())
                        .movieName(movie.getName()).startDate(movieScreen.getStartDate())
                        .startTime(movieScreen.getStartTime()).duration(movie.getDuration()).build();
                movieDetails.add(movieDetailsObj);
            }
        }
        return movieDetails;
    }

    public boolean isMatchingLocationUsingCity(String city) {
        return location.isMatchingCity(city);
    }

    public boolean isMatchingLocationUsingState(String state) {
        return location.isMatchingState(state);
    }

    public boolean isMatchingLocationUsingCountry(String country) {
        return location.isMatchingCountry(country);
    }

    private MovieScreen getMovieScreenUsingMovieScreenId(String movieScreenId) {
        if(movieScreens.containsKey(movieScreenId)) return movieScreens.get(movieScreenId);
        System.out.println("Movie Screen with ID: " + movieScreenId + " is not valid.");
        return null;
    }
}
