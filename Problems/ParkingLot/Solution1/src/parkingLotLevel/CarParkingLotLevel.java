package parkingLotLevel;

import data.parkingSlotData.ParkingSlot;
import data.vehicleData.VehicleType;
import parkingLotManager.ParkingLotManagerFactory;

import java.util.List;

public class CarParkingLotLevel extends ParkingLotLevel {
    public CarParkingLotLevel(int id, List<ParkingSlot> parkingSlots) {
        super(id, parkingSlots, ParkingLotManagerFactory.getInstance(VehicleType.CAR));
    }
}
