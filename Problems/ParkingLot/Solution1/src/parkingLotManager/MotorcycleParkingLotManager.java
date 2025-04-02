package parkingLotManager;

import data.vehicleData.VehicleType;
import parkingCostComputation.CostComputation;
import parkingLotLevel.ParkingLotLevel;
import parkingStrategy.BasicParkingStrategy;
import parkingStrategy.ParkingStrategy;
import vehicleObservers.Observer;
import vehicleObservers.ObserverFactory;

import java.util.ArrayList;
import java.util.List;

public class MotorcycleParkingLotManager extends ParkingLotManager {
    private static volatile ParkingLotManager instance;

    private MotorcycleParkingLotManager(List<ParkingLotLevel> parkingLotLevels, CostComputation costComputation, Observer observer, ParkingStrategy parkingStrategy) {
        super(parkingLotLevels, costComputation, observer, parkingStrategy);
    }

    public static ParkingLotManager getInstance() {
        if(instance == null) {
            synchronized (MotorcycleParkingLotManager.class) {
                if(instance == null) {
                    instance = new MotorcycleParkingLotManager(new ArrayList<>(), new CostComputation(), ObserverFactory.getInstance(VehicleType.MOTORCYCLE), new BasicParkingStrategy());
                }
            }
        }
        return instance;
    }
}
