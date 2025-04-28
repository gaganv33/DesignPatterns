package dto.request;

import data.Item;

public class ItemRequest {
    private final int shelfId;
    private final Item item;
    private final int quantity;

    public ItemRequest(int shelfId, Item item, int quantity) {
        this.shelfId = shelfId;
        this.item = item;
        this.quantity = quantity;
    }

    public int getShelfId() {
        return shelfId;
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }
}
