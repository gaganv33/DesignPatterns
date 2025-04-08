package car;

import customer.Reservation;
import customer.ReservationStatus;

import java.util.Optional;
import java.util.PriorityQueue;

import static java.util.Comparator.*;

public class Car {
    private final String licensePlateNo;
    private final String make;
    private final String modelNo;
    private final int yearOfManufacturing;
    private CarType carType;
    private boolean isReserved;
    private final PriorityQueue<Reservation> reservations;
    private CarStatus carStatus;
    private final String rentalStoreId;

    public Car(String licensePlateNo, String make, String modelNo, int yearOfManufacturing, CarType carType, CarStatus carStatus, String rentalStoreId) {
        this.licensePlateNo = licensePlateNo;
        this.make = make;
        this.modelNo = modelNo;
        this.yearOfManufacturing = yearOfManufacturing;
        this.carType = carType;
        this.isReserved = false;
        this.reservations = new PriorityQueue<>(comparing(Reservation::getStartDate));
        this.carStatus = carStatus;
        this.rentalStoreId = rentalStoreId;
    }

    public String getLicensePlateNo() {
        return licensePlateNo;
    }

    public String getMake() {
        return make;
    }

    public String getModelNo() {
        return modelNo;
    }

    public int getYearOfManufacturing() {
        return yearOfManufacturing;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    public PriorityQueue<Reservation> getReservations() {
        return reservations;
    }

    public CarStatus getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(CarStatus carStatus) {
        this.carStatus = carStatus;
    }

    public String getRentalStoreId() {
        return rentalStoreId;
    }

    public void addReservation(Reservation reservation) {
        setReserved(true);
        reservations.add(reservation);
    }

    public void removeReservation(Reservation reservation) {
        reservations.remove(reservation);
        if(reservations.isEmpty()) setReserved(false);
    }

    public Reservation getEarliestReservation() {
        if(reservations.isEmpty()) return null;
        return reservations.peek();
    }
}
