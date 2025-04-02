package entryExitPoints.entryPoint;

import data.vehicleData.VehicleType;
import parkingLotManager.ParkingLotManagerFactory;

public class CarEntryPointManager extends EntryPointManager {
    public CarEntryPointManager(int id, double xCor, double yCor) {
        super(id, xCor, yCor, ParkingLotManagerFactory.getInstance(VehicleType.CAR));
    }
}
