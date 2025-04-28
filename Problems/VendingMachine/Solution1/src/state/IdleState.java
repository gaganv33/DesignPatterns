package state;

import dto.request.ItemRequest;
import dto.request.Request;
import shelf.Shelf;
import vendingMachine.VendingMachine;

public interface IdleState extends State {
    void addShelf(VendingMachine vendingMachine, Shelf shelf);
    void removeShelf(VendingMachine vendingMachine, int shelfId);
    void setItemInShelf(VendingMachine vendingMachine, ItemRequest itemRequest);
    void clearItem(VendingMachine vendingMachine, int shelfId);
    void addItem(VendingMachine vendingMachine, Request request);
    void removeItem(VendingMachine vendingMachine, Request request);
    void changeToSelectItem(VendingMachine vendingMachine);
}
