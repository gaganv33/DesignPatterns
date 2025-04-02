package data.parkingSlotData;

import data.vehicleData.Vehicle;

public record Ticket(long entranceTime, ParkingSlotDetails parkingSlotDetails, Vehicle vehicle, double price) {
}
