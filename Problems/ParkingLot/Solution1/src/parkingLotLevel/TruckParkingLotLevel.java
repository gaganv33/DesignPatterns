package parkingLotLevel;

import data.parkingSlotData.ParkingSlot;
import data.vehicleData.VehicleType;
import parkingLotManager.ParkingLotManagerFactory;

import java.util.List;

public class TruckParkingLotLevel extends ParkingLotLevel {
    public TruckParkingLotLevel(int id, List<ParkingSlot> parkingSlots) {
        super(id, parkingSlots, ParkingLotManagerFactory.getInstance(VehicleType.TRUCK));
    }
}
