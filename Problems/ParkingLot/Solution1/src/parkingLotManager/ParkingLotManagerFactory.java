package parkingLotManager;

import data.vehicleData.VehicleType;

public class ParkingLotManagerFactory {
    public static ParkingLotManager getInstance(VehicleType vehicleType) {
        switch (vehicleType) {
            case MOTORCYCLE -> {
                return MotorcycleParkingLotManager.getInstance();
            }
            case CAR -> {
                return CarParkingLotManager.getInstance();
            }
            case TRUCK -> {
                return TruckParkingLotManager.getInstance();
            }
            default -> {
                return null;
            }
        }
    }
}
