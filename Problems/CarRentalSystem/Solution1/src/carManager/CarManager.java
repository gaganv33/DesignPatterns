package carManager;

import car.Car;
import customer.Customer;
import customer.Reservation;

import java.time.LocalDate;
import java.util.*;

public abstract class CarManager {
    private final Map<String, Car> cars;

    public CarManager() {
        cars = new HashMap<>();
    }

    public Map<String, Car> getCars() {
        return cars;
    }

    public boolean addCar(Car car) {
        synchronized (this) {
            if(checkIfValidCarLicensePlateNo(car.getLicensePlateNo())) return false;
            cars.put(car.getLicensePlateNo(), car);
            return true;
        }
    }

    public boolean removeCar(String carLicensePlateNo, String rentalStoreId) {
        synchronized (this) {
            Car car = getCarUsingCarLicensePlatNo(carLicensePlateNo);
            if(car == null) return false;
            if(car.isReserved() || !checkIfCarAssociatedWithRentalStore(car, rentalStoreId)) return false;
            cars.remove(carLicensePlateNo);
            return true;
        }
    }

    public List<Car> searchCar(String rentalStoreId, LocalDate startDate, LocalDate endDate) {
        synchronized (this) {
            List<Car> carList = new ArrayList<>();
            for(Map.Entry<String, Car> carEntry : cars.entrySet()) {
                Car car = carEntry.getValue();
                if(checkIfCarAssociatedWithRentalStore(car, rentalStoreId) && checkAvailabilityOfCarFromStartDateAndEndDate(car, startDate, endDate)) carList.add(car);
            }
            return carList;
        }
    }

    public boolean checkAvailabilityOfCarFromStartDateAndEndDate(Car car, LocalDate startDate, LocalDate endDate) {
        synchronized (this) {
            if(!car.isReserved()) return true;
            return checkAvailabilityOfReservedCarFromStartDateToEndDate(car, startDate, endDate);
        }
    }

    public Reservation bookReservation(String carLicensePlateNo, String rentalStoreId, Customer customer, LocalDate startDate, LocalDate endDate) {
        synchronized (this) {
            Car car = getCarUsingCarLicensePlatNo(carLicensePlateNo);
            if(car == null) return null;
            if(!checkIfCarAssociatedWithRentalStore(car, rentalStoreId) || !checkAvailabilityOfCarFromStartDateAndEndDate(car, startDate, endDate)) return null;
            Reservation reservation = new Reservation(UUID.randomUUID().toString(), startDate, endDate, carLicensePlateNo, customer);
            car.addReservation(reservation);
            return reservation;
        }
    }

    public boolean removeReservation(Reservation reservation, String rentalStoreId) {
        synchronized (this) {
            Car car = getCarUsingCarLicensePlatNo(reservation.getCarLicensePlatNo());
            if(car == null) return false;
            if(!checkIfCarAssociatedWithRentalStore(car, rentalStoreId)) return false;
            car.removeReservation(reservation);
            return true;
        }
    }

    private boolean checkAvailabilityOfReservedCarFromStartDateToEndDate(Car car, LocalDate startDate, LocalDate endDate) {
        synchronized (this) {
            Reservation reservation = car.getEarliestReservation();
            if(reservation == null) return true;
            return endDate.isBefore(reservation.getStartDate()) || startDate.isAfter(reservation.getEndDate());
        }
    }

    private boolean checkIfValidCarLicensePlateNo(String carLicensePlateNo) {
        synchronized (this) {
            return cars.containsKey(carLicensePlateNo);
        }
    }

    private Car getCarUsingCarLicensePlatNo(String carLicensePlateNo) {
        synchronized (this) {
            if(!checkIfValidCarLicensePlateNo(carLicensePlateNo)) return null;
            return cars.get(carLicensePlateNo);
        }
    }

    private boolean checkIfCarAssociatedWithRentalStore(Car car, String rentalStoreId) {
        return car.getRentalStoreId().equals(rentalStoreId);
    }
}
