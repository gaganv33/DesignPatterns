package state.impl;

import data.Item;
import dto.request.ItemData;
import dto.request.Request;
import data.VendingMachineData;
import state.ActiveState;
import vendingMachine.VendingMachine;

public class ActiveStateImpl implements ActiveState {
    public ActiveStateImpl(VendingMachine vendingMachine) {
        vendingMachine.setVendingMachineData(new VendingMachineData());
    }

    @Override
    public void selectItem(VendingMachine vendingMachine, Request request) {
        int shelfId = request.getShelfId();
        int quantity = request.getQuantity();
        Item item = getItemBasedOnShelfIdAndQuantity(vendingMachine, shelfId, quantity);
        if(item == null) {
            System.out.println("Error while selecting an item.");
            return;
        }
        removeItemFromInventoryAndAddToCart(vendingMachine, item, shelfId, quantity);
        System.out.println("Added item to the vending data.");
    }

    @Override
    public void removeItem(VendingMachine vendingMachine, Request request) {
        int shelfId = request.getShelfId();
        int quantity = request.getQuantity();
        Item item = getItemBasedOnShelfId(vendingMachine, shelfId);
        if(item == null) {
            System.out.println("Error while removing an item.");
            return;
        }
        removeItemFromCartAndAddToInventory(vendingMachine, item, shelfId, quantity);
        System.out.println("Removed item from the vending data.");
    }

    @Override
    public void cancel(VendingMachine vendingMachine) {
        vendingMachine.getInventoryProxy().addAllItems(vendingMachine.getVendingMachineData().getItems());
        vendingMachine.setState(new IdleStateImpl(vendingMachine));
    }

    @Override
    public void changeToPayment(VendingMachine vendingMachine) {
        vendingMachine.setState(new PaymentStateImpl());
    }

    private Item getItemBasedOnShelfIdAndQuantity(VendingMachine vendingMachine, int shelfId, int quantity) {
        return vendingMachine.getInventoryProxy().getItemFromShelfBasedOnQuantity(shelfId, quantity);
    }

    private Item getItemBasedOnShelfId(VendingMachine vendingMachine, int shelfId) {
        return vendingMachine.getInventoryProxy().getItemUsingShelfId(shelfId);
    }

    private void removeItemFromCartAndAddToInventory(VendingMachine vendingMachine, Item item, int shelfId, int quantity) {
        ItemData itemData = new ItemData(shelfId, item);
        vendingMachine.getInventoryProxy().addItem(shelfId, quantity);
        vendingMachine.getVendingMachineData().removeItems(itemData, quantity);
    }

    private void removeItemFromInventoryAndAddToCart(VendingMachine vendingMachine, Item item, int shelfId, int quantity) {
        ItemData itemData = new ItemData(shelfId, item);
        vendingMachine.getInventoryProxy().removeItem(shelfId, quantity);
        vendingMachine.getVendingMachineData().addItems(itemData, quantity);
    }
}
