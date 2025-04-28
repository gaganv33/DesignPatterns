package inventory;

import data.Item;
import dto.request.ItemData;
import shelf.Shelf;

import java.util.Map;

public class InventoryProxy {
    private static volatile InventoryProxy instance;
    private final Inventory inventory;

    private InventoryProxy() {
        this.inventory = Inventory.getInstance();
    }

    public static InventoryProxy getInstance() {
        if(instance == null) {
            instance = new InventoryProxy();
        }
        return instance;
    }

    public void addShelf(Shelf shelf) {
        inventory.addShelf(shelf);
    }

    public void removeShelf(int shelfId) {
        inventory.removeShelf(shelfId);
    }

    public boolean addItem(int shelfId, int quantity) {
        return inventory.addItem(shelfId, quantity);
    }

    public boolean removeItem(int shelfId, int quantity) {
        return inventory.removeItem(shelfId, quantity);
    }

    public boolean setItemInShelf(int shelfId, Item item, int quantity) {
        return inventory.setItemInShelf(shelfId, item, quantity);
    }

    public void clearItemFromShelf(int shelfId) {
        inventory.clearItemFromShelf(shelfId);
    }

    public Item getItemFromShelfBasedOnQuantity(int shelfId, int quantity) {
        return inventory.getItemFromShelfBasedOnQuantity(shelfId, quantity);
    }

    public Item getItemUsingShelfId(int shelfId) {
        return inventory.getItemUsingShelfId(shelfId);
    }

    public void addAllItems(Map<ItemData, Integer> itemData) {
        for(var entrySet : itemData.entrySet()) {
            int shelfId = entrySet.getKey().getShelfId();
            int value = entrySet.getValue();
            addItem(shelfId, value);
        }
    }

    public void displayItems() {
        inventory.displayItems();
    }
}
