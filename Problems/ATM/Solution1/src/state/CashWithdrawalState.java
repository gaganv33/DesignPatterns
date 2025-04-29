package state;

import atm.Atm;
import data.NoteType;

import java.util.Map;

public interface CashWithdrawalState extends State {
    Map<NoteType, Integer> cashWithdraw(Atm atm, int amount);
    void exit(Atm atm);
}
