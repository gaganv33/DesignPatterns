package data.parkingSlotData;

import data.vehicleData.Vehicle;
import data.vehicleData.VehicleType;

public abstract class ParkingSlot {
    private final int id;
    private boolean isEmpty;
    private Vehicle vehicle;
    private final VehicleType vehicleType;
    private double price;
    private final double xCor;
    private final double yCor;

    public ParkingSlot(int id, VehicleType vehicleType, double xCor, double yCor, double price) {
        this.id = id;
        this.vehicleType = vehicleType;
        this.xCor = xCor;
        this.yCor = yCor;
        this.isEmpty = true;
        this.vehicle = null;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getxCor() {
        return xCor;
    }

    public double getyCor() {
        return yCor;
    }

    public boolean canParkForVehicleType(VehicleType vehicleType) {
        return this.isEmpty && (this.vehicleType.equals(vehicleType));
    }

    public void parkVehicle(Vehicle vehicle) {
        this.isEmpty = false;
        this.vehicle = vehicle;
    }

    public void removeVehicle() {
        this.isEmpty = true;
        this.vehicle = null;
    }
}
