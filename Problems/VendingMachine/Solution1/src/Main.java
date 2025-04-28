import data.*;
import dto.request.ItemRequest;
import dto.request.Request;
import shelf.ItemShelf;
import vendingMachine.VendingMachine;

public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = VendingMachine.getInstance();
        addShelf(vendingMachine);
        addItemInShelf(vendingMachine);
        vendingMachine.changeToSelectProduct();
        vendingMachine.selectItem(new Request(1, 2));
        vendingMachine.selectItem(new Request(2, 2));
        vendingMachine.selectItem(new Request(3, 2));
        vendingMachine.selectItem(new Request(5, 2));
        vendingMachine.selectItem(new Request(1, 6));
        vendingMachine.selectItem(new Request(5, 2));
        vendingMachine.removeItemFromCart(new Request(1, 4));
        vendingMachine.displayItems();
        vendingMachine.changeToPayment();
        vendingMachine.displayAmount();
        vendingMachine.clearItem(1);
        vendingMachine.addNote(NoteType.HUNDRED);
        vendingMachine.returnChange();
        vendingMachine.dispenseProduct();
        vendingMachine.displayAmount();
        vendingMachine.displayItems();
    }

    public static void addShelf(VendingMachine vendingMachine) {
        for(int i = 1; i <= 6; i++) {
            vendingMachine.addShelf(new ItemShelf(i));
        }
    }

    public static void addItemInShelf(VendingMachine vendingMachine) {
        vendingMachine.setItemInShelf(new ItemRequest(1, new Item("Item-1", 1), 10));
        vendingMachine.setItemInShelf(new ItemRequest(2, new Item("Item-2", 2), 5));
        vendingMachine.setItemInShelf(new ItemRequest(3, new Item("Item-3", 3), 6));
        vendingMachine.setItemInShelf(new ItemRequest(4, new Item("Item-4", 4), 7));
        vendingMachine.setItemInShelf(new ItemRequest(5, new Item("Item-5", 5), 8));
        vendingMachine.setItemInShelf(new ItemRequest(6, new Item("Item-6", 6), 9));
    }
}