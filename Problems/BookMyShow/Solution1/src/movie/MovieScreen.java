package movie;

import data.MovieScreenType;
import notification.Notification;
import notification.NotificationFactory;
import seat.Seat;
import seat.SeatDetails;
import seat.SeatInformation;
import seat.SeatManager;
import user.User;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class MovieScreen {
    private final String id;
    private MovieScreenType movieScreenType;
    private Movie movie;
    private LocalDate startDate;
    private LocalTime startTime;
    private boolean isOccupied;
    private final SeatManager seatManager;
    private List<User> waitingUser;

    public MovieScreen(String id, MovieScreenType movieScreenType) {
        this.id = id;
        this.movieScreenType = movieScreenType;
        this.seatManager = new SeatManager();
        waitingUser = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public MovieScreenType getMovieScreenType() {
        return movieScreenType;
    }

    public void setMovieScreenType(MovieScreenType movieScreenType) {
        this.movieScreenType = movieScreenType;
    }

    public Movie getMovie() {
        return movie;
    }

    private void setMovie(Movie movie) {
        this.movie = movie;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    private void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    private void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    private void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public SeatManager getSeatManager() {
        return seatManager;
    }

    public List<User> getWaitingUser() {
        return waitingUser;
    }

    public void setWaitingUser(List<User> waitingUser) {
        this.waitingUser = waitingUser;
    }

    public void addSeat(Seat seat) {
        seatManager.addSeat(seat);
    }

    public void removeSeat(String seatId) {
        seatManager.removeSeat(seatId);
    }

    public void setMovie(Movie movie, LocalDate startDate, LocalTime startTime) {
        synchronized (this) {
            setMovie(movie);
            setStartDate(startDate);
            setStartTime(startTime);
            setOccupied(true);
        }
    }

    public void clearMovie() {
        synchronized (this) {
            setMovie(null);
            setStartDate(null);
            setStartTime(null);
            setOccupied(false);
            resetAllSeats();
            resetWaitingUserList();
        }
    }

    public boolean checkAvailabilityForMovie() {
        return movie == null;
    }

    public List<SeatDetails> bookSeats(List<String> seatIds, User user) {
        List<SeatDetails> seatDetails = seatManager.bookSeats(seatIds, user);
        if(seatDetails == null) {
            System.out.println("The requested seats are not available. So the user is added to the waiting list.");
            addUserToWaitingList(user);
        } else {
            System.out.println("The requested seats are booked.");
            removeUserFromWaitingList(user);
        }
        return seatDetails;
    }

    public boolean cancelSeats(List<SeatDetails> seatDetails) {
        LocalDate currentDate = LocalDate.now();
        if(currentDate.isBefore(startDate)) {
            seatManager.cancelBooking(seatDetails);
            notifyUsers();
            return true;
        } else if(currentDate.isEqual(currentDate)) {
            LocalTime currentTime = LocalTime.now();
            if(currentTime.isBefore(startTime)) {
                seatManager.cancelBooking(seatDetails);
                notifyUsers();
                return true;
            }
        }
        return false;
    }

    public List<SeatInformation> getAllSeatInformation() {
        return seatManager.getAllSeatInformation();
    }

    public Movie getMovieIfMatchesWithName(String name) {
        if(movie == null) return null;
        if(movie.getName().equalsIgnoreCase(name)) return movie;
        return null;
    }

    private void notifyUsers() {
        for(User user : waitingUser) {
            notifyUserUsingMessage(user);
            notifyUserUsingEmail(user);
        }
    }

    private void notifyUserUsingMessage(User user) {
        Notification messageNotification = NotificationFactory.getNotificationInstance("MESSAGE");
        messageNotification.sendMessage(user);
    }

    private void notifyUserUsingEmail(User user) {
        Notification emailNotification = NotificationFactory.getNotificationInstance("EMAIL");
        emailNotification.sendMessage(user);
    }

    private void addUserToWaitingList(User user) {
        waitingUser.add(user);
    }

    private void removeUserFromWaitingList(User user) {
        if(isUserPresentInTheWaitingList(user)) waitingUser.remove(user);
    }

    private boolean isUserPresentInTheWaitingList(User user) {
        return waitingUser.contains(user);
    }

    private void resetAllSeats() {
        seatManager.resetAllSeats();
    }

    private void resetWaitingUserList() {
        waitingUser.clear();
    }
}
