package parkingStrategy;

import data.parkingSlotData.ParkingSlotDetails;
import data.vehicleData.VehicleType;
import entryExitPoints.EntryExitPoint;
import parkingLotLevel.ParkingLotLevel;

import java.util.List;

public interface ParkingStrategy {
    ParkingSlotDetails findParkingSlot(EntryExitPoint entryPoint, VehicleType vehicleType, List<ParkingLotLevel> parkingLotLevelList);
}
