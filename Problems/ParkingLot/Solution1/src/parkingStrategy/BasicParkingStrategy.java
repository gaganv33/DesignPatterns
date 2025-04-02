package parkingStrategy;

import data.parkingSlotData.ParkingSlotDetails;
import data.vehicleData.VehicleType;
import entryExitPoints.EntryExitPoint;
import parkingLotLevel.ParkingLotLevel;

import java.util.List;

public class BasicParkingStrategy implements ParkingStrategy {
    @Override
    public ParkingSlotDetails findParkingSlot(EntryExitPoint entryPoint, VehicleType vehicleType, List<ParkingLotLevel> parkingLotLevelList) {
        return findEmptyParkingSlot(vehicleType, parkingLotLevelList);
    }

    private ParkingSlotDetails findEmptyParkingSlot(VehicleType vehicleType, List<ParkingLotLevel> parkingLotLevelList) {
        for(var x : parkingLotLevelList) {
            int slotId = x.getEmptyParkingSlotUsingVehicleType(vehicleType);
            int levelId = x.getId();
            if(slotId != -1) {
                return new ParkingSlotDetails(levelId, slotId);
            }
        }
        return null;
    }
}
