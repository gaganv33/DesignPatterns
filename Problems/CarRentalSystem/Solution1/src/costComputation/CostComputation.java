package costComputation;

import customer.Reservation;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class CostComputation {
    private double basePrice;
    private double pricePerDay;
    private double penaltyPerDay;

    public CostComputation(double basePrice, double pricePerDay, double penaltyPerDay) {
        this.basePrice = basePrice;
        this.pricePerDay = pricePerDay;
        this.penaltyPerDay = penaltyPerDay;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public double getPenaltyPerDay() {
        return penaltyPerDay;
    }

    public void setPenaltyPerDay(double penaltyPerDay) {
        this.penaltyPerDay = penaltyPerDay;
    }

    public double computeCost(Reservation reservation) {
        LocalDate currentDate = LocalDate.now();
        long totalDays = ChronoUnit.DAYS.between(reservation.getEndDate(), reservation.getStartDate());
        long extraDays = ChronoUnit.DAYS.between(currentDate, reservation.getEndDate());
        return (totalDays * pricePerDay) + (extraDays * penaltyPerDay) + basePrice;
    }
}
