package parkingLotManager;

import data.parkingSlotData.ParkingSlotDetails;
import data.parkingSlotData.Ticket;
import data.vehicleData.Vehicle;
import data.vehicleData.VehicleType;
import entryExitPoints.EntryExitPoint;
import parkingCostComputation.CostComputation;
import parkingLotLevel.ParkingLotLevel;
import parkingStrategy.BasicParkingStrategy;
import parkingStrategy.NearestToEntryParkingStrategy;
import parkingStrategy.ParkingStrategy;
import vehicleObservers.Observer;

import java.util.List;

public abstract class ParkingLotManager {
    private final List<ParkingLotLevel> parkingLotLevels;
    private CostComputation costComputation;
    private final Observer observer;
    private ParkingStrategy parkingStrategy;

    public ParkingLotManager(List<ParkingLotLevel> parkingLotLevels, CostComputation costComputation, Observer observer, ParkingStrategy parkingStrategy) {
        this. parkingLotLevels = parkingLotLevels;
        this.costComputation = costComputation;
        this.observer = observer;
        this.parkingStrategy = parkingStrategy;
    }

    public List<ParkingLotLevel> getParkingLotLevels() {
        return parkingLotLevels;
    }

    public Observer getObserver() {
        return observer;
    }

    public CostComputation getCostComputation() {
        return costComputation;
    }

    public ParkingStrategy getParkingStrategy() {
        return parkingStrategy;
    }

    public void setCostComputation(CostComputation costComputation) {
        this.costComputation = costComputation;
    }

    public void setParkingStrategy(ParkingStrategy parkingStrategy) {
        this.parkingStrategy = parkingStrategy;
    }

    public void addParkingLotLevel(ParkingLotLevel parkingLotLevel) {
        parkingLotLevels.add(parkingLotLevel);
    }

    public boolean removeParkingLotLevel(int parkingLotLevelId) {
        ParkingLotLevel parkingLotLevel = getParkingLotLevelUsingId(parkingLotLevelId);
        if(parkingLotLevel != null && parkingLotLevel.canRemoveParkingSlotLevel()) {
            parkingLotLevels.remove(parkingLotLevel);
            return true;
        }
        return false;
    }

    public ParkingSlotDetails findParkingLot(EntryExitPoint entryPoint, Vehicle vehicle) {
        ParkingSlotDetails parkingSlotDetails = parkingStrategy.findParkingSlot(entryPoint, vehicle.getVehicleType(), parkingLotLevels);
        // registering the user to observer, if the user did not find any ParkingSlot
        if(parkingSlotDetails == null) {
            System.out.println("The user will be notified when a parking slot is available");
            observer.addVehicle(vehicle);
        }
        return parkingSlotDetails;
    }

    public Ticket parkVehicle(ParkingSlotDetails parkingSlotDetails, Vehicle vehicle) {
        // unregistering the user from the observer, since the user got a parking slot
        observer.removeVehicle(vehicle);
        ParkingLotLevel parkingLotLevel = getParkingLotLevelUsingId(parkingSlotDetails.getLevelId());
        if(checkIfValidParkingLotLevel(parkingLotLevel)) {
            System.out.println("Invalid level id");
            return null;
        }
        return parkingLotLevel.parkVehicle(parkingSlotDetails.getSlotId(), vehicle);
    }

    public double getCost(Ticket ticket) {
        ParkingLotLevel parkingLotLevel = getParkingLotLevelUsingId(ticket.parkingSlotDetails().getLevelId());
        if(checkIfValidParkingLotLevel(parkingLotLevel)) {
            System.out.println("Invalid level id");
            return 0.0;
        }
        return costComputation.costComputation(ticket);
    }

    public void removeVehicle(Ticket ticket) {
        ParkingLotLevel parkingLotLevel = getParkingLotLevelUsingId(ticket.parkingSlotDetails().getLevelId());
        if(checkIfValidParkingLotLevel(parkingLotLevel)) {
            System.out.println("Invalid level id");
            return;
        }
        parkingLotLevel.removeVehicle(ticket.parkingSlotDetails().getSlotId());
    }

    public void notifyUsers() {
        observer.notifyVehicles();
    }

    private boolean checkIfValidParkingLotLevel(ParkingLotLevel parkingLotLevel) {
        return parkingLotLevel == null;

    }

    private ParkingLotLevel getParkingLotLevelUsingId(int parkingLotLevelId) {
        for(var x : parkingLotLevels) {
            if(x.getId() == parkingLotLevelId) {
                return x;
            }
        }
        return null;
    }
}
