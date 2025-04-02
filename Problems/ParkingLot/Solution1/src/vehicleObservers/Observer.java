package vehicleObservers;

import data.vehicleData.Vehicle;

import java.util.List;

public abstract class Observer {
    private final List<Vehicle> observers;

    public Observer(List<Vehicle> observers) {
        this.observers = observers;
    }

    public List<Vehicle> getObservers() {
        return observers;
    }

    public void addVehicle(Vehicle vehicle) {
        observers.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        observers.remove(vehicle);
    }

    public void notifyVehicles() {
        sendEmail();
        sendMessage();
    }

    private void sendEmail() {
        for(var vehicle : observers) {
            System.out.println("Sending message to: " + vehicle.getOwnerDetails().getEmail() +  " : vehicle type : " + vehicle.getVehicleType() + " : message : Parking Slots are available");
        }
    }

    private void sendMessage() {
        for(var vehicle : observers) {
            System.out.println("Sending message to: " + vehicle.getOwnerDetails().getPhoneNo() +  " : vehicle type : " + vehicle.getVehicleType() + " : message : Parking Slots are available");
        }
    }
}
