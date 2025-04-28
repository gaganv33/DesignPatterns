package state.impl;

import dto.request.ItemData;
import data.VendingMachineData;
import state.DispenseState;
import vendingMachine.VendingMachine;

public class DispenseStateImpl implements DispenseState {
    @Override
    public void dispenseProduct(VendingMachine vendingMachine) {
        VendingMachineData vendingMachineData = vendingMachine.getVendingMachineData();
        System.out.println("Dispensing items.");
        for(var entrySet : vendingMachineData.getItems().entrySet()) {
            ItemData itemData = entrySet.getKey();
            int number = entrySet.getValue();
            System.out.println(itemData.getItem().getName() + " " + number);
        }
        vendingMachine.setState(new IdleStateImpl(vendingMachine));
    }
}
