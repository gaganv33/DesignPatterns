package vehicleObservers;

import data.vehicleData.VehicleType;

import java.util.ArrayList;

public class ObserverFactory {
    public static Observer getInstance(VehicleType vehicleType) {
        switch (vehicleType) {
            case MOTORCYCLE -> {
                return MotorcycleObserver.getInstance();
            }
            case CAR -> {
                return CarObserver.getInstance();
            }
            case TRUCK -> {
                return TruckObserver.getInstance();
            }
            default -> {
                return null;
            }
        }
    }
}
