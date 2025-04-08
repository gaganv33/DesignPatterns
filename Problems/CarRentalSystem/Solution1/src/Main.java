import car.Car;
import car.CarStatus;
import car.CarType;
import customer.Customer;
import customer.DriversLicense;
import customer.Reservation;
import location.Location;
import rental.RentalManager;
import rental.RentalStore;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        RentalManager rentalManager = RentalManager.getInstance();
        List<Customer> customerList = new ArrayList<>();

        for(int i = 0; i < 5; i++) {
            customerList.add(new Customer(UUID.randomUUID().toString(), "Name" + i, "name" + i + "@gmail.com", "123456789",
                    new DriversLicense("Name" + i, "123456789", "address" + i, random.nextInt(), LocalDate.of(1990, 10, 1))));
        }

        for(int i = 0; i < 5; i++) {
            RentalStore rentalStore = rentalManager.createRentalStore(UUID.randomUUID().toString(),
                    new Location(random.nextDouble(-90.0, 90.0), random.nextDouble(-180.0, 180.0), "city", "state", "country"));
            for(int j = 0; j < 2; j++) {
                rentalStore.addCar(UUID.randomUUID().toString(), "SMALL", "small", 2010, CarType.SMALL, CarStatus.ACTIVE);
            }
            for(int j = 0; j < 2; j++) {
                rentalStore.addCar(UUID.randomUUID().toString(), "MEDIUM", "medium", 2010, CarType.MEDIUM, CarStatus.ACTIVE);
            }
            for(int j = 0; j < 2; j++) {
                rentalStore.addCar(UUID.randomUUID().toString(), "LARGE", "large", 2010, CarType.LARGE, CarStatus.ACTIVE);
            }
            for(Customer customer : customerList) {
                rentalStore.addCustomer(customer);
            }
        }
        RentalDemo rentalDemo1 = new RentalDemo(customerList, rentalManager);
        rentalDemo1.start();

        RentalDemo rentalDemo2 = new RentalDemo(customerList, rentalManager);
        rentalDemo2.start();

        rentalDemo1.join();
        rentalDemo2.join();
    }

    private static class RentalDemo extends Thread {
        private final List<Customer> customerList;
        private final RentalManager rentalManager;
        private final Random random = new Random();
        private final List<CarType> carTypes = new ArrayList<>(Arrays.asList(CarType.SMALL, CarType.MEDIUM, CarType.LARGE));

        public RentalDemo(List<Customer> customerList, RentalManager rentalManager) {
            this.customerList = customerList;
            this.rentalManager = rentalManager;
        }

        @Override
        public void run() {
            for(Customer customer : customerList) {
                RentalStore rentalStore = rentalManager.getNearestRentalStore(new Location(random.nextDouble(-90.0, 90.0), random.nextDouble(-180.0, 180.0), "city", "state", "country"));
                List<Car> cars = rentalStore.searchCar(carTypes.get(random.nextInt(0, 3)), LocalDate.now(), LocalDate.now());
                Car car = cars.get(random.nextInt(0, cars.size()));
                Reservation reservation = rentalStore.bookReservation(car.getLicensePlateNo(), car.getCarType(), customer.getId(), LocalDate.now(), LocalDate.now());
                if(reservation == null) {
                    System.out.println(customer.getName() + " could not reserve the car.");
                    continue;
                }
                System.out.println(customer.getName() + " " + reservation + " " + rentalStore.getId());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if(rentalStore.receiveCar(car.getLicensePlateNo(), customer.getId())) {
                    System.out.println(customer.getName() + " received car.");
                } else {
                    System.out.println(customer.getName() + " could not receive car.");
                    continue;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if(rentalStore.returnCar(car.getLicensePlateNo(), car.getCarType(), customer.getId())) {
                    System.out.println(customer.getName() + " returned car.");
                } else {
                    System.out.println(customer.getName() + " could not return car.");
                }
            }
        }
    }
}