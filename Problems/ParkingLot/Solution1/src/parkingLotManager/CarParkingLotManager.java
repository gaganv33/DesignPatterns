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

public class CarParkingLotManager extends ParkingLotManager {
    private static volatile ParkingLotManager instance;

    private CarParkingLotManager(List<ParkingLotLevel> parkingLotLevels, CostComputation costComputation, Observer observer, ParkingStrategy parkingStrategy) {
        super(parkingLotLevels, costComputation, observer, parkingStrategy);
    }

    public static ParkingLotManager getInstance() {
        if(instance == null) {
            synchronized (CarParkingLotManager.class) {
                if(instance == null) {
                    instance = new CarParkingLotManager(new ArrayList<>(), new CostComputation(), ObserverFactory.getInstance(VehicleType.CAR), new BasicParkingStrategy());
                }
            }
        }
        return instance;
    }
}
