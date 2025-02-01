package device;

import data.RadioData;
import data.TVData;

public class Radio implements Device {
    private Boolean isEnabled = true;
    private Integer volume = 20;
    private Integer channel = 20;

    public Radio() {

    }

    public Radio(Boolean isEnabled, Integer volume, Integer channel) {
        this.isEnabled = isEnabled;
        this.volume = volume;
        this.channel = channel;
    }

    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public Integer getVolume() {
        return volume;
    }

    public Integer getChannel() {
        return channel;
    }

    @Override
    public void incrementChannel() {
        if(channel.equals(RadioData.maxChannel)) {
            channel = 0;
        } else {
            channel += 1;
        }
    }

    @Override
    public void decrementChannel() {
        if(channel.equals(0)) {
            channel = RadioData.maxChannel;
        } else {
            channel -= 1;
        }
    }

    @Override
    public void incrementVolume() {
        if(volume < RadioData.maxVolume) {
            volume += 1;
        }
    }

    @Override
    public void decrementVolume() {
        if(volume > 0) {
            volume -= 1;
        }
    }

    @Override
    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    @Override
    public void enable() {
        isEnabled = true;
    }

    @Override
    public void disable() {
        isEnabled = false;
    }

    @Override
    public void printStatus() {
        System.out.println("Radio");
        System.out.println("Is enabled: " + isEnabled);
        System.out.println("Channel number: " + channel);
        System.out.println("Volume: " + volume);
    }
}
