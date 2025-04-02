package vehicleObservers;

import data.vehicleData.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class CarObserver extends Observer {
    private static volatile Observer instance;

    private CarObserver(List<Vehicle> observers) {
        super(observers);
    }

    public static Observer getInstance() {
        if(instance == null) {
            synchronized (CarObserver.class) {
                if(instance == null) {
                    instance = new CarObserver(new ArrayList<>());
                }
            }
        }
        return instance;
    }
}
