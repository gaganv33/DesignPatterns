package parkingCostComputation;

import data.parkingSlotData.Ticket;

public class MinuteBasedCostComputation extends CostComputation {
    @Override
    public double costComputation(Ticket ticket) {
        long entranceTime = ticket.entranceTime();
        double price = ticket.price();
        long currentTime = System.currentTimeMillis();
        long timeDifference = currentTime - entranceTime;
        double minutes = timeDifference / 60000.0;
        return minutes * price;
    }
}
