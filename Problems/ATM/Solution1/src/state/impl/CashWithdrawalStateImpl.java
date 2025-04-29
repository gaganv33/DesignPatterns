package state.impl;

import atm.Atm;
import data.NoteType;
import processor.CashProcessor;
import processor.CashProcessorFactory;
import state.CashWithdrawalState;

import java.util.Map;

public class CashWithdrawalStateImpl implements CashWithdrawalState {
    private final CashProcessor cashProcessor;
    public CashWithdrawalStateImpl() {
        this.cashProcessor = CashProcessorFactory.cashProcessor;
    }

    @Override
    public Map<NoteType, Integer> cashWithdraw(Atm atm, int amount) {
        if(atm.getCard().checkIfEnoughBalance(amount)) {
            Map<NoteType, Integer> notes = cashProcessor.withdrawNotes(atm, amount);
            if(notes == null) return null;
            atm.getCard().withdrawAmount(notes);
            return notes;
        }
        return null;
    }

    @Override
    public void exit(Atm atm) {
        atm.setState(new ActiveStateImpl());
    }
}
