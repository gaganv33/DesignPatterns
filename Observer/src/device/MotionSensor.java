package device;

public abstract class MotionSensor extends SmartDevice {
    public MotionSensor(String name) {
        super(name);
    }

    public abstract void onNotifyOnMotionDetection();
}
