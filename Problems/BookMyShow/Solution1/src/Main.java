import booking.Booking;
import data.MovieScreenType;
import data.MovieType;
import data.SeatType;
import location.Location;
import movie.Movie;
import movie.MovieDetails;
import movie.MovieScreen;
import proxy.AdminProxy;
import proxy.UserProxy;
import search.Request;
import user.User;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        AdminProxy adminProxy = new AdminProxy();
        UserProxy userProxy = new UserProxy();

        addMovies(adminProxy);
        addTheaters(adminProxy);
        addScreens(adminProxy);
        addSeats(adminProxy);
        setMovies(adminProxy);

        for(int i = 1; i <= 5; i++) {
            searchMovies("Movie-" + i, "", "", "", userProxy);
        }

        Map<User, Booking> userData = new HashMap<>();
        User user1 = new User("User-1", "user1@gmail.com", "123456789", LocalDate.of(2005, 11, 1));
        User user2 = new User("User-2", "user2@gmail.com", "123456789", LocalDate.of(2005, 11, 1));
        User user3 = new User("User-3", "user3@gmail.com", "123456789", LocalDate.of(2005, 11, 1));
        User user4 = new User("User-4", "user4@gmail.com", "123456789", LocalDate.of(2005, 11, 1));
        bookSeats(userProxy, "Theater-1", "Screen-1", "Seat-1", user1, userData);
        bookSeats(userProxy, "Theater-1", "Screen-1", "Seat-2", user2, userData);
        bookSeats(userProxy, "Theater-1", "Screen-1", "Seat-3", user3, userData);
        bookSeats(userProxy, "Theater-1", "Screen-1", "Seat-1", user4, userData);
        userProxy.cancelBooking(userData.get(user1));
    }

    public static void addMovies(AdminProxy adminProxy) {
        adminProxy.addMovie(new Movie("Movie-1", MovieType.ACTION, LocalTime.of(2, 0, 0), new ArrayList<>(List.of(new String[]{"Direction-1", "Direction-2"})), new ArrayList<>(List.of(new String[]{"Actor-1", "Actor-2"}))));
        adminProxy.addMovie(new Movie("Movie-2", MovieType.COMEDY, LocalTime.of(2, 0, 0), new ArrayList<>(List.of(new String[]{"Direction-1", "Direction-2"})), new ArrayList<>(List.of(new String[]{"Actor-1", "Actor-2"}))));
        adminProxy.addMovie(new Movie("Movie-3", MovieType.HORROR, LocalTime.of(2, 0, 0), new ArrayList<>(List.of(new String[]{"Direction-1", "Direction-2"})), new ArrayList<>(List.of(new String[]{"Actor-1", "Actor-2"}))));
        adminProxy.addMovie(new Movie("Movie-4", MovieType.SCIENCE_FICTION, LocalTime.of(2, 0, 0), new ArrayList<>(List.of(new String[]{"Direction-1", "Direction-2"})), new ArrayList<>(List.of(new String[]{"Actor-1", "Actor-2"}))));
    }

    public static void addTheaters(AdminProxy adminProxy) {
        Location location = new Location(12.9716 ,77.5946, "Bangalore", "Karnataka", "India");
        adminProxy.addMovieTheater("Theater-1", location);
        adminProxy.addMovieTheater("Theater-2", location);
        adminProxy.addMovieTheater("Theater-3", location);
        adminProxy.addMovieTheater("Theater-4", location);
    }

    public static void addScreens(AdminProxy adminProxy) {
        adminProxy.addMovieScreenInMovieTheater("Theater-1", new MovieScreen("Screen-1", MovieScreenType.IMAX));
        adminProxy.addMovieScreenInMovieTheater("Theater-2", new MovieScreen("Screen-2", MovieScreenType.SILVER));
        adminProxy.addMovieScreenInMovieTheater("Theater-3", new MovieScreen("Screen-3", MovieScreenType.PROJECTION));
        adminProxy.addMovieScreenInMovieTheater("Theater-4", new MovieScreen("Screen-4", MovieScreenType.AUDITORIUM));
    }

    public static void setMovies(AdminProxy adminProxy) {
        adminProxy.setMovieInMovieScreen("Theater-1", "Screen-1", "Movie-1", LocalDate.of(2025, 4, 24), LocalTime.of(11, 0));
        adminProxy.setMovieInMovieScreen("Theater-2", "Screen-2", "Movie-2", LocalDate.of(2025, 4, 24), LocalTime.of(11, 0));
        adminProxy.setMovieInMovieScreen("Theater-3", "Screen-3", "Movie-3", LocalDate.of(2025, 4, 24), LocalTime.of(11, 0));
        adminProxy.setMovieInMovieScreen("Theater-4", "Screen-4", "Movie-4", LocalDate.of(2025, 4, 24), LocalTime.of(11, 0));
    }

    public static void addSeats(AdminProxy adminProxy) {
        adminProxy.addSeatInMovieScreenUsingMovieTheaterId("Theater-1", "Screen-1", "Seat-1", SeatType.SILVER);
        adminProxy.addSeatInMovieScreenUsingMovieTheaterId("Theater-1", "Screen-1", "Seat-2", SeatType.GOLD);
        adminProxy.addSeatInMovieScreenUsingMovieTheaterId("Theater-1", "Screen-1", "Seat-3", SeatType.PLATINUM);

        adminProxy.addSeatInMovieScreenUsingMovieTheaterId("Theater-2", "Screen-2", "Seat-1", SeatType.SILVER);
        adminProxy.addSeatInMovieScreenUsingMovieTheaterId("Theater-2", "Screen-2", "Seat-2", SeatType.GOLD);
        adminProxy.addSeatInMovieScreenUsingMovieTheaterId("Theater-2", "Screen-2", "Seat-3", SeatType.PLATINUM);

        adminProxy.addSeatInMovieScreenUsingMovieTheaterId("Theater-3", "Screen-3", "Seat-1", SeatType.SILVER);
        adminProxy.addSeatInMovieScreenUsingMovieTheaterId("Theater-3", "Screen-3", "Seat-2", SeatType.GOLD);
        adminProxy.addSeatInMovieScreenUsingMovieTheaterId("Theater-3", "Screen-3", "Seat-3", SeatType.PLATINUM);

        adminProxy.addSeatInMovieScreenUsingMovieTheaterId("Theater-4", "Screen-4", "Seat-1", SeatType.SILVER);
        adminProxy.addSeatInMovieScreenUsingMovieTheaterId("Theater-4", "Screen-4", "Seat-2", SeatType.GOLD);
        adminProxy.addSeatInMovieScreenUsingMovieTheaterId("Theater-4", "Screen-4", "Seat-3", SeatType.PLATINUM);
    }

    public static void searchMovies(String name, String city, String state, String country, UserProxy userProxy) {
        System.out.println("Request: " + name);
        List<MovieDetails> movieDetails = userProxy.searchMovie(new Request(name, city, state, country));
        for(var movieDetail : movieDetails) {
            System.out.println(movieDetail.getMovieTheaterId() + " " + movieDetail.getMovieScreenId() + " " + movieDetail.getMovieName() + " " + movieDetail.getDuration() + " " + movieDetail.getStartDate() + " " + movieDetail.getStartTime());
        }
    }

    public static void bookSeats(UserProxy userProxy, String movieTheaterId, String movieScreenId, String seatId, User user, Map<User, Booking> userData) {
        Booking booking = userProxy.bookSeats(movieTheaterId, movieScreenId, List.of(new String[] {seatId}), user);
        if(booking != null) {
            userData.put(user, booking);
            System.out.println(user.getName() + " " + booking.getBookingId() + " " + booking.getMovieTheaterId());
        }
    }
}