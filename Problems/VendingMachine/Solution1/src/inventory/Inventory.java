package inventory;

import data.Item;
import shelf.NullShelf;
import shelf.Shelf;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private static volatile Inventory instance;
    private final Map<Integer, Shelf> shelfs;

    private Inventory() {
        this.shelfs = new HashMap<>();
    }

    public static Inventory getInstance() {
        if(instance == null) {
            instance = new Inventory();
        }
        return instance;
    }

    public void addShelf(Shelf shelf) {
        shelfs.put(shelf.getId(), shelf);
    }

    public void removeShelf(int shelfId) {
        shelfs.remove(shelfId);
    }

    public boolean addItem(int shelfId, int quantity) {
        Shelf shelf = getShelfUsingShelfId(shelfId);
        return shelf.addItem(quantity);
    }

    public boolean removeItem(int shelfId, int quantity) {
        Shelf shelf = getShelfUsingShelfId(shelfId);
        return shelf.removeItem(quantity);
    }

    public boolean setItemInShelf(int shelfId, Item item, int quantity) {
        Shelf shelf = getShelfUsingShelfId(shelfId);
        return shelf.setItem(item, quantity);
    }

    public void clearItemFromShelf(int shelfId) {
        Shelf shelf = getShelfUsingShelfId(shelfId);
        shelf.clearItem();
    }

    public Item getItemFromShelfBasedOnQuantity(int shelfId, int quantity) {
        Shelf shelf = getShelfUsingShelfId(shelfId);
        return shelf.getPlaceholderBasedOnQuantity(quantity);
    }

    public Item getItemUsingShelfId(int shelfId) {
        Shelf shelf = getShelfUsingShelfId(shelfId);
        return shelf.getPlaceholder();
    }

    private Shelf getShelfUsingShelfId(int shelfId) {
        return shelfs.getOrDefault(shelfId, new NullShelf(-1));
    }

    public void displayItems() {
        System.out.println("Inventory");
        for(var x : shelfs.entrySet()) {
            int shelfId = x.getKey();
            Shelf shelf = x.getValue();
            System.out.println(shelfId + " " + shelf.getPlaceholder().getName() + " " + shelf.getQuantity());
        }
    }
}
