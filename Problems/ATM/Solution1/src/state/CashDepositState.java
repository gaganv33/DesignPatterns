package state;

import atm.Atm;
import data.NoteType;

import java.util.Map;

public interface CashDepositState extends State {
    void cashDeposit(Atm atm, Map<NoteType, Integer> notes);
    void exit(Atm atm);
}
