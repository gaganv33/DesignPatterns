package data.parkingSlotData;

import data.vehicleData.VehicleType;

public class TruckParkingSlot extends ParkingSlot {
    public TruckParkingSlot(int id, double xCor, double yCor) {
        super(id, VehicleType.TRUCK, xCor, yCor, ParkingSlotCost.TRUCK_COST);
    }
}
