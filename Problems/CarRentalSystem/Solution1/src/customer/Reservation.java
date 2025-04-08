package customer;

import car.Car;

import java.time.LocalDate;

public class Reservation {
    private final String id;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final String carLicensePlatNo;
    private final Customer customer;
    private ReservationStatus reservationStatus;

    public Reservation(String id, LocalDate startDate, LocalDate endDate, String carLicensePlatNo, Customer customer) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.carLicensePlatNo = carLicensePlatNo;
        this.customer = customer;
        this.reservationStatus = ReservationStatus.SCHEDULED;
    }

    public String getId() {
        return id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getCarLicensePlatNo() {
        return carLicensePlatNo;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id='" + id + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", carLicensePlatNo='" + carLicensePlatNo + '\'' +
                ", customer=" + customer +
                ", reservationStatus=" + reservationStatus +
                '}';
    }
}
