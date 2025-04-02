package entryExitPoints.entryPoint;

import data.parkingSlotData.ParkingSlotDetails;
import data.parkingSlotData.Ticket;
import data.vehicleData.Vehicle;
import entryExitPoints.EntryExitPoint;
import parkingLotManager.ParkingLotManager;

import java.util.Map;

public abstract class EntryPointManager {
    private final int id;
    private final EntryExitPoint entryPoint;
    private final ParkingLotManager parkingLotManager;

    public EntryPointManager(int id, double xCor, double yCor, ParkingLotManager parkingLotManager) {
        this.id = id;
        this.entryPoint = new EntryExitPoint(xCor, yCor);
        this.parkingLotManager = parkingLotManager;
    }

    public ParkingSlotDetails findParkingSlot(Vehicle vehicle) {
        return parkingLotManager.findParkingLot(entryPoint, vehicle);
    }

    public Ticket parkVehicle(ParkingSlotDetails parkingSlotDetails, Vehicle vehicle) {
        return parkingLotManager.parkVehicle(parkingSlotDetails, vehicle);
    }
}
