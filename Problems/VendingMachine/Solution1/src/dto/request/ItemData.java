package dto.request;

import data.Item;

import java.util.Objects;

public class ItemData {
    private final int shelfId;
    private final Item item;

    public ItemData(int shelfId, Item item) {
        this.shelfId = shelfId;
        this.item = item;
    }

    public int getShelfId() {
        return shelfId;
    }

    public Item getItem() {
        return item;
    }

    @Override
    public int hashCode() {
        return Objects.hash(shelfId, item);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || this.getClass() != obj.getClass()) return false;
        ItemData itemData = (ItemData) obj;
        return (shelfId == itemData.getShelfId()) && Objects.equals(this.item, itemData.getItem());
    }
}
