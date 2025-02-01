public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        TwoWheeler twoWheeler = (TwoWheeler) VehicleRegistry.getVehicle(VehicleType.TWO);
        FourWheeler fourWheeler = (FourWheeler) VehicleRegistry.getVehicle(VehicleType.FOUR);

        fourWheeler.setEngine("engine type-44");

        System.out.println(twoWheeler);
        System.out.println(fourWheeler + " " + fourWheeler.getDiesel());
    }
}