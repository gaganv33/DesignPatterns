package vendingMachine;

import amount.CashProxy;
import data.*;
import dto.request.ItemRequest;
import dto.request.Request;
import dto.response.Change;
import inventory.InventoryProxy;
import shelf.Shelf;
import state.*;
import state.impl.IdleStateImpl;

public class VendingMachine {
    private static volatile VendingMachine instance;
    private final InventoryProxy inventoryProxy;
    private final CashProxy cashProxy;
    private VendingMachineData vendingMachineData;
    private State state;

    private VendingMachine() {
        this.inventoryProxy = InventoryProxy.getInstance();
        this.cashProxy = CashProxy.getInstance();
        vendingMachineData = null;
        this.state = new IdleStateImpl(this);
    }

    public static VendingMachine getInstance() {
        if(instance == null) {
            instance = new VendingMachine();
        }
        return instance;
    }

    public static void setInstance(VendingMachine instance) {
        VendingMachine.instance = instance;
    }

    public InventoryProxy getInventoryProxy() {
        return inventoryProxy;
    }

    public CashProxy getCashProxy() {
        return cashProxy;
    }

    public VendingMachineData getVendingMachineData() {
        return vendingMachineData;
    }

    public void setVendingMachineData(VendingMachineData vendingMachineData) {
        this.vendingMachineData = vendingMachineData;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void addShelf(Shelf shelf) {
        if(state instanceof IdleState) {
            ((IdleState) state).addShelf(this, shelf);
        } else {
            System.out.println("The state has to be in idle state.");
        }
    }

    public void removeShelf(int shelfId) {
        if(state instanceof IdleState) {
            ((IdleState) state).removeShelf(this, shelfId);
        } else {
            System.out.println("The state has to be in idle state.");
        }
    }

    public void setItemInShelf(ItemRequest itemRequest) {
        if(state instanceof IdleState) {
            ((IdleState) state).setItemInShelf(this, itemRequest);
        } else {
            System.out.println("The state has to be in idle state.");
        }
    }

    public void clearItem(int shelfId) {
        if(state instanceof IdleState) {
            ((IdleState) state).clearItem(this,shelfId);
        } else {
            System.out.println("The state has to be in idle state.");
        }
    }

    public void addItem(Request request) {
        if(state instanceof IdleState) {
            ((IdleState) state).addItem(this, request);
        } else {
            System.out.println("The state has to be in idle state.");
        }
    }

    public void removeItemFromShelf(Request request) {
        if(state instanceof IdleState) {
            ((IdleState) state).removeItem(this, request);
        } else {
            System.out.println("The state has to be in idle state.");
        }
    }

    public void changeToSelectProduct() {
        if(state instanceof IdleState) {
            ((IdleState) state).changeToSelectItem(this);
        } else {
            System.out.println("The state has to be in idle state.");
        }
    }

    public void selectItem(Request request) {
        if(state instanceof ActiveState) {
            ((ActiveState) state).selectItem(this, request);
        } else {
            System.out.println("The state has to be in active state.");
        }
    }

    public void removeItemFromCart(Request request) {
        if(state instanceof ActiveState) {
            ((ActiveState) state).removeItem(this, request);
        } else {
            System.out.println("The state has to be in active state.");
        }
    }

    public void cancelFromActiveState() {
        if(state instanceof ActiveState) {
            ((ActiveState) state).cancel(this);
        } else {
            System.out.println("The state has to be in active state.");
        }
    }

    public void changeToPayment() {
        if(state instanceof ActiveState) {
            ((ActiveState) state).changeToPayment(this);
        } else {
            System.out.println("The state has to be in active state.");
        }
    }

    public void addCoin(CoinType coinType) {
        if(state instanceof PaymentState) {
            ((PaymentState) state).addCoin(this, coinType);
        } else {
            System.out.println("The state has to be in payment state.");
        }
    }

    public void addNote(NoteType noteType) {
        if(state instanceof PaymentState) {
            ((PaymentState) state).addNote(this, noteType);
        } else {
            System.out.println("The state has to be in payment state.");
        }
    }

    public void cancelFromPaymentState() {
        if(state instanceof PaymentState) {
            ((PaymentState) state).cancel(this);
        } else {
            System.out.println("The state has to be in payment state.");
        }
    }

    public void returnChange() {
        if(state instanceof PaymentState) {
            Change change = ((PaymentState) state).returnChange(this);
            if(change != null) {
                System.out.println("Total change: " + change.getTotalAmount());
            } else {
                System.out.println("Error in returning change. Cancel or add money.");
            }
        } else {
            System.out.println("The state has to be in payment state.");
        }
    }

    public void dispenseProduct() {
        if(state instanceof DispenseState) {
            ((DispenseState) state).dispenseProduct(this);
        } else {
            System.out.println("The state has to be in dispense state.");
        }
    }

    public void displayAmount() {
        System.out.println("Amount: " + cashProxy.totalAmount());
    }

    public void displayItems() {
        inventoryProxy.displayItems();
    }
}
