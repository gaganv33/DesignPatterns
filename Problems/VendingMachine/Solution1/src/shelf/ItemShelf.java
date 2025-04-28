package shelf;

import data.Item;

public class ItemShelf extends Shelf {
    public ItemShelf(int id) {
        super(id);
    }

    @Override
    public boolean setItem(Item item, int quantity) {
        if(!isPlaceholderAvailable()) return false;
        setPlaceholder(item);
        setQuantity(quantity);
        setInStock(quantity > 0);
        return true;
    }

    @Override
    public void clearItem() {
        setPlaceholder(null);
        setQuantity(0);
        setInStock(false);
    }

    @Override
    public boolean addItem(int quantity) {
        if(isPlaceholderAvailable()) return false;
        int newQuantity = getQuantity() + quantity;
        if(newQuantity > 0) setInStock(true);
        setQuantity(newQuantity);
        return true;
    }

    @Override
    public boolean removeItem(int quantity) {
        if(isPlaceholderAvailable() || !checkEnoughQuantity(quantity)) return false;
        if(getQuantity() == quantity) {
            setInStock(false);
        }
        setQuantity(getQuantity() - quantity);
        return true;
    }
}
