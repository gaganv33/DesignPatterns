package state.impl;

import atm.Atm;
import data.NoteType;
import state.CashDepositState;

import java.util.Map;

public class CashDepositStateImpl implements CashDepositState {
    @Override
    public void cashDeposit(Atm atm, Map<NoteType, Integer> notes) {
        atm.getCard().depositAmount(notes);
    }

    @Override
    public void exit(Atm atm) {
        atm.setState(new ActiveStateImpl());
    }
}
