package state;

import atm.Atm;

public interface ActiveState extends State {
    void logout(Atm atm);
    void changeToCashWithdrawalState(Atm atm);
    void changeToCashDepositState(Atm atm);
    void changeToBalanceInquiryState(Atm atm);
}
