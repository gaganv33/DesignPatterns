package rental;

import location.Location;

import java.util.HashMap;
import java.util.Map;

public class RentalManager {
    private static volatile RentalManager instance;
    private final Map<String, RentalStore> rentalStores;

    private RentalManager() {
        this.rentalStores = new HashMap<>();
    }

    public static RentalManager getInstance() {
        if(instance == null) {
            synchronized (RentalManager.class) {
                if(instance == null) {
                    instance = new RentalManager();
                }
            }
        }
        return instance;
    }

    public Map<String, RentalStore> getRentalStores() {
        return this.rentalStores;
    }

    public RentalStore createRentalStore(String rentalStoreId, Location location) {
        if(checkIfRentalStoreIdExists(rentalStoreId)) {
            System.out.println("Rental store with rental store id: " + rentalStoreId + " already exists");
            return null;
        }
        RentalStore rentalStore = new RentalStore(rentalStoreId, location);
        rentalStores.put(rentalStoreId, rentalStore);
        return rentalStore;
    }

    public void removeRentalStore(String rentalStoreId) {
        rentalStores.remove(rentalStoreId);
    }

    public RentalStore getNearestRentalStore(Location location) {
        double minDistance = Double.MAX_VALUE;
        RentalStore rentalStore = null;

        for(Map.Entry<String, RentalStore> rentalStoreEntry : rentalStores.entrySet()) {
            RentalStore store = rentalStoreEntry.getValue();
            double distance = getDistanceBetweenLocations(store.getLocation(), location);
            if(distance < minDistance) {
                minDistance = distance;
                rentalStore = store;
            }
        }
        return rentalStore;
    }

    private double getDistanceBetweenLocations(Location location1, Location location2) {
        double lat1 = location1.getLatitude();
        double lon1 = location1.getLongitude();
        double lat2 = location2.getLatitude();
        double lon2 = location2.getLongitude();
        final int R = 6371;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }

    private boolean checkIfRentalStoreIdExists(String rentalStoreId) {
        return rentalStores.containsKey(rentalStoreId);
    }
}
