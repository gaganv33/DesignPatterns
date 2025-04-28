package shelf;

import data.Item;

public abstract class Shelf {
    private final int id;
    private Item placeholder;
    private int quantity;
    private boolean inStock;

    public Shelf(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Item getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(Item placeholder) {
        this.placeholder = placeholder;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public boolean isPlaceholderAvailable() {
        return this.placeholder == null;
    }

    public Item getPlaceholderBasedOnQuantity(int quantity) {
        if(this.quantity >= quantity) return placeholder;
        return null;
    }

    protected boolean checkEnoughQuantity(int quantity) {
        return (this.quantity >= quantity);
    }

    public abstract boolean setItem(Item item, int quantity);
    public abstract void clearItem();
    public abstract boolean addItem(int quantity);
    public abstract boolean removeItem(int quantity);
}
