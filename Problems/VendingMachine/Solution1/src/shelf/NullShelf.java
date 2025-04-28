package shelf;

import data.Item;

public class NullShelf extends Shelf {
    public NullShelf(int id) {
        super(id);
    }

    @Override
    public boolean setItem(Item item, int quantity) {
        return false;
    }

    @Override
    public void clearItem() {
    }

    @Override
    public boolean addItem(int quantity) {
        return false;
    }

    @Override
    public boolean removeItem(int quantity) {
        return false;
    }
}
