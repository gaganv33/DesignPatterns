package seat;

import user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class SeatManager {
    private final ConcurrentHashMap<String, Seat> seats;

    public SeatManager() {
        seats = new ConcurrentHashMap<>();
    }

    public ConcurrentHashMap<String, Seat> getSeats() {
        return seats;
    }

    public void addSeat(Seat seat) {
        seats.put(seat.getId(), seat);
    }

    public void removeSeat(String seatId) {
        seats.remove(seatId);
    }

    public List<SeatDetails> bookSeats(List<String> seatIds, User user) {
        List<SeatDetails> seatDetails = new ArrayList<>();
        for(var seatId : seatIds) {
            synchronized (seats) {
                Seat seat = getSeatUsingSeatId(seatId);
                if(seat != null) {
                    if(!seat.isOccupied()) {
                        setSeatWithUser(seat, user);
                        seatDetails.add(new SeatDetails(seat.getId(), seat.getSeatType()));
                    } else {
                        cancelBooking(seatDetails);
                        return null;
                    }
                }
            }
        }
        return seatDetails;
    }

    public void cancelBooking(List<SeatDetails> seatDetails) {
        for(var seatDetail : seatDetails) {
            Seat seat = getSeatUsingSeatId(seatDetail.getId());
            synchronized (seats) {
                if(seat != null) clearSeat(seat);
            }
        }
    }

    public void setSeatWithUser(Seat seat, User user) {
        synchronized (seats) {
            seat.setOccupied(true);
            seat.setUser(user);
        }
    }

    public void clearSeat(Seat seat) {
        synchronized (seats) {
            seat.setOccupied(false);
            seat.setUser(null);
        }
    }

    public void resetAllSeats() {
        for(var seatEntry : seats.entrySet()) {
            synchronized (seats) {
                clearSeat(seatEntry.getValue());
            }
        }
    }

    public List<SeatInformation> getAllSeatInformation() {
        List<SeatInformation> seatInformationList = new ArrayList<>();
        for(var seatEntry : seats.entrySet()) {
            Seat seat = seatEntry.getValue();
            seatInformationList.add(new SeatInformation(seat.getId(), seat.getSeatType(), seat.isOccupied()));
        }
        return seatInformationList;
    }

    private Seat getSeatUsingSeatId(String seatId) {
        if(seats.containsKey(seatId)) {
            return seats.get(seatId);
        }
        System.out.println("Invalid Seat ID: " + seatId);
        return null;
    }
}
