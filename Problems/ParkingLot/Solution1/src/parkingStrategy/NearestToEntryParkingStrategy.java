package parkingStrategy;

import data.parkingSlotData.ParkingSlotDetails;
import data.vehicleData.VehicleType;
import entryExitPoints.EntryExitPoint;
import parkingLotLevel.ParkingLotLevel;

import java.util.List;

public class NearestToEntryParkingStrategy implements ParkingStrategy {
    @Override
    public ParkingSlotDetails findParkingSlot(EntryExitPoint entryPoint, VehicleType vehicleType, List<ParkingLotLevel> parkingLotLevelList) {
        return findEmptyParkingSlotBasedOnDistance(entryPoint, vehicleType, parkingLotLevelList);
    }

    private ParkingSlotDetails findEmptyParkingSlotBasedOnDistance(EntryExitPoint entryPoint, VehicleType vehicleType, List<ParkingLotLevel> parkingLotLevelList) {
        for(var x : parkingLotLevelList) {
            double distance = Double.MAX_VALUE;
            int slotId = -1;
            int levelId = x.getId();
            for(var y : x.getParkingSlots()) {
                if(y.canParkForVehicleType(vehicleType)) {
                    double dist = Math.sqrt(Math.pow(Math.abs(entryPoint.getxCor() - y.getxCor()), 2) + Math.pow(Math.abs(entryPoint.getyCor() - y.getyCor()), 2));
                    if(dist < distance) {
                        distance = dist;
                        slotId = y.getId();
                    }
                }
            }
            if(slotId != -1) return new ParkingSlotDetails(levelId, slotId);
        }
        return null;
    }
}
