package data.parkingSlotData;

import data.vehicleData.VehicleType;

public class CarParkingSlot extends ParkingSlot {
    public CarParkingSlot(int id, double xCor, double yCor) {
        super(id, VehicleType.CAR, xCor, yCor, ParkingSlotCost.CAR_COST);
    }
}
