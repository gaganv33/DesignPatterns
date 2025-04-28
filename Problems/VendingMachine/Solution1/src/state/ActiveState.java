package state;

import dto.request.Request;
import vendingMachine.VendingMachine;

public interface ActiveState extends State {
    void selectItem(VendingMachine vendingMachine, Request request);
    void removeItem(VendingMachine vendingMachine, Request request);
    void cancel(VendingMachine vendingMachine);
    void changeToPayment(VendingMachine vendingMachine);
}
