package device;

public abstract class TemperatureSensor extends SmartDevice {
    public TemperatureSensor(String name) {
        super(name);
    }

    public abstract void onNotifyOnTemperatureChange(int temperature);
}
