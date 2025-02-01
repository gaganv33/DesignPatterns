package remote;

import device.Device;

public class BasicRemote implements Remote {
    protected Device device;

    public BasicRemote(Device device) {
        this.device = device;
    }

    @Override
    public void powerOff() {
        System.out.println("Remote: power off");
        device.disable();
    }

    @Override
    public void powerOn() {
        System.out.println("Remote: power on");
        device.enable();
    }

    @Override
    public void incrementChannel() {
        System.out.println("Remote: increment channel");
        device.incrementChannel();
    }

    @Override
    public void decrementChannel() {
        System.out.println("Remote: decrement channel");
        device.decrementChannel();
    }

    @Override
    public void incrementVolume() {
        System.out.println("Remote: increment volume");
        device.incrementVolume();
    }

    @Override
    public void decrementVolume() {
        System.out.println("Remote: decrement volume");
        device.decrementVolume();
    }
}
