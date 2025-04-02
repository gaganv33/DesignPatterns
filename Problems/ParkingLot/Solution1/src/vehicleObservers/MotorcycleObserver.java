package vehicleObservers;

import data.vehicleData.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class MotorcycleObserver extends Observer {
    private static volatile Observer instance;
    private MotorcycleObserver(List<Vehicle> observers) {
        super(observers);
    }

    public static Observer getInstance() {
        if(instance == null) {
            synchronized (MotorcycleObserver.class) {
                if(instance == null) {
                    instance = new MotorcycleObserver(new ArrayList<>());
                }
            }
        }
        return instance;
    }
}
