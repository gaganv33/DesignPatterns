package device;

public interface Device {
    void incrementChannel();
    void decrementChannel();
    void incrementVolume();
    void decrementVolume();
    void setVolume(Integer volume);
    public void enable();
    public void disable();
    void printStatus();
}
