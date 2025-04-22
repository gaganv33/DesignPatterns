package seat;

import data.SeatType;

public class SeatDetails {
    private final String id;
    private final SeatType seatType;

    public SeatDetails(String id, SeatType seatType) {
        this.id = id;
        this.seatType = seatType;
    }

    public String getId() {
        return id;
    }

    public SeatType getSeatType() {
        return seatType;
    }
}
