package data.vehicleData;

public class Vehicle {
    private String vehicleNo;
    private VehicleType vehicleType;
    private OwnerDetails ownerDetails;

    public Vehicle(String vehicleNo, VehicleType vehicleType, OwnerDetails ownerDetails) {
        this.vehicleNo = vehicleNo;
        this.vehicleType = vehicleType;
        this.ownerDetails = ownerDetails;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public OwnerDetails getOwnerDetails() {
        return ownerDetails;
    }

    public void setOwnerDetails(OwnerDetails ownerDetails) {
        this.ownerDetails = ownerDetails;
    }
}
