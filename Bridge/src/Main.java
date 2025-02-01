import device.Device;
import device.Radio;
import device.TV;
import remote.AdvancedRemote;
import remote.BasicRemote;

public class Main {
    public static void main(String[] args) {
        Device tv = new TV();
        Device radio = new Radio();

        BasicRemote basicRemote = new BasicRemote(tv);
        AdvancedRemote advancedRemote = new AdvancedRemote(radio);

        basicRemote.decrementChannel();
        basicRemote.incrementVolume();
        basicRemote.powerOff();
        tv.printStatus();

        advancedRemote.incrementChannel();
        advancedRemote.decrementVolume();
        advancedRemote.mute();
        radio.printStatus();
    }
}