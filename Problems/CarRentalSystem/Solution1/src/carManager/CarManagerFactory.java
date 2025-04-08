package carManager;

import car.CarType;

public class CarManagerFactory {
    public static CarManager getCarManager(CarType carType) {
        return switch (carType) {
            case SMALL -> SmallCarManager.getInstance();
            case MEDIUM -> MediumCarManager.getInstance();
            case LARGE -> LargeCarManager.getInstance();
        };
    }
}
