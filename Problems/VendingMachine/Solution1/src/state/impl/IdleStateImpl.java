package state.impl;

import dto.request.ItemRequest;
import dto.request.Request;
import shelf.Shelf;
import state.IdleState;
import vendingMachine.VendingMachine;

public class IdleStateImpl implements IdleState {
    public IdleStateImpl(VendingMachine vendingMachine) {
        vendingMachine.setVendingMachineData(null);
    }

    @Override
    public void addShelf(VendingMachine vendingMachine, Shelf shelf) {
        vendingMachine.getInventoryProxy().addShelf(shelf);
    }

    @Override
    public void removeShelf(VendingMachine vendingMachine, int shelfId) {
        vendingMachine.getInventoryProxy().removeShelf(shelfId);
    }

    @Override
    public void setItemInShelf(VendingMachine vendingMachine, ItemRequest itemRequest) {
        if(vendingMachine.getInventoryProxy().setItemInShelf(itemRequest.getShelfId(), itemRequest.getItem(), itemRequest.getQuantity())) {
            System.out.println("Item is placed in the shelf.");
        } else {
            System.out.println("Error in placing the item in the shelf");
        }
    }

    @Override
    public void clearItem(VendingMachine vendingMachine, int shelfId) {
        vendingMachine.getInventoryProxy().clearItemFromShelf(shelfId);
    }

    @Override
    public void addItem(VendingMachine vendingMachine, Request request) {
        if(vendingMachine.getInventoryProxy().addItem(request.getShelfId(), request.getQuantity())) {
            System.out.println("Added item successfully.");
        } else {
            System.out.println("Error will adding item.");
        }
    }

    @Override
    public void removeItem(VendingMachine vendingMachine, Request request) {
        if(vendingMachine.getInventoryProxy().removeItem(request.getShelfId(), request.getQuantity())) {
            System.out.println("Removal of item done successfully.");
        } else {
            System.out.println("Error will removing item.");
        }
    }

    @Override
    public void changeToSelectItem(VendingMachine vendingMachine) {
        vendingMachine.setState(new ActiveStateImpl(vendingMachine));
    }
}
