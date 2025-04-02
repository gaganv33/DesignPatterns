package entryExitPoints.exitPoint;

import data.vehicleData.VehicleType;
import entryExitPoints.EntryExitPoint;
import parkingLotManager.ParkingLotManagerFactory;

import java.util.Map;

public class TruckExitPointManager extends ExitPointManager {
    public TruckExitPointManager(int id, double xCor, double yCor) {
        super(id, xCor, yCor, ParkingLotManagerFactory.getInstance(VehicleType.TRUCK));
    }
}
