package device;

public class TemperatureSensorImpl extends TemperatureSensor {
    public TemperatureSensorImpl(String name) {
        super(name);
    }

    @Override
    public void onNotifyOnTemperatureChange(int temperature) {
        System.out.println(this.name + " : The temperature is: " + temperature + " activating the water sprinklers");
    }
}
