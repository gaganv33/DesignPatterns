package vehicleObservers;

import data.vehicleData.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class TruckObserver extends Observer {
    private static volatile Observer instance;

    private TruckObserver(List<Vehicle> observers) {
        super(observers);
    }

    public static Observer getInstance() {
        if(instance == null) {
            synchronized (TruckObserver.class) {
                if(instance == null) {
                    instance = new TruckObserver(new ArrayList<>());
                }
            }
        }
        return instance;
    }
}
