package parkingCostComputation;

import data.parkingSlotData.Ticket;

public class HourlyBasedCostComputation extends CostComputation {
    @Override
    public double costComputation(Ticket ticket) {
        long entranceTime = ticket.entranceTime();
        double price = ticket.price();
        long currentTime = System.currentTimeMillis();
        long timeDifference = currentTime - entranceTime;
        double hours = timeDifference / 3600000.0;
        return hours * price;
    }
}
