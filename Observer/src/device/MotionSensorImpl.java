package device;

public class MotionSensorImpl extends MotionSensor {
    public MotionSensorImpl(String name) {
        super(name);
    }

    @Override
    public void onNotifyOnMotionDetection() {
        System.out.println(this.name + " : Motion detected, turn on the lights");
    }
}
