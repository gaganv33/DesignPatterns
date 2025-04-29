package state.impl;

import atm.Atm;
import state.ActiveState;

public class ActiveStateImpl implements ActiveState {
    @Override
    public void logout(Atm atm) {
        atm.setState(new IdleStateImpl(atm));
    }

    @Override
    public void changeToCashWithdrawalState(Atm atm) {
        atm.setState(new CashWithdrawalStateImpl());
    }

    @Override
    public void changeToCashDepositState(Atm atm) {
        atm.setState(new CashDepositStateImpl());
    }

    @Override
    public void changeToBalanceInquiryState(Atm atm) {
        atm.setState(new BalanceInquiryStateImpl());
    }
}
