package state;

import atm.Atm;

public interface BalanceInquiryState extends State {
    int getBalance(Atm atm);
    void exit(Atm atm);
}
