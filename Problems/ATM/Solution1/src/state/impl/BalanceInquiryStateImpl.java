package state.impl;

import atm.Atm;
import state.BalanceInquiryState;

public class BalanceInquiryStateImpl implements BalanceInquiryState {
    @Override
    public int getBalance(Atm atm) {
        return atm.getCard().getBalance();
    }

    @Override
    public void exit(Atm atm) {
        atm.setState(new ActiveStateImpl());
    }
}
