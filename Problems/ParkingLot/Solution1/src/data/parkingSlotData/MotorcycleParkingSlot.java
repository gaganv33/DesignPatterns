package data.parkingSlotData;

import data.vehicleData.VehicleType;

public class MotorcycleParkingSlot extends ParkingSlot {
    public MotorcycleParkingSlot(int id, double xCor, double yCor) {
        super(id, VehicleType.MOTORCYCLE, xCor, yCor, ParkingSlotCost.MOTORCYCLE_COST);
    }
}
