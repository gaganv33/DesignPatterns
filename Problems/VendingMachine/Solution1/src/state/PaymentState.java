package state;

import dto.response.Change;
import data.CoinType;
import data.NoteType;
import vendingMachine.VendingMachine;

public interface PaymentState extends State {
    void addCoin(VendingMachine vendingMachine, CoinType coinType);
    void addNote(VendingMachine vendingMachine, NoteType noteType);
    void cancel(VendingMachine vendingMachine);
    Change returnChange(VendingMachine vendingMachine);
}
