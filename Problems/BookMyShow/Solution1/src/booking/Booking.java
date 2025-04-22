package booking;

public class Booking {
    private final String bookingId;
    private final String movieTheaterId;
    private final MovieScreenDetails movieScreenDetails;

    public Booking(String bookingId, String movieTheaterId, MovieScreenDetails movieScreenDetails) {
        this.bookingId = bookingId;
        this.movieTheaterId = movieTheaterId;
        this.movieScreenDetails = movieScreenDetails;
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getMovieTheaterId() {
        return movieTheaterId;
    }

    public MovieScreenDetails getMovieScreenDetails() {
        return movieScreenDetails;
    }
}
