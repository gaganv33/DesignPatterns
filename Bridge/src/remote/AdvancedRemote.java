package remote;

import device.Device;

public class AdvancedRemote extends BasicRemote {
    public AdvancedRemote(Device device) {
        super(device);
    }

    public void mute() {
        System.out.println("Remote: mute");
        super.device.setVolume(0);
    }
}
