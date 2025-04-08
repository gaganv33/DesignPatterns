package rental;

import car.Car;
import car.CarStatus;
import car.CarType;
import carManager.CarManager;
import carManager.CarManagerFactory;
import costComputation.CostComputation;
import costComputation.CostComputationFactory;
import customer.Customer;
import customer.Reservation;
import customer.ReservationStatus;
import location.Location;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RentalStore {
    private final String id;
    private final Map<String, Reservation> reservations;
    private final Map<String, Customer> customers;
    private Location location;

    public RentalStore(String id, Location location) {
        this.id = id;
        reservations = new HashMap<>();
        customers = new HashMap<>();
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public Map<String, Reservation> getReservations() {
        return reservations;
    }

    public Map<String, Customer> getCustomers() {
        return customers;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void addCar(String licensePlateNo, String make, String modelNo, int yearOfManufacturing, CarType carType, CarStatus carStatus) {
        synchronized (this) {
            CarManager carManager = getCarManagerUsingCarType(carType);
            Car car = new Car(licensePlateNo, make, modelNo, yearOfManufacturing, carType, carStatus, this.id);
            if(carManager.addCar(car)) {
                System.out.println("Car added successfully.");
            } else {
                System.out.println("Error will adding Car.");
            }
        }
    }

    public void removeCar(String carLicensePlateNo, CarType carType) {
        synchronized (this) {
            CarManager carManager = getCarManagerUsingCarType(carType);
            if(carManager.removeCar(carLicensePlateNo, this.id)) {
                System.out.println("Car removed successfully.");
            } else {
                System.out.println("Error will removing Car.");
            }
        }
    }

    public List<Car> searchCar(CarType carType, LocalDate startDate, LocalDate endDate) {
        synchronized (this) {
            CarManager carManager = getCarManagerUsingCarType(carType);
            return carManager.searchCar(this.id, startDate, endDate);
        }
    }

    public void addCustomer(Customer customer) {
        synchronized (this) {
            if(checkIfValidCustomer(customer.getId())) {
                System.out.println("Customer with ID already exists.");
            } else {
                System.out.println("Customer added.");
                customers.put(customer.getId(), customer);
            }
        }
    }

    public void removeCustomer(String customerId) {
        synchronized (this) {
            if(checkIfCustomerHasReservation(customerId) || !checkIfValidCustomer(customerId)) {
                System.out.println("Error will removing customer.");
            } else {
                customers.remove(customerId);
                System.out.println("Customer removed.");
            }
        }
    }

    public Reservation bookReservation(String carLicensePlateNo, CarType carType, String customerId, LocalDate startDate, LocalDate endDate) {
        synchronized (this) {
            if(!checkIfValidCustomer(customerId)) {
                System.out.println("Invalid customer id.");
                return null;
            }
            if(checkIfCustomerHasReservation(customerId)) {
                System.out.println("Customer already has a reservation.");
                return null;
            }
            CarManager carManager = getCarManagerUsingCarType(carType);
            Reservation reservation = carManager.bookReservation(carLicensePlateNo, this.id, customers.get(customerId), startDate, endDate);
            addReservation(customerId, reservation);
            return reservation;
        }
    }

    public boolean receiveCar(String carLicensePlateNo, String customerId) {
        synchronized (this) {
            if(!checkIfValidCustomerAndReservation(customerId)) return false;
            Reservation reservation = getReservationUsingCustomerId(customerId);
            LocalDate currentDate = LocalDate.now();
            if(currentDate.isEqual(reservation.getStartDate()) || (currentDate.isAfter(reservation.getStartDate()) && currentDate.isBefore(reservation.getEndDate()))) {
                reservation.setReservationStatus(ReservationStatus.INPROGRESS);
                return true;
            }
            return false;
        }
    }

    public boolean cancelReservation(String carLicensePlateNo, CarType carType, String customerId) {
        synchronized (this) {
            if(!checkIfValidCustomerAndReservation(customerId)) return false;
            Reservation reservation = getReservationUsingCustomerId(customerId);
            LocalDate currentDate = LocalDate.now();
            if(currentDate.isBefore(reservation.getStartDate())) {
                CarManager carManager = getCarManagerUsingCarType(carType);
                if(!carManager.removeReservation(reservation, this.id)) {
                    System.out.println("Error while removing reservation.");
                    return false;
                }
                removeReservation(customerId);
                return true;
            }
            return false;
        }
    }

    public boolean returnCar(String carLicensePlateNo, CarType carType, String customerId) {
        synchronized (this) {
            if(!checkIfValidCustomerAndReservation(customerId)) return false;
            Reservation reservation = getReservationUsingCustomerId(customerId);
            CostComputation costComputation = getCostComputationUsingCarType(carType);
            CarManager carManager = getCarManagerUsingCarType(carType);
            double cost = costComputation.computeCost(reservation);
            System.out.println("The total cost: " + cost);
            if(!carManager.removeReservation(reservation, this.id)) {
                System.out.println("Error while removing reservation.");
                return false;
            }
            removeReservation(customerId);
            return true;
        }
    }

    private boolean checkIfValidCustomerAndReservation(String customerId) {
        synchronized (this) {
            if(!checkIfValidCustomer(customerId)) {
                System.out.println("Invalid customer id.");
                return false;
            }
            if(!checkIfCustomerHasReservation(customerId)) {
                System.out.println("Customer does not have any reservation");
                return false;
            }
            return true;
        }
    }

    private CarManager getCarManagerUsingCarType(CarType carType) {
        return CarManagerFactory.getCarManager(carType);
    }

    private CostComputation getCostComputationUsingCarType(CarType carType) {
        return CostComputationFactory.getCostComputation(carType);
    }

    private boolean checkIfValidCustomer(String customerId) {
        synchronized (this) {
            return customers.containsKey(customerId);
        }
    }

    private boolean checkIfCustomerHasReservation(String customerId) {
        synchronized (this) {
            return reservations.containsKey(customerId);
        }
    }

    private Reservation getReservationUsingCustomerId(String customerId) {
        synchronized (this) {
            return reservations.get(customerId);
        }
    }

    private void addReservation(String customerId, Reservation reservation) {
        synchronized (this) {
            reservations.put(customerId, reservation);
        }
    }

    private void removeReservation(String customerId) {
        synchronized (this) {
            reservations.remove(customerId);
        }
    }
}
