import java.util.HashMap;
import java.util.Map;

public class VehicleRegistry {
    private final static Map<VehicleType, Vehicle> vehicleMap = new HashMap<>();
    static {
        vehicleMap.put(VehicleType.TWO, new TwoWheeler("engine type 1", "model-1", 10000L, false));
        vehicleMap.put(VehicleType.FOUR, new FourWheeler("engine type 2", "model-2", 100000L, true, true));
    }

    public static Vehicle getVehicle(VehicleType vehicleType) throws CloneNotSupportedException {
        return vehicleMap.get(vehicleType).clone();
    }
}
