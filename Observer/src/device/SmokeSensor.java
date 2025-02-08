package device;

public abstract class SmokeSensor extends SmartDevice {
    public SmokeSensor(String name) {
        super(name);
    }

    public abstract void onNotifyOnSmoke();
}
