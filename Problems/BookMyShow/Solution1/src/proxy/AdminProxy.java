package proxy;

import data.SeatType;
import location.Location;
import movie.*;
import seat.Seat;
import seat.SeatInformation;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class AdminProxy {
    private final MovieManager movieManager;
    private final MovieTheaterManager movieTheaterManager;

    public AdminProxy() {
        this.movieManager = MovieManager.getInstance();
        this.movieTheaterManager = MovieTheaterManager.getInstance();
    }

    public void addMovie(Movie movie) {
        movieManager.addMovie(movie);
    }

    public void removeMovie(String name) {
        movieManager.removeMovie(name);
    }

    public Movie getMovieUsingName(String name) {
        return movieManager.getMovieUsingName(name);
    }

    public void addMovieTheater(String movieTheaterId, Location location) {
        movieTheaterManager.addMovieTheater(new MovieTheater(movieTheaterId, location));
    }

    public void removeMovieTheater(String movieTheaterId) {
        movieTheaterManager.removeMovieTheater(movieTheaterId);
    }

    public void addMovieScreenInMovieTheater(String movieTheaterId, MovieScreen movieScreen) {
        movieTheaterManager.addMovieScreenInMovieTheater(movieTheaterId, movieScreen);
    }

    public void removeMovieScreenInMovieTheater(String movieTheaterId, String movieScreenId) {
        movieTheaterManager.removeMovieScreenInMovieTheater(movieTheaterId, movieScreenId);
    }

    public void addSeatInMovieScreenUsingMovieTheaterId(String movieTheaterId, String movieScreenId, String seatId, SeatType seatType) {
        movieTheaterManager.addSeatInMovieScreenUsingMovieTheaterId(movieTheaterId, movieScreenId, new Seat(seatId, seatType));
    }

    public void removeSeatInMovieScreenUsingMovieTheaterId(String movieTheaterId, String movieScreenId, String seatId) {
        movieTheaterManager.removeSeatInMovieScreenUsingMovieTheaterId(movieTheaterId, movieScreenId, seatId);
    }

    public void setMovieInMovieScreen(String movieTheaterId, String movieScreenId, String movieName, LocalDate startDate, LocalTime startTime) {
        Movie movie = movieManager.getMovieUsingName(movieName);
        if(movie == null) {
            System.out.println("Movie with name: " + movieName + " not found.");
        } else {
            movieTheaterManager.setMovieInMovieScreen(movieTheaterId, movieScreenId, movie, startDate, startTime);
        }
    }

    public void clearMovieInMovieScreen(String movieTheaterId, String movieScreenId) {
        movieTheaterManager.clearMovieInMovieScreen(movieTheaterId, movieScreenId);
    }

    public List<SeatInformation> getAllSeatInformation(String movieTheaterId, String movieScreenId) {
        return movieTheaterManager.getAllSeatInformation(movieTheaterId, movieScreenId);
    }
}
