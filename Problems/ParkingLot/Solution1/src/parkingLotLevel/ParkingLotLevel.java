package parkingLotLevel;

import data.parkingSlotData.ParkingSlot;
import data.parkingSlotData.ParkingSlotDetails;
import data.parkingSlotData.Ticket;
import data.vehicleData.Vehicle;
import data.vehicleData.VehicleType;
import parkingLotManager.ParkingLotManager;

import java.util.List;

public abstract class ParkingLotLevel {
    private final int id;
    private final List<ParkingSlot> parkingSlots;
    private int totalEmptySlots;
    private final ParkingLotManager parkingLotManager;

    public ParkingLotLevel(int id, List<ParkingSlot> parkingSlots, ParkingLotManager parkingLotManager) {
        this.id = id;
        this.parkingSlots = parkingSlots;
        totalEmptySlots = parkingSlots.size();
        this.parkingLotManager = parkingLotManager;
    }

    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    public int getTotalEmptySlots() {
        return totalEmptySlots;
    }

    public int getId() {
        return id;
    }

    public void addParkingSlot(ParkingSlot parkingSlot) {
        parkingSlots.add(parkingSlot);
        totalEmptySlots++;
    }

    public boolean removeParkingSlot(int parkingSlotId) {
        ParkingSlot parkingSlot = getParkingSlotUsingId(parkingSlotId);
        if(parkingSlot != null && !parkingSlot.isEmpty()) return false;
        parkingSlots.remove(parkingSlot);
        totalEmptySlots--;
        return true;
    }

    public boolean canRemoveParkingSlotLevel() {
        for(var x : parkingSlots) {
            if(!x.isEmpty()) return false;
        }
        return true;
    }

    public int getEmptyParkingSlotUsingVehicleType(VehicleType vehicleType) {
        for(var x : parkingSlots) {
            if(x.getVehicleType().equals(vehicleType) && x.isEmpty()) {
                return x.getId();
            }
        }
        return -1;
    }

    public Ticket parkVehicle(int parkingSlotId, Vehicle vehicle) {
        ParkingSlot parkingSlot = getParkingSlotUsingId(parkingSlotId);
        if(checkIfValidParkingSlot(parkingSlot)) {
            System.out.println("Invalid parking slot id");
            return null;
        }
        parkingSlot.parkVehicle(vehicle);
        totalEmptySlots--;
        return new Ticket(System.currentTimeMillis(), new ParkingSlotDetails(this.id, parkingSlotId), vehicle, parkingSlot.getPrice());
    }

    public void removeVehicle(int parkingSlotId) {
        ParkingSlot parkingSlot = getParkingSlotUsingId(parkingSlotId);
        if(checkIfValidParkingSlot(parkingSlot)) {
            System.out.println("Invalid parking slot id");
            return;
        }
        if(totalEmptySlots == 0) {
            parkingLotManager.notifyUsers();
        }
        parkingSlot.removeVehicle();
        totalEmptySlots++;
    }

    private boolean checkIfValidParkingSlot(ParkingSlot parkingSlot) {
        return parkingSlot == null;
    }

    private ParkingSlot getParkingSlotUsingId(int parkingSlotId) {
        for(var x : parkingSlots) {
            if(x.getId() == parkingSlotId) {
                return x;
            }
        }
        return null;
    }
}
