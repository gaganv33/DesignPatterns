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

public class TruckParkingLotManager extends ParkingLotManager {
    private static volatile ParkingLotManager instance;

    private TruckParkingLotManager(List<ParkingLotLevel> parkingLotLevels, CostComputation costComputation, Observer observer, ParkingStrategy parkingStrategy) {
        super(parkingLotLevels, costComputation, observer, parkingStrategy);
    }

    public static ParkingLotManager getInstance() {
        if(instance == null) {
            synchronized (TruckParkingLotManager.class) {
                if(instance == null) {
                    instance = new TruckParkingLotManager(new ArrayList<>(), new CostComputation(), ObserverFactory.getInstance(VehicleType.TRUCK), new BasicParkingStrategy());
                }
            }
        }
        return instance;
    }
}
