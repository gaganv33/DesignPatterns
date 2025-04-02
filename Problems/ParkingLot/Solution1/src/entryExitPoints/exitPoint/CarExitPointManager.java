package entryExitPoints.exitPoint;

import data.vehicleData.VehicleType;
import entryExitPoints.EntryExitPoint;
import parkingLotManager.ParkingLotManagerFactory;

import java.util.Map;

public class CarExitPointManager extends ExitPointManager {
    public CarExitPointManager(int id, double xCor, double yCor) {
        super(id, xCor, yCor, ParkingLotManagerFactory.getInstance(VehicleType.CAR));
    }
}
