package data.parkingSlotData;

public class ParkingSlotDetails {
    private int levelId;
    private int slotId;

    public ParkingSlotDetails(int levelId, int slotId) {
        this.levelId = levelId;
        this.slotId = slotId;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }
}
