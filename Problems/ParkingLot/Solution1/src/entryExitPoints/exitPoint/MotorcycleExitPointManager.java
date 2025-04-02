package entryExitPoints.exitPoint;

import data.vehicleData.VehicleType;
import entryExitPoints.EntryExitPoint;
import parkingLotManager.ParkingLotManagerFactory;

import java.util.Map;

public class MotorcycleExitPointManager extends ExitPointManager {
    public MotorcycleExitPointManager(int id, double xCor, double yCor) {
        super(id, xCor, yCor, ParkingLotManagerFactory.getInstance(VehicleType.MOTORCYCLE));
    }
}
