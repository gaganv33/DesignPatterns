package seat;

import data.SeatType;

public class SeatInformation {
    private final String seatId;
    private final SeatType seatType;
    private final boolean isOccupied;

    public SeatInformation(String seatId, SeatType seatType, boolean isOccupied) {
        this.seatId = seatId;
        this.seatType = seatType;
        this.isOccupied = isOccupied;
    }

    public String getSeatId() {
        return seatId;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public boolean isOccupied() {
        return isOccupied;
    }
}
