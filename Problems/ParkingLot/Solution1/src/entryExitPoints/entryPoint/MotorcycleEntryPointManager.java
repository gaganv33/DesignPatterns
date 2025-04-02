package entryExitPoints.entryPoint;

import data.vehicleData.VehicleType;
import parkingLotManager.ParkingLotManagerFactory;

public class MotorcycleEntryPointManager extends EntryPointManager {
    public MotorcycleEntryPointManager(int id, double xCor, double yCor) {
        super(id, xCor, yCor, ParkingLotManagerFactory.getInstance(VehicleType.MOTORCYCLE));
    }
}
