import data.parkingSlotData.*;
import data.vehicleData.OwnerDetails;
import data.vehicleData.Vehicle;
import data.vehicleData.VehicleType;
import entryExitPoints.entryPoint.CarEntryPointManager;
import entryExitPoints.entryPoint.EntryPointManager;
import entryExitPoints.entryPoint.MotorcycleEntryPointManager;
import entryExitPoints.entryPoint.TruckEntryPointManager;
import entryExitPoints.exitPoint.CarExitPointManager;
import entryExitPoints.exitPoint.ExitPointManager;
import entryExitPoints.exitPoint.MotorcycleExitPointManager;
import entryExitPoints.exitPoint.TruckExitPointManager;
import parkingCostComputation.HourlyBasedCostComputation;
import parkingCostComputation.MinuteBasedCostComputation;
import parkingLotLevel.CarParkingLotLevel;
import parkingLotLevel.MotorcycleParkingLotLevel;
import parkingLotLevel.ParkingLotLevel;
import parkingLotLevel.TruckParkingLotLevel;
import parkingLotManager.CarParkingLotManager;
import parkingLotManager.MotorcycleParkingLotManager;
import parkingLotManager.ParkingLotManager;
import parkingLotManager.TruckParkingLotManager;
import parkingStrategy.NearestToEntryParkingStrategy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static double entryPointXCor = 0.0;
    static double entryPointYCor = 0.0;
    static double exitPointXCor = 100.0;
    static double exitPointYCor = 100.0;

    public static void main(String[] args) throws InterruptedException {
        EntryPointManager motorcycleEntryPointManager = new MotorcycleEntryPointManager(1, entryPointXCor, entryPointYCor);
        EntryPointManager carEntryPointManager = new CarEntryPointManager(2, entryPointXCor, entryPointYCor);
        EntryPointManager truckEntryPointManager = new TruckEntryPointManager(3, entryPointXCor, entryPointYCor);

        ExitPointManager motorcycleExitPointManager = new MotorcycleExitPointManager(4, exitPointXCor, exitPointYCor);
        ExitPointManager carExitPointManager = new CarExitPointManager(5, exitPointXCor, exitPointYCor);
        ExitPointManager truckExitPointManager = new TruckExitPointManager(6, exitPointXCor, exitPointYCor);

        addParkingSlotAndLevel();

        checkTruckParking(truckEntryPointManager, truckExitPointManager);
        checkCarParking(carEntryPointManager, carExitPointManager);
        checkMotorcycleParking(motorcycleEntryPointManager, motorcycleExitPointManager);
    }

    private static void addParkingSlotAndLevel() {
        ParkingLotManager motorcycleLotManager = MotorcycleParkingLotManager.getInstance();
        ParkingLotManager carLotManager = CarParkingLotManager.getInstance();
        ParkingLotManager truckLotManager = TruckParkingLotManager.getInstance();

        // parking strategy
        carLotManager.setParkingStrategy(new NearestToEntryParkingStrategy());
        motorcycleLotManager.setParkingStrategy(new NearestToEntryParkingStrategy());

        // setting cost computation
        truckLotManager.setCostComputation(new MinuteBasedCostComputation());
        carLotManager.setCostComputation(new HourlyBasedCostComputation());

        // parking lot level
        ParkingLotLevel truckLotLevel1 = new TruckParkingLotLevel(1, new ArrayList<>());

        ParkingLotLevel carLotLevel1 = new CarParkingLotLevel(2, new ArrayList<>());
        ParkingLotLevel carLotLevel2 = new CarParkingLotLevel(3, new ArrayList<>());

        ParkingLotLevel motorcycleLotLevel1 = new MotorcycleParkingLotLevel(4, new ArrayList<>());
        ParkingLotLevel motorcycleLotLevel2 = new MotorcycleParkingLotLevel(5, new ArrayList<>());

        // parking slots
        truckLotLevel1.addParkingSlot(new TruckParkingSlot(1, 1.5, 2.5));
        truckLotLevel1.addParkingSlot(new TruckParkingSlot(2, 100.5, 2.5));
        truckLotLevel1.addParkingSlot(new TruckParkingSlot(3, 200.5, 2.5));

        carLotLevel1.addParkingSlot(new CarParkingSlot(7, 1.5, 50));
        carLotLevel1.addParkingSlot(new CarParkingSlot(6, 20.5, 50));
        carLotLevel2.addParkingSlot(new CarParkingSlot(5, 1.5, 50));
        carLotLevel2.addParkingSlot(new CarParkingSlot(4, 20.5, 50));

        motorcycleLotLevel1.addParkingSlot(new MotorcycleParkingSlot(12, 1.5, 70));
        motorcycleLotLevel1.addParkingSlot(new MotorcycleParkingSlot(11, 10.5, 70));
        motorcycleLotLevel1.addParkingSlot(new MotorcycleParkingSlot(10, 20.5, 70));
        motorcycleLotLevel2.addParkingSlot(new MotorcycleParkingSlot(9, 1.5, 70));
        motorcycleLotLevel2.addParkingSlot(new MotorcycleParkingSlot(8, 10.5, 70));

        motorcycleLotManager.addParkingLotLevel(motorcycleLotLevel1);
        motorcycleLotManager.addParkingLotLevel(motorcycleLotLevel2);

        carLotManager.addParkingLotLevel(carLotLevel1);
        carLotManager.addParkingLotLevel(carLotLevel2);

        truckLotManager.addParkingLotLevel(truckLotLevel1);
    }

    private static void checkTruckParking(EntryPointManager truckEntryPointManager, ExitPointManager truckExitPointManager) throws InterruptedException {
        Queue<Ticket> q = new LinkedList<>();
        for(int i = 0; i < 5; i++) {
            Vehicle vehicle = new Vehicle("TRUCK-" + Integer.toString(i), VehicleType.TRUCK,
                    new OwnerDetails("Owner", "email" + Integer.toString(i) + "@truck.com", "123456789"));
            ParkingSlotDetails parkingSlotDetails = truckEntryPointManager.findParkingSlot(vehicle);
            if(parkingSlotDetails != null) {
                System.out.println(vehicle.getVehicleNo() + " " + parkingSlotDetails.getLevelId() + " " + parkingSlotDetails.getSlotId());
                Ticket ticket = truckEntryPointManager.parkVehicle(parkingSlotDetails, vehicle);
                q.add(ticket);
            }
        }

        Thread.sleep(100000);

        if(q.size() > 1) {
            Ticket ticket = q.poll();
            double cost = truckExitPointManager.calculateCost(ticket);
            System.out.println(cost);
            truckExitPointManager.removeVehicle(ticket);
        }
    }

    private static void checkCarParking(EntryPointManager carEntryPointManager, ExitPointManager carExitPointManager) throws InterruptedException {
        Queue<Ticket> q = new LinkedList<>();
        for(int i = 0; i < 10; i++) {
            Vehicle vehicle = new Vehicle("CAR-" + Integer.toString(i), VehicleType.CAR,
                    new OwnerDetails("Owner", "email" + Integer.toString(i) + "@car.com", "123456789"));
            ParkingSlotDetails parkingSlotDetails = carEntryPointManager.findParkingSlot(vehicle);
            if(parkingSlotDetails != null) {
                System.out.println(vehicle.getVehicleNo() + " " + parkingSlotDetails.getLevelId() + " " + parkingSlotDetails.getSlotId());
                Ticket ticket = carEntryPointManager.parkVehicle(parkingSlotDetails, vehicle);
                q.add(ticket);
            }
        }

        Thread.sleep(10000);

        if(q.size() > 1) {
            Ticket ticket = q.poll();
            double cost = carExitPointManager.calculateCost(ticket);
            System.out.println(cost);
            carExitPointManager.removeVehicle(ticket);
        }
    }

    private static void checkMotorcycleParking(EntryPointManager motorcycleEntryPointManager, ExitPointManager motorcycleExitPointManager) throws InterruptedException {
        Queue<Ticket> q = new LinkedList<>();
        for(int i = 0; i < 15; i++) {
            Vehicle vehicle = new Vehicle("MOTORCYCLE-" + Integer.toString(i), VehicleType.MOTORCYCLE,
                    new OwnerDetails("Owner", "email" + Integer.toString(i) + "@motorcycle.com", "123456789"));
            ParkingSlotDetails parkingSlotDetails = motorcycleEntryPointManager.findParkingSlot(vehicle);
            if(parkingSlotDetails != null) {
                System.out.println(vehicle.getVehicleNo() + " " + parkingSlotDetails.getLevelId() + " " + parkingSlotDetails.getSlotId());
                Ticket ticket = motorcycleEntryPointManager.parkVehicle(parkingSlotDetails, vehicle);
                q.add(ticket);
            }
        }

        if(q.size() > 1) {
            Ticket ticket = q.poll();
            double cost = motorcycleExitPointManager.calculateCost(ticket);
            System.out.println(cost);
            motorcycleExitPointManager.removeVehicle(ticket);
        }
    }
}