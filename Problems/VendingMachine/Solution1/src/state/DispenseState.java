package state;

import vendingMachine.VendingMachine;

public interface DispenseState extends State {
    void dispenseProduct(VendingMachine vendingMachine);
}
