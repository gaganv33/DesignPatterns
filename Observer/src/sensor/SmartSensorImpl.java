package sensor;

import device.MotionSensor;
import device.SmartDevice;
import device.SmokeSensor;
import device.TemperatureSensor;

import java.util.ArrayList;
import java.util.List;

public class SmartSensorImpl implements SmartSensor {
    private final List<SmartDevice> smartDevices;

    public SmartSensorImpl() {
        smartDevices = new ArrayList<>();
    }

    @Override
    public void notifyOnSmoke() {
        for(SmartDevice smartDevice : smartDevices) {
            if(smartDevice instanceof SmokeSensor) {
                ((SmokeSensor) smartDevice).onNotifyOnSmoke();
            }
        }
    }

    @Override
    public void notifyOnMotionDetection() {
        for(SmartDevice smartDevice : smartDevices) {
            if(smartDevice instanceof MotionSensor) {
                ((MotionSensor) smartDevice).onNotifyOnMotionDetection();
            }
        }
    }

    @Override
    public void notifyOnTemperatureChange(int temperature) {
        if(temperature < 75) {
            System.out.println("The temperature is less than 75 degree celsius");
            return;
        }
        for(SmartDevice smartDevice : smartDevices) {
            if(smartDevice instanceof TemperatureSensor) {
                ((TemperatureSensor) smartDevice).onNotifyOnTemperatureChange(temperature);
            }
        }
    }

    @Override
    public void subscribe(SmartDevice smartDevice) {
        smartDevices.add(smartDevice);
    }

    @Override
    public void unSubscribe(SmartDevice smartDevice) {
        smartDevices.remove(smartDevice);
    }
}
