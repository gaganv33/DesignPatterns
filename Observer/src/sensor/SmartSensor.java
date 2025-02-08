package sensor;

import device.SmartDevice;

public interface SmartSensor {
    void notifyOnSmoke();
    void notifyOnMotionDetection();
    void notifyOnTemperatureChange(int temperature);
    void subscribe(SmartDevice smartDevice);
    void unSubscribe(SmartDevice smartDevice);
}
