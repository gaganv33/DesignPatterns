import device.MotionSensorImpl;
import device.SmartDevice;
import device.SmokeSensorImpl;
import device.TemperatureSensorImpl;
import sensor.SmartSensor;
import sensor.SmartSensorImpl;

public class Main {
    public static void main(String[] args) {
        SmartDevice smokeSensor1 = new SmokeSensorImpl("Smoke Sensor 1");
        SmartDevice smokeSensor2 = new SmokeSensorImpl("Smoke Sensor 2");
        SmartDevice smokeSensor3 = new SmokeSensorImpl("Smoke Sensor 3");

        SmartDevice motionSensor1 = new MotionSensorImpl("Motion Sensor 1");
        SmartDevice motionSensor2 = new MotionSensorImpl("Motion Sensor 2");
        SmartDevice motionSensor3 = new MotionSensorImpl("Motion Sensor 3");

        SmartDevice temperatureSensor1 = new TemperatureSensorImpl("Temperature Sensor 1");
        SmartDevice temperatureSensor2 = new TemperatureSensorImpl("Temperature Sensor 2");
        SmartDevice temperatureSensor3 = new TemperatureSensorImpl("Temperature Sensor 3");

        SmartSensor smartSensor = new SmartSensorImpl();
        smartSensor.subscribe(smokeSensor1);
        smartSensor.subscribe(smokeSensor2);
        smartSensor.subscribe(smokeSensor3);
        smartSensor.subscribe(motionSensor1);
        smartSensor.subscribe(motionSensor2);
        smartSensor.subscribe(motionSensor3);
        smartSensor.subscribe(temperatureSensor1);
        smartSensor.subscribe(temperatureSensor2);
        smartSensor.subscribe(temperatureSensor3);

        smartSensor.notifyOnMotionDetection();
        smartSensor.notifyOnSmoke();
        smartSensor.notifyOnTemperatureChange(60);
        smartSensor.notifyOnTemperatureChange(80);

        smartSensor.unSubscribe(temperatureSensor3);
        smartSensor.notifyOnTemperatureChange(100);
    }
}