package entryExitPoints.entryPoint;

import data.vehicleData.VehicleType;
import entryExitPoints.EntryExitPoint;
import parkingLotManager.ParkingLotManagerFactory;

import java.util.Map;

public class TruckEntryPointManager extends EntryPointManager {
    public TruckEntryPointManager(int id, double xCor, double yCor) {
        super(id, xCor, yCor, ParkingLotManagerFactory.getInstance(VehicleType.TRUCK));
    }
}
