package entryExitPoints.exitPoint;

import data.parkingSlotData.Ticket;
import data.vehicleData.Vehicle;
import entryExitPoints.EntryExitPoint;
import parkingLotManager.ParkingLotManager;

import java.util.Map;

public abstract class ExitPointManager {
    private final int id;
    private final EntryExitPoint exitPoint;
    private final ParkingLotManager parkingLotManager;

    public ExitPointManager(int id, double xCor, double yCor, ParkingLotManager parkingLotManager) {
        this.id = id;
        this.exitPoint = new EntryExitPoint(xCor, yCor);
        this.parkingLotManager = parkingLotManager;
    }

    public double calculateCost(Ticket ticket) {
        return parkingLotManager.getCost(ticket);
    }

    public void removeVehicle(Ticket ticket) {
        parkingLotManager.removeVehicle(ticket);
    }
}
